package br.com.fiap.gastroreserva.services;

import br.com.fiap.gastroreserva.dto.MesaDTO;
import br.com.fiap.gastroreserva.entities.Mesa;
import br.com.fiap.gastroreserva.repository.MesaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static br.com.fiap.gastroreserva.mapper.MesaMapper.mesaDTOToMesa;
import static br.com.fiap.gastroreserva.mapper.MesaMapper.mesaToMesaDTO;

@Service
@RequiredArgsConstructor
public class MesaService {

    private final MesaRepository mesaRepository;

    public MesaDTO salvarMesa(MesaDTO mesaDTO) {
        Mesa mesa = mesaRepository.save(mesaDTOToMesa(mesaDTO));
        return mesaToMesaDTO(mesa);
    }
}
