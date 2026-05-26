import { Component, OnInit } from '@angular/core';
import { TrabajadorService } from '../../../services/trabajador.service';
import { Trabajador } from '../../../models/trabajador';

@Component({
  selector: 'app-trabajador-list',
  templateUrl: './trabajador-list.component.html'
})
export class TrabajadorListComponent implements OnInit {

  trabajadores: Trabajador[] = [];

  constructor(private trabajadorService: TrabajadorService) {}

  ngOnInit(): void {
    this.cargar();
  }

  cargar(): void {
    this.trabajadorService.listar().subscribe(data => {
      this.trabajadores = data;
    });
  }

  eliminar(id: number): void {
    this.trabajadorService.eliminar(id).subscribe(() => {
      this.cargar();
    });
  }
}
