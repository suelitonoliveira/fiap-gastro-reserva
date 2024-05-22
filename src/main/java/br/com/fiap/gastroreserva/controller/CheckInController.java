package br.com.fiap.gastroreserva.controller;


import br.com.fiap.gastroreserva.dto.CheckInDTO;
import br.com.fiap.gastroreserva.services.CheckInService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkin")
@RequiredArgsConstructor
public class CheckInController {

    @Autowired
    private final CheckInService service;

    @PostMapping
    public ResponseEntity<?> checkIn(@RequestBody @Valid CheckInDTO checkInDTO) {
        if (service.reservaExiste(checkInDTO.getReservaId())) {
            CheckInDTO checkedInDTO = service.checkIn(checkInDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(checkedInDTO);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Reserva não encontrada");
        }
    }
}
