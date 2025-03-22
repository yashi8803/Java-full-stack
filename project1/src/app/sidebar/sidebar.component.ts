import { Component } from '@angular/core';

@Component({
  selector: 'app-sidebar',
  standalone: true,
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent {
  
  toggleSidebar() {
    document.querySelector('.sidebar')?.classList.toggle('active');
  }

  toggleSubMenu(event: Event) {
    const clickedItem = (event.currentTarget as HTMLElement);
    clickedItem.classList.toggle('active');

    const subMenu = clickedItem.querySelector('.sub-menu') as HTMLElement;
    if (subMenu) {
      if (subMenu.style.display === 'block') {
        subMenu.style.display = 'none';
      } else {
        subMenu.style.display = 'block';
      }
    }
    
    // Close other open submenus
    document.querySelectorAll('.menu ul li').forEach(li => {
      if (li !== clickedItem && li.classList.contains('active')) {
        li.classList.remove('active');
        const otherSubMenu = li.querySelector('.sub-menu') as HTMLElement;
        if (otherSubMenu) otherSubMenu.style.display = 'none';
      }
    });
  }
}