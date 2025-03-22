
export class Courses {
    id: number;
    title: string;
    level: string;
    description: string;
  
    constructor(id: number, title: string = '', level: string = '', description: string = '') {
      this.id = id;
      this.title = title;
      this.level = level;
      this.description = description;
    }
  }
  
  
  