import { Component, OnInit } from '@angular/core';
import { ReporteService } from '../../../services/reporte.service';
import { Reporte } from '../../../models/reporte';

@Component({
  selector: 'app-reporte-list',
  templateUrl: './reporte-list.component.html'
})
export class ReporteListComponent implements OnInit {

  reportes: Reporte[] = [];

  constructor(private reporteService: ReporteService) {}

  ngOnInit(): void {
    this.cargar();
  }

  cargar(): void {
    this.reporteService.listar().subscribe(data => {
      this.reportes = data;
    });
  }

  eliminar(id: number): void {
    this.reporteService.eliminar(id).subscribe(() => {
      this.cargar();
    });
  }
}
