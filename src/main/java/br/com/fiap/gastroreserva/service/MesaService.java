package br.com.fiap.gastroreserva.service;

import br.com.fiap.gastroreserva.dto.MesaDTO;
import br.com.fiap.gastroreserva.entities.Mesa;
import br.com.fiap.gastroreserva.repository.MesaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static br.com.fiap.gastroreserva.mapper.MesaMapper.mesaDTOToMesa;
import static br.com.fiap.gastroreserva.mapper.MesaMapper.mesaToMesaDTO;

@Service
@RequiredArgsConstructor
    public MesaService(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }

    public Mesa salvarMesa(MesaDTO mesaDTO) {
        Mesa mesa = new Mesa();
        mesa.setId(mesaDTO.getCod());
        mesa.setQtdCadeira(mesaDTO.getQtdCadeira());

        return salvarMesa();

}
