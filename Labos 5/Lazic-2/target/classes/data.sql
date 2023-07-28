
insert into student (id, first_name, last_name, jmbag, ects_points, date_of_birth,
                     town_name,academic_year, college_name ) values
(1,'Ivo','Ivic','0246053232',120,NOW(),
 'Zagreb',3,'TVZ'),
(2,'Pero','Peric','0246053435',120,NOW(),
 'Zagreb',2,'FER'),
(3,'Marko','Markovic','0246053123',100,NOW(),
 'Zagreb',1,'TVZ'),
(4,'Pero','Peric','0246053445',30,NOW(),
 'Zagreb',2,'FER');

insert into course(id, name, ects_points) values
(1,'Web aplikacije u Javi',6),
(2,'Programiranje u jeziku Java',5);

insert into student_course(id, student_id, course_id) values
(1,1,1),
(2,2,1),
(3,2,2);