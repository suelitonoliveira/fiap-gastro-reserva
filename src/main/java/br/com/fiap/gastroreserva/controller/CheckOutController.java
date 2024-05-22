package br.com.fiap.gastroreserva.controller;


import br.com.fiap.gastroreserva.dto.CheckOutDTO;
import br.com.fiap.gastroreserva.services.CheckOutService;
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
@RequestMapping("/checkout")
@RequiredArgsConstructor
public class CheckOutController {

    @Autowired
    private final CheckOutService service;

    @PostMapping
    public ResponseEntity<?> checkOut(@RequestBody @Valid CheckOutDTO checkOutDTO) {
        if (service.reservaExiste(checkOutDTO.getReservaId())) {
            CheckOutDTO checkedOutDTO = service.checkOut(checkOutDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(checkedOutDTO);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Reserva não encontrada");
        }
    }
}
