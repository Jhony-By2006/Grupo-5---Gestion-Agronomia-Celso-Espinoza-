import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Trabajador } from '../models/trabajador';

@Injectable({
  providedIn: 'root'
})
export class TrabajadorService {

  private apiUrl = 'http://localhost:8080/api/trabajadores';

  constructor(private http: HttpClient) {}

  //  LISTAR TODOS
  listar(): Observable<Trabajador[]> {
    return this.http.get<Trabajador[]>(this.apiUrl);
  }

  //  OBTENER POR ID
  obtener(id: number): Observable<Trabajador> {
    return this.http.get<Trabajador>(`${this.apiUrl}/${id}`);
  }

  // CREAR
  crear(data: Trabajador): Observable<Trabajador> {
    return this.http.post<Trabajador>(this.apiUrl, data);
  }

  //  ACTUALIZAR
  actualizar(id: number, data: Trabajador): Observable<Trabajador> {
    return this.http.put<Trabajador>(`${this.apiUrl}/${id}`, data);
  }

  //  ELIMINAR
  eliminar(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
}
