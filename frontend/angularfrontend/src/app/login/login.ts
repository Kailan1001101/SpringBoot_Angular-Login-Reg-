import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  imports: [],
  templateUrl: './login.html',
  styleUrl: './login.scss'
})
export class Login {

  username = '';
  password = '';
  message = '';

  onSubmit() {
    this.message = `Logging in with: ${this.username} / ${this.password}`;
    // Later: call backend here
  }
}
