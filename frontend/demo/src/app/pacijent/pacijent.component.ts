import { Component, OnInit } from '@angular/core';
import { PacijentService } from '../service/pacijent.service';

@Component({
  selector: 'app-pacijent',
  templateUrl: './pacijent.component.html',
  styleUrls: ['./pacijent.component.css']
})
export class PacijentComponent implements OnInit {

  id: String;
  pacijent: Pacijent;
  constructor(
    private pacijentService: PacijentService
  ) { }

  ngOnInit(){
    this.id = sessionStorage.getItem('loggedUserId');
    this.pacijentService.getLogedinUser(this.id).subscribe((res) => {
      this.pacijent = res;

  
    });
  }

}

export class Pacijent{
  id: string;
  ime: string;
  jmbg: string;
}