import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../model/user';
import { UserService } from '../user-service/user.service';

@Component({
  selector: 'app-user-update',
  templateUrl: './user-update.component.html',
  styleUrls: ['./user-update.component.css']
})
export class UserUpdateComponent implements OnInit {

  id: number;
  user: User = new User();

  constructor(private userService: UserService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {

    this.id =  this.route.snapshot.params['id'];
    this.userService.getUserById(this.id)
    .subscribe(data => {
       this.user= data.Data;

       console.log(this.user);

    }, error => console.log(error));
  }

  onSubmit(){
    this.userService.updateUser(this.id, this.user).subscribe ( data =>{
      this.goToUserList();
    },
    error => console.log(error));

  }
  goToUserList(){
    this.router.navigate(['/users']);

  }
}
