import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { LoginModel } from '../models/login.model';
import {MatDialog} from '@angular/material';
import {FormGroup , FormBuilder,Validators} from '@angular/forms';
import { RegistrationComponent } from '../registration/registration.component';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
   user: LoginModel= new LoginModel();
   loginForm: FormGroup;
   hide = true;
  constructor( private formBuilder: FormBuilder ,private router:Router ) { }
  
  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      'userName' : [this.user.userId,[
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
  onLoginSubmit() {
    this.router.navigate(['registration'])
   alert(this.user.userId+ ' ' + this.user.password);
  }
}
