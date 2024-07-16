package com.exam.finaljv.model.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class VentaRequestDTO {

    @NotBlank(message = "El nombre no puede ser nulo")
    private String nombreProducto;
    @NotNull(message = "La cantidad no puede ser nula")
    @DecimalMin(value = "0.01", message = "La cantidad no puede ser un numero negativo")
    private int cantidad;
    @NotNull(message = "El precio unitario no puede ser nulo")
    @DecimalMin(value = "0.01", message = "El precio unitario no puede ser un numero negativo")
    private double precioUnitario;
    @NotNull(message = "La fecha no puede ser nula")
    private LocalDate fechaVenta;
}
