import { Component } from '@angular/core';
import { Auth } from '../../services/auth';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, RouterLink],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {
  user = {
    email: '',
    password: '',
  };

  constructor(private authService: Auth, private router: Router) {}

  login() {
    this.authService.login(this.user).subscribe({
      next: (res) => {
        this.authService.saveToken(res.token);
        this.authService.saveUser(res);

        this.router.navigate(['/recommend']);
      },
      error: () => {
        alert('Invalid credentials');
      },
    });
  }
}
