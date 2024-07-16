package com.exam.finaljv.service;

import com.exam.finaljv.mapper.VentaMapper;
import com.exam.finaljv.model.dto.VentaRequestDTO;
import com.exam.finaljv.model.dto.VentaResponseDTO;
import com.exam.finaljv.model.entity.Venta;
import com.exam.finaljv.repository.VentaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VentaService {
    private VentaRepository ventaRepository;
    private VentaMapper ventaMapper;

    public VentaResponseDTO registrarVenta(VentaRequestDTO ventaRequestDTO) {
        double cantidadTotal = ventaRequestDTO.getCantidad() * ventaRequestDTO.getPrecioUnitario();
        double descuento = 0.0;

        if (ventaRequestDTO.getCantidad() > 10) {
            descuento += 0.05 * cantidadTotal;
        }

        if (cantidadTotal > 1000) {
            descuento += 0.03 * cantidadTotal;
        }

        double montoFinal = cantidadTotal - descuento;

        Venta venta = new Venta();
        venta.setNombreDelProducto(ventaRequestDTO.getNombreProducto());
        venta.setCantidad(ventaRequestDTO.getCantidad());
        venta.setPrecioUnitarioo(ventaRequestDTO.getPrecioUnitario());
        venta.setFechaVenta(ventaRequestDTO.getFechaVenta());
        venta.setMontoTotalConDescuento(montoFinal);
        venta.setDescuentoAplicado(descuento);
        venta.setMontoTotal(cantidadTotal);

        return ventaMapper.convertToDto(ventaRepository.save(venta));
    }
}