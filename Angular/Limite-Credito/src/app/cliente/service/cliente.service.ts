import { Injectable } from '@angular/core';

import { ClienteModel } from '../model/cliente.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';


@Injectable()
export class ClienteService {

  constructor(private http: HttpClient) { }

  saveCliente(cliente: ClienteModel): Observable<any> {
    return this.http.post("http://localhost:8090/limite-credito/cliente/", cliente);
  }

  listAllCliente(): Observable<any>  {
    return this.http.get("http://localhost:8090/limite-credito/cliente/");
  }

}
