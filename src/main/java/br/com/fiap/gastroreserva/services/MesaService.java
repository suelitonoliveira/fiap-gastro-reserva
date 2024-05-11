package br.com.fiap.gastroreserva.service;

import br.com.fiap.gastroreserva.dto.MesaDTO;
import br.com.fiap.gastroreserva.entities.Mesa;
import br.com.fiap.gastroreserva.repository.MesaRepository;

import java.util.Optional;

public class MesaService {

    private final MesaRepository mesaRepository;

    public MesaService(MesaRepository mesaRepository) {
        this.mesaRepository = mesaRepository;
    }

    public Mesa salvarMesa(MesaDTO mesaDTO) {
        Mesa mesa = new Mesa();
        mesa.setCod(mesaDTO.getCod());
        mesa.setQtdCadeira(mesaDTO.getQtdCadeira());

        return mesaRepository.save(mesa);
    }
}
