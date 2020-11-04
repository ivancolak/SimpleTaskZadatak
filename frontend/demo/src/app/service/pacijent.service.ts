import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pregled } from '../add-new-pregled/add-new-pregled.component';
import { Pacijent } from '../pacijent/pacijent.component';

@Injectable({
  providedIn: 'root'
})
export class PacijentService {

  constructor(
    private httpClient: HttpClient
  ) { }
  

  
  public getLogedinUser(id){
    return this.httpClient.get<Pacijent>('http://localhost:8080/pacijent/'+id);
  }

  public getAllPregledi(id): Observable<Pregled[]>{
    return this.httpClient.get<Pregled[]>(
      'http://localhost:8080/pregled/'+id+'/allById'
    );
  }
}
