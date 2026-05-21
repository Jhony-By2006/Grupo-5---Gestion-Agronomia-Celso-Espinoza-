import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Reporte } from '../models/reporte';

@Injectable({
  providedIn: 'root'
})
export class ReporteService {

  private apiUrl = 'http://localhost:8080/api/reportes';

  constructor(private http: HttpClient) {}

  // LISTAR TODOS LOS REPORTES
  listar(): Observable<Reporte[]> {
    return this.http.get<Reporte[]>(this.apiUrl);
  }

  // OBTENER UNO POR ID
  obtener(id: number): Observable<Reporte> {
    return this.http.get<Reporte>(`${this.apiUrl}/${id}`);
  }

  // 📌 CREAR NUEVO REPORTE
  crear(data: Reporte): Observable<Reporte> {
    return this.http.post<Reporte>(this.apiUrl, data);
  }

  // ACTUALIZAR REPORTE
  actualizar(id: number, data: Reporte): Observable<Reporte> {
    return this.http.put<Reporte>(`${this.apiUrl}/${id}`, data);
  }

  //  ELIMINAR REPORTE
  eliminar(id: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
}
