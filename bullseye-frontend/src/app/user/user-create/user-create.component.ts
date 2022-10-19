import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { ProductCategory } from 'src/app/product/model/product-category.enum';
import { User } from '../model/user';
import { UserService } from '../user-service/user.service';

@Component({
  selector: 'app-user-create',
  templateUrl: './user-create.component.html',
  styleUrls: ['./user-create.component.css']
})
export class UserCreateComponent implements OnInit {

  user: User = new User();


  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }
  saveUser(){
    this.userService.createUser(this.user).subscribe( data => {
     console.log(data);
     alert(`User successfully created`)
     this.goToUserList();
    },
    error => console.log(error));

  }
  goToUserList(){
    this.router.navigate(['/users']);

  }
  onSubmit(){
    console.log(this.user);
    this.saveUser();

  }
}
