import { Component, OnInit } from '@angular/core';
import { Pregled } from '../add-new-pregled/add-new-pregled.component';
import { PacijentService } from '../service/pacijent.service';
import { ZubarService } from '../service/zubar.service';

@Component({
  selector: 'app-lista-pregleda-pacijenta',
  templateUrl: './lista-pregleda-pacijenta.component.html',
  styleUrls: ['./lista-pregleda-pacijenta.component.css']
})
export class ListaPregledaPacijentaComponent implements OnInit {
  id: String;
  pregledi: Pregled[]
  constructor(private zubarService: ZubarService,
              private pacijentService: PacijentService
              ) { }

  ngOnInit(): void {
    this.id = sessionStorage.getItem('loggedUserId');
    this.pacijentService.getAllPregledi(this.id).subscribe((res)=>
    {
      this.pregledi = res;
    });
  }
  deletePregled(pregled: Pregled): void{
    this.zubarService.deletePregled(pregled.id).subscribe((res)=>{this.ngOnInit();})
  }
  


}
