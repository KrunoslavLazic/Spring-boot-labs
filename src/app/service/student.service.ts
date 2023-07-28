import {Injectable} from "@angular/core";
import Student from "../model/student.model";
import {Observable, of} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class StudentService{
  students: Array<Student> =[
    {
      jmbag: '01010101010',
      eCTS: 120,
      tuition: true
    },
    {
      jmbag: '00001111101',
      eCTS: 20,
      tuition: true
    },
    {
      jmbag: '00000000001',
      eCTS: 180,
      tuition: false
    }
  ];
  constructor(){
  }
  getStudent(): Observable<Student[]>{
    return of(this.students)
  }
}
