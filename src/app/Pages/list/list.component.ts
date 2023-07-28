import { Component } from '@angular/core';
import Student from "../../model/student.model";
import {StudentService} from "../../service/student.service";
import {StudentDTOService} from "../../service/studentDTO.service";
import StudentDTO from "../../model/studentDTO.model";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent {

  selectedStudent? : Student;
  selectedStudentDTO? : StudentDTO;

  constructor(
    public studentService: StudentService,
    public studentDTOService: StudentDTOService
  ) {
  }
  onStudentSelected(student: Student){
      this.selectedStudent=student
  }
  onStudentDTOSelected(student: StudentDTO){
    this.selectedStudentDTO=student
  }


}
