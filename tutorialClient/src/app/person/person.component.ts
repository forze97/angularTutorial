import { Component, OnInit } from '@angular/core';
import {PersonService} from '../person.service';

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent implements OnInit {
  person: any = {
    name: '',
    age: '',
    gender: '',
    blood: ''
  };

  bloods: any;

  genders: any;

  constructor(private personService: PersonService) { }

  ngOnInit() {
    this.personService.getAllBloodType().subscribe(data => {
      this.bloods = data;
    });
    this.personService.getAllGender().subscribe(data => {
      this.genders = data;
    });
  }

  save() {
    this.personService.savePerson(this.person, this.person.gender, this.person.blood).subscribe(result => {
    }, error => console.error(error));
  }

}
