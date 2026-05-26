import { Component } from '@angular/core';
import { TrabajadorService } from '../../../services/trabajador.service';
import { Trabajador } from '../../../models/trabajador';

@Component({
  selector: 'app-trabajador-form',
  templateUrl: './trabajador-form.component.html'
})
export class TrabajadorFormComponent {

  trabajador: Trabajador = {
    nombre: '',
    apellido: '',
    dni: '',
    cargo: ''
  };

  constructor(private trabajadorService: TrabajadorService) {}

  guardar(): void {
    this.trabajadorService.crear(this.trabajador).subscribe(() => {
      alert('Trabajador creado correctamente');

      // limpiar formulario
      this.trabajador = {
        nombre: '',
        apellido: '',
        dni: '',
        cargo: ''
      };
    });
  }
}
