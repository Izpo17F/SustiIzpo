package com.exam.finaljv.mapper;

import com.exam.finaljv.model.dto.VentaResponseDTO;
import com.exam.finaljv.model.entity.Venta;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class VentaMapper {
    private ModelMapper modelMapper;

    public Venta convertToEntity(VentaResponseDTO ventaResponseDTO) {
        return modelMapper.map(ventaResponseDTO, Venta.class);
    }
    public VentaResponseDTO convertToDto(Venta venta) {
        return modelMapper.map(venta, VentaResponseDTO.class);
    }
//    public List<VentaResponseDTO> convertToListDTO(List<Venta> ventaList){
//        return ventaList.stream()
//                .map(this::convertToDto())
//        .toList();
//    }
}
