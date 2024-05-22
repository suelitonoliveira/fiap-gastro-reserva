package br.com.fiap.gastroreserva.services;

import br.com.fiap.gastroreserva.dto.CheckOutDTO;
import br.com.fiap.gastroreserva.entities.Reserva;
import br.com.fiap.gastroreserva.mapper.CheckOutMapper;
import br.com.fiap.gastroreserva.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckOutService {
    @Autowired
    private final ReservaRepository repository;

    @Autowired
    private final CheckOutMapper mapper;

    public CheckOutService(ReservaRepository repository, CheckOutMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public boolean reservaExiste(Long reservaId) {
        return repository.existsById(reservaId);
    }

    public CheckOutDTO checkOut(CheckOutDTO checkOutDTO) {
        Reserva reserva = mapper.toEntity(checkOutDTO);
        reserva.setCheckedOut(true);
        Reserva updatedReserva = repository.save(reserva);
        return mapper.toDTO(updatedReserva);
    }
}
