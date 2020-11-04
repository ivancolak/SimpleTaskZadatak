import { Component, OnInit } from '@angular/core';
import { Pregled } from '../add-new-pregled/add-new-pregled.component';
import { ZubarService } from '../service/zubar.service';

@Component({
  selector: 'app-lista-pregleda',
  templateUrl: './lista-pregleda.component.html',
  styleUrls: ['./lista-pregleda.component.css']
})
export class ListaPregledaComponent implements OnInit {
  pregledi: Pregled[]
  constructor(private zubarService: ZubarService) { }

  ngOnInit(): void {
    this.zubarService.getAllPregledi().subscribe((res)=>
    {
      this.pregledi = res;
    });
  }
  deletePregled(pregled: Pregled): void{
    this.zubarService.deletePregled(pregled.id).subscribe((res)=>{this.ngOnInit();})
  }
  

}
