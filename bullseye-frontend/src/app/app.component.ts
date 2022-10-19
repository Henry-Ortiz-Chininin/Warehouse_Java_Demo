import { Component } from '@angular/core';

import { LoginService } from './login/login.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'Bullseye System';

  //isLogged:boolean;

  constructor(private loginService: LoginService) { }

  ngOnInit(): void {
    //this.isLogged = this.loginService.checkLogin();
  }

  isLogged():boolean{
    return this.loginService.checkLogin();
  }
}
