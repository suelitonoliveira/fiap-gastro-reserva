package br.com.fiap.gastroreserva.services;

import br.com.fiap.gastroreserva.dto.CheckInDTO;
import br.com.fiap.gastroreserva.entities.Reserva;
import br.com.fiap.gastroreserva.mapper.CheckInMapper;
import br.com.fiap.gastroreserva.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckInService {

    @Autowired
    private final ReservaRepository repository;

    @Autowired
    private final CheckInMapper mapper;

    public CheckInService(ReservaRepository repository, CheckInMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public boolean reservaExiste(Long reservaId) {
        return repository.existsById(reservaId);
    }

    public CheckInDTO checkIn(CheckInDTO checkInDTO) {
        Reserva reserva = mapper.toEntity(checkInDTO);
        reserva.setCheckedIn(true);
        Reserva updatedReserva = repository.save(reserva);
        return mapper.toDTO(updatedReserva);
    }
}
