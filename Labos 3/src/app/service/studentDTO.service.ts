import {Injectable} from "@angular/core";
import StudentDTO from "../model/studentDTO.model";
import {Observable, of} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class StudentDTOService{
  studentsDTO: Array<StudentDTO> =[
    {
      jmbag: '01010101010',
      firstName: 'Ivo',
      lastName: 'Ivic',
      clearedECTS: 60,
      remainingECTS: 120,
      tuition: false
    },
    {
      jmbag: '01010101011',
      firstName: 'Pero',
      lastName: 'Peric',
      clearedECTS: 80,
      remainingECTS: 100,
      tuition: false
    },
    {
      jmbag: '02020202022',
      firstName: 'Marko',
      lastName: 'Markovic',
      clearedECTS: 10,
      remainingECTS: 170,
      tuition: true
    },
    {
      jmbag: '03030303033',
      firstName: 'Ivo',
      lastName: 'Ivic',
      clearedECTS: 60,
      remainingECTS: 120,
      tuition: false
    },
    {
      jmbag: '01010101010',
      firstName: 'Domagoj',
      lastName: 'Domagojski',
      clearedECTS: 0,
      remainingECTS: 180,
      tuition: true
    }
  ];
  constructor(){
  }

  getStudentDTO(): Observable<StudentDTO[]>{
    return of(this.studentsDTO)
  }
}
