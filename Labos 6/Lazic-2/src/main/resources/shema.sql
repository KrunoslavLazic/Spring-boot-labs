drop table if exists student;
drop table if exists course;
drop table if exists student_course;

create table if not exists student(
    id identity,
    jmbag varchar(10) not null unique,
    first_name varchar(100) not null,
    last_name varchar(100) not null,
    ects_points number not null,
    date_of_birth date not null,
    town_name varchar(100) not null,
    academic_year number not null,
    college_name varchar(100) not null
);

create table if not exists course(
    id identity,
    name varchar(100) not null,
    ects_points number not null
);

create table if not exists student_course(
    student_id bigint,
    course_id bigint,
    primary key (student_id,course_id),
    constraint fk_student foreign key(student_id) references student(id),
    constraint fk_course foreign key(course_id) references course(id)
);