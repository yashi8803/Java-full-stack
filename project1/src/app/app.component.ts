import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Courses } from './courses';
import { NavbarComponent } from './navbar/navbar.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,CommonModule, NavbarComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'project1';

  imagePath = 'assets/images.png';
  bool_value = false;
  changebutton() {
    this.bool_value = !this.bool_value;
  }

  courses: Courses[];
  
  constructor() {
    this.courses = [
      new Courses(1, 'Angular', 'Beginner', 'Angular for beginners'),
      new Courses(2, 'React', 'Intermediate', 'React for intermediate developers'),
      new Courses(3, 'Vue', 'Advanced', 'Vue for advanced developers')
    ];
  }
}


