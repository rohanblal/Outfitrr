import { Component } from '@angular/core';
import { Auth } from '../../services/auth';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule, RouterLink],
  templateUrl: './register.html',
  styleUrl: './register.css',
})
export class Register {
  user = {
    name: '',
    email: '',
    password: '',
  };

  constructor(private authService: Auth, private router:Router) {}

  register() {
    this.authService.register(this.user).subscribe({
      next: (res) => {
        this.authService.saveToken(res.token);
        this.authService.saveUser(res);

this.router.navigate(['/recommend']);

        alert('Registration successful');
        window.location.href = '/recommend';
      },
      error: () => {
        alert('Registration failed');
      },
    });
  }
}
