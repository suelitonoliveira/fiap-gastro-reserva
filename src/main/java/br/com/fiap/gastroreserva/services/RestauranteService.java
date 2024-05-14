package br.com.fiap.gastroreserva.services;

import br.com.fiap.gastroreserva.dto.MesaDTO;
import br.com.fiap.gastroreserva.dto.RestauranteDTO;
import br.com.fiap.gastroreserva.entities.Mesa;
import br.com.fiap.gastroreserva.entities.Restaurante;
import br.com.fiap.gastroreserva.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    public RestauranteService(RestauranteRepository restauranteRepository) {
        this.restauranteRepository = restauranteRepository;
    }

    public Collection<Restaurante>findAll(){
        var restaurantes = restauranteRepository.findAll();
        return restaurantes;
    }

    public RestauranteDTO save(RestauranteDTO restauranteDTO){
        Restaurante restaurante = convertToEntity(restauranteDTO);
        restaurante = restauranteRepository.save(restaurante);
        return convertToDTO(restaurante);
    }

    private Restaurante convertToEntity(RestauranteDTO dto) {
        Restaurante restaurante = new Restaurante();
        restaurante.setId(dto.getId());
        restaurante.setNome(dto.getNome());

        List<Mesa> mesas = new ArrayList<>();
        for (MesaDTO mesaDTO : dto.getMesas()) {
            mesas.add(convertToEntity(mesaDTO));
        }
        restaurante.setMesa(mesas);
        return restaurante;
    }

    private Mesa convertToEntity(MesaDTO dto) {
        Mesa mesa = new Mesa();
        mesa.setId(dto.getCod());
        mesa.setQtdCadeira(dto.getQtdCadeira());
        return mesa;
    }

    private RestauranteDTO convertToDTO(Restaurante restaurante) {
        RestauranteDTO restauranteDTO = new RestauranteDTO();
        restauranteDTO.setId(restaurante.getId());
        restauranteDTO.setNome(restaurante.getNome());
        return restauranteDTO;
    }


}
