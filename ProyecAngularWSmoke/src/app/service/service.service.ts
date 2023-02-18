import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Categoria } from '../interfaces/Product';
import { Observable, share } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  private url = 'http://localhost:8080/';
  
  constructor(private http: HttpClient) { }


  getObject(url:string): Observable<any>{
    return this.http.get(this.url+url).pipe(share());
  }

  insertObject(url:string, dto:any): Observable<any>{
    return this.http.post(this.url+url, dto).pipe(share());
  }
 
  updateObject(url:string, dto:any): Observable<any>{
    return this.http.put(this.url+url, dto).pipe(share());
  }

  deleteObject(url:string): Observable<any>{
    return this.http.delete(this.url+url).pipe(share());
  }
} 
