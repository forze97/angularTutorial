import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  constructor(private http: HttpClient) { }

  getAllBloodType(): Observable<any> {
    return this.http.get('//localhost:8080/blood');
  }
  getAllGender(): Observable<any> {
    return this.http.get('//localhost:8080/gender');
  }

  savePerson(form: any, gender: string, blood: string) {
    let result: Observable<Object>;
    result = this.http.post('//localhost:8080/person/' + blood + '/' + gender, form);
    return result;
  }

}
