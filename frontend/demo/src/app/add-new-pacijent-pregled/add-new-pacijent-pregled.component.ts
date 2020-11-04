import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Pregled } from '../add-new-pregled/add-new-pregled.component';
import { PacijentService } from '../service/pacijent.service';
import { ZubarService } from '../service/zubar.service';

@Component({
  selector: 'app-add-new-pacijent-pregled',
  templateUrl: './add-new-pacijent-pregled.component.html',
  styleUrls: ['./add-new-pacijent-pregled.component.css']
})
export class AddNewPacijentPregledComponent implements OnInit {

  pregledForm: FormGroup;
  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private zubarService: ZubarService,
    private pacijentService: PacijentService
  ) {
    this.pregledForm = this.formBuilder.group({
      pacijentId: [],
      vreme: [],
      trajanje: [],
    });
   }

  ngOnInit(): void {
    this.pregledForm = this.formBuilder.group({
      zubarId: [],
      pacijentId: [sessionStorage.getItem('loggedUserId')],
      vreme: [],
      trajanje: [],
    });
  }
  addPregled(){
    var pregled: Pregled = {
      id: 0,
      zubar: {
        id: this.pregledForm.value.zubarId,
      },
      pacijent: {
        id: this.pregledForm.value.pacijentId,
      },
      vreme: this.pregledForm.value.vreme,
      trajanje: this.pregledForm.value.trajanje
    };
    this.zubarService.createPregled(pregled).subscribe((res) => { console.log(res);
    });
    

  }

}
