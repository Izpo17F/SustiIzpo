package com.exam.finaljv.controller;

import com.exam.finaljv.model.dto.VentaRequestDTO;
import com.exam.finaljv.model.dto.VentaResponseDTO;
import com.exam.finaljv.service.VentaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/venta")
public class VentaController {
    private  VentaService ventaService;

    @PostMapping("/registrar")
    public ResponseEntity<VentaResponseDTO> registrarVenta(@RequestBody @Validated VentaRequestDTO ventaRequestDTO){
        VentaResponseDTO ventaResponseDTO = ventaService.registrarVenta(ventaRequestDTO);
        return ResponseEntity.ok(ventaResponseDTO);
    }
}
