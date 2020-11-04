import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Pregled } from '../add-new-pregled/add-new-pregled.component';
import { Zubar } from '../zubar/zubar.component';

@Injectable({
  providedIn: 'root'
})
export class ZubarService {

  constructor(
    private httpClient: HttpClient
  ) { }


  public getLogedinUser(id){
    return this.httpClient.get<Zubar>('http://localhost:8080/zubar/'+id);
  }

  public createPregled(pregled: Pregled){
    return this.httpClient.post<Pregled>(
      'http://localhost:8080/pregled/add', pregled);
    
  }

  public getAllPregledi(): Observable<Pregled[]>{
    return this.httpClient.get<Pregled[]>(
      'http://localhost:8080/pregled/all'
    );
  }
  public deletePregled(id: Number){
    return this.httpClient.delete<Pregled>(
      'http://localhost:8080/pregled/'+id+'/delete')
  };
}



