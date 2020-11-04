import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  username = '';
  userType: String;
  constructor(private httpClient: HttpClient) { }

  public verifyLoginInfo(username) {
    return this.httpClient.get('http://localhost:8080/login/' + username, {
      responseType: 'text', }).subscribe((res)=>{this.userType = res;
    });
  }
  logOut(){
    sessionStorage.removeItem('username');
    sessionStorage.removeItem('loggedUserId');
    this.userType = '';
  }
  isUserLoggedIn(){
    let user = sessionStorage.getItem('username');
    return !(user === null);
  }

}
