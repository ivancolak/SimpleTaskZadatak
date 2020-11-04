import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = '';
  invalidLogin = false;
  userId = '';
  constructor(
    private router: Router,
    private loginCheckService: LoginService
  ) { }

  ngOnInit() {}

  checkLogin(){
    this.loginCheckService.verifyLoginInfo(this.username);
    var splitted = this.loginCheckService.userType.split('/', 2)
    if (splitted[0] === 'zubar'){
      sessionStorage.setItem('loggedUserId', splitted[1]);
      sessionStorage.setItem('username', this.username);
      this.router.navigate(['/zubar']);
      this.invalidLogin = false;
      this.loginCheckService.username = '';
      return;
  }
    else if (splitted[0] === 'pacijent'){
      sessionStorage.setItem('loggedUserId', splitted[1]);
      sessionStorage.setItem('username', this.username);
      this.router.navigate(['/pacijent']);
      this.invalidLogin = false;
      this.loginCheckService.username = '';
      this.loginCheckService.userType = '';
      return;
    } else this.invalidLogin = true;
}
}