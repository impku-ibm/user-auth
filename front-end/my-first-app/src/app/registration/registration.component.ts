import { Component, OnInit } from '@angular/core';
import { RegisterModel } from '../models/register.model';
import {FormGroup,FormBuilder,Validators} from '@angular/forms';
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
 user: RegisterModel = new RegisterModel();
 registerForm:FormGroup;
 hide= true;
  constructor(private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.registerForm=this.formBuilder.group({
      'name':[this.user.userId,[
        Validators.required
      ]],
      'email':[this.user.email,[
        Validators.required,
        Validators.email
      ]],
      'password':[this.user.password,[
        Validators.required,
        Validators.minLength(6),
        Validators.maxLength(16)
      ]]
    });
  }
  onRegisterSubmit(){
    alert(this.user.userId + ' ' + this.user.email + ' ' + this.user.password);
  }
}
