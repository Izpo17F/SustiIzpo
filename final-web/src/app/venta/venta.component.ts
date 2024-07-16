import { MatCardModule } from '@angular/material/card';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { VentaResulatdo } from '../model/ventaResultado.interface';
import { venta } from '../model/venta.interface';
import { VentaService } from '../service/venta.service';

@Component({
  selector: 'app-venta',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, MatInputModule, MatButtonModule, MatCardModule],
  templateUrl: './venta.component.html',
  styleUrls: ['./venta.component.css']
})
export class VentaComponent {
  ventaForm: FormGroup;
  resultado?: VentaResulatdo;

  constructor(private fb: FormBuilder, private ventaService: VentaService) {
    this.ventaForm = this.fb.group({
      nombreProducto: ['', Validators.required],
      cantidad: [0, [Validators.required, Validators.min(1)]],
      precioUnitario: [0, [Validators.required, Validators.min(0.01)]],
      fechaVenta: ['', Validators.required]
    });
  }

  registrarVenta(): void {
    if (this.ventaForm.valid) {
      const venta: venta = this.ventaForm.value;
      this.ventaService.registrarVenta(venta).subscribe((resultado) => {
        this.resultado = resultado;
      });
    }
  }
}
