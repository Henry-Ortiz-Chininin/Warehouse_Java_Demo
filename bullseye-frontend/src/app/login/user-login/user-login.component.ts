import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import { Userlogin } from '../model/userlogin';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

 
  user : Userlogin = new Userlogin();
  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit(): void {

  }

  // userLogin(){
  //   this.loginService.userLogin(this.user).subscribe( data => {
  //     console.log(data);

  //     },
  //    error => console.log(error));

  //  }
  userLogin(){

    this.loginService.userLogin(this.user).subscribe( data => {

      console.log(data);

      if(data.Status!="OK"){
        alert(data.Error.message);
        this.router.navigate(['/login'])
      }else if(data.Status=="OK"){
        localStorage.setItem('session', JSON.stringify(data.Data));
        this.router.navigate(['/home'])
      }

      },
     error => console.log(error));



   }

}
