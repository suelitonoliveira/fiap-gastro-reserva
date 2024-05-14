package br.com.fiap.gastroreserva.controller;

import br.com.fiap.gastroreserva.dto.ReservaDTO;
import br.com.fiap.gastroreserva.services.ReservaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reservas")
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;

    @PostMapping
    public ResponseEntity<ReservaDTO> save(@RequestBody @Valid ReservaDTO reservaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.salvarReserva(reservaDTO));
    }
}
