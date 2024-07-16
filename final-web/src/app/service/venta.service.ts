import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { venta } from '../model/venta.interface';
import { VentaResulatdo } from '../model/ventaResultado.interface';
import { envs } from '../../env/envs';

@Injectable({
  providedIn: 'root'
})
export class VentaService {
  private httpClient = inject(HttpClient);
  private baseUrl = envs.baseUrl;

  registrarVenta(venta: venta): Observable<VentaResulatdo> {
    return this.httpClient.post<VentaResulatdo>(`${this.baseUrl}venta/registrar`, venta);
  }
}
