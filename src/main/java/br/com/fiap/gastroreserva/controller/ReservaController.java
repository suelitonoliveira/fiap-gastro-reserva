package br.com.fiap.gastroreserva.controller;

import br.com.fiap.gastroreserva.dto.ReservaDTO;
import br.com.fiap.gastroreserva.services.ReservaService;
import io.swagger.annotations.Api;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Api(value= "API de Exemplo", description = "Exemplo de API")
public class ReservaController {

    private final ReservaService reservaService;


    @PostMapping
    public ResponseEntity<ReservaDTO> incluir(@RequestBody @Valid ReservaDTO reservaDTO) throws AccessDeniedException {
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.salvarReserva(reservaDTO));
    }
}
