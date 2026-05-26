import { Component } from '@angular/core';
import { ReporteService } from '../../../services/reporte.service';
import { Reporte } from '../../../models/reporte';

@Component({
  selector: 'app-reporte-form',
  templateUrl: './reporte-form.component.html'
})
export class ReporteFormComponent {

  reporte: Reporte = {
    titulo: '',
    descripcion: '',
    fecha: ''
  };

  constructor(private reporteService: ReporteService) {}

  guardar(): void {
    this.reporteService.crear(this.reporte).subscribe(() => {
      alert('Reporte creado correctamente');
      this.reporte = { titulo: '', descripcion: '', fecha: '' };
    });
  }
}
