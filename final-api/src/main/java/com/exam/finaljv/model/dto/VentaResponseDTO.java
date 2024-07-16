package com.exam.finaljv.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaResponseDTO {
    private double montoTotal;
    private double descuentoAplicado;
    private double montoTotalConDescuento;
}
