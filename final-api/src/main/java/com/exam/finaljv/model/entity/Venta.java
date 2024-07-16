package com.exam.finaljv.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ventas")

public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nombre_Producto")
    private String nombreDelProducto;
    @Column(name="cantidad")
    private int cantidad;
    @Column(name="precio_unitario")
    private double precioUnitarioo;
    @Column(name="fecha_venta")
    private LocalDate fechaVenta;
    @Column(name="monto_total")
    private double montoTotal;
    @Column(name="descuento_aplicado")
    private double descuentoAplicado;
    @Column(name="monto_total_con_descuento")
    private double montoTotalConDescuento;
}
