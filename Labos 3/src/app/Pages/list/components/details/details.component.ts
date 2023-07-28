import {Component, Input} from '@angular/core';
import Student from "../../../../model/student.model";
import StudentDTO from "../../../../model/studentDTO.model";

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent{

  @Input() student!: Student;
  @Input() studentDTO!: StudentDTO;

  protected readonly parseInt = parseInt;
}
