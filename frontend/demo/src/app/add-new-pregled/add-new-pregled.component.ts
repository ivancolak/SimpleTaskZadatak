import { createOfflineCompileUrlResolver } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { ZubarService } from '../service/zubar.service';

@Component({
  selector: 'app-add-new-pregled',
  templateUrl: './add-new-pregled.component.html',
  styleUrls: ['./add-new-pregled.component.css']
})
export class AddNewPregledComponent implements OnInit {
  pregledForm: FormGroup;
  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private zubarService: ZubarService
  ) {
    this.pregledForm = this.formBuilder.group({
      pacijentId: [],
      vreme: [],
      trajanje: [],
    });
   }

  ngOnInit(): void {
    this.pregledForm = this.formBuilder.group({
      zubarId: [sessionStorage.getItem('loggedUserId')],
      pacijentId: [],
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

export class Pregled{
  id: Number;
  zubar: {
    id: string;
  };
  pacijent: {
    id: string;
  };
  vreme: string;
  trajanje: string;
}