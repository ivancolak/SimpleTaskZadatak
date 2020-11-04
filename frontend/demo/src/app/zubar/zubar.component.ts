import { Component, OnInit } from '@angular/core';
import { ZubarService } from '../service/zubar.service';

@Component({
  selector: 'app-zubar',
  templateUrl: './zubar.component.html',
  styleUrls: ['./zubar.component.css']
})
export class ZubarComponent implements OnInit {
  id: String;
  zubar: Zubar;
  constructor(
    private zubarService: ZubarService
  ) { }

  ngOnInit(){
    this.id = sessionStorage.getItem('loggedUserId');
    this.zubarService.getLogedinUser(this.id).subscribe((res) => {
      this.zubar = res;

  
    });
  }

}


export class Zubar{
  id: string;
  ime: string;
  jmbg: string;
}