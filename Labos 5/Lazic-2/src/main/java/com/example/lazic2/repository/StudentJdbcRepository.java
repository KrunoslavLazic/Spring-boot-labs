package com.example.lazic2.repository;

import com.example.lazic2.domain.Student;
import com.example.lazic2.domain.StudentDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
@Primary
public class StudentJdbcRepository implements StudentRepository{

    private static final String SELECT_ALL =
            "SELECT id, jmbag, first_name, last_name, ects_points, date_of_birth, town_name,academic_year,college_name FROM student";
    private final JdbcTemplate jdbc;
    private final SimpleJdbcInsert inserter;

    public StudentJdbcRepository(DataSource dataSource) {
        this.jdbc = new JdbcTemplate(dataSource);
        this.inserter = new SimpleJdbcInsert(dataSource)
                .withTableName("student");
    }
    @Override
    public List<Student> findAllByCollege(String collegeName) {
        return jdbc.query(SELECT_ALL + " WHERE college_name = ?",this::mapRowToStudent,collegeName);
    }

    @Override
    public List<Student> findAllByAcademicYear(String academicYear) {
        return jdbc.query(SELECT_ALL + " WHERE academic_year = ?", this::mapRowToStudent,academicYear);
    }

    @Override
    public List<Student> findAll() {
        return jdbc.query("SELECT * FROM STUDENT;",this::mapRowToStudent);
    }

    @Override
    public Optional<Student> findStudentByJMBAG(String jmbag) {
        try{
            return Optional.ofNullable(
                    jdbc.queryForObject(SELECT_ALL + " WHERE jmbag = ?", this::mapRowToStudent,jmbag)
            );
        }
        catch (EmptyResultDataAccessException ex){
            return Optional.empty();
        }
    }
    @Override
    public Optional<Student> save(Student student) {
        try{
            student.setId(saveStudentDetails(student));
            return Optional.of(student);
        }
        catch (DuplicateKeyException ex){
            return Optional.empty();
        }
    }
    @Override
    public void deleteByJMBAG(String jmbag) {
        jdbc.update("DELETE FROM student WHERE jmbag = ?", jmbag);
    }



    private Student mapRowToStudent(ResultSet rs, int rowNum) throws SQLException{
        return new Student(
                rs.getLong("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("jmbag"),
                rs.getInt("ects_points"),
                rs.getDate("date_of_birth").toLocalDate(),
                rs.getString("town_name"),
                rs.getString("college_name"),
                rs.getInt("academic_year")
        );
    }
    private long saveStudentDetails(Student student){
        Map<String, Object> values = new HashMap<>();

        values.put("first_name",student.getFirstName());
        values.put("last_name",student.getLastName());
        values.put("jmbag",student.getJmbag());
        values.put("date_of_birth",student.getDateOfBirth());
        values.put("ects_points",student.getNumberOfECTS());

        values.put("town_name",student.getTownName());
        values.put("college_name",student.getCollegeName());
        values.put("academic_year", student.getAcademicYear());

        return inserter.executeAndReturnKey(values).longValue();
    }
}
