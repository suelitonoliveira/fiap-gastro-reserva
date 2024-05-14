package br.com.fiap.gastroreserva.services;

import br.com.fiap.gastroreserva.entities.Restaurante;
import br.com.fiap.gastroreserva.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public Collection<Restaurante> findAll() {
        var restaurante = restauranteRepository.findAll();
        return restaurante;
    }

    public Optional<Restaurante> findById(Long id){
        var restaurante = restauranteRepository.findById(id);
        return restaurante;
    }

    public Restaurante save(Restaurante restaurante){
        restaurante = restauranteRepository.save(restaurante);
        return restaurante;
    }

    public Restaurante update(Long id, Restaurante restaurante){
        Restaurante buscaRestaurante = restauranteRepository.getOne(id);
        buscaRestaurante.setNome(restaurante.getNome());
        buscaRestaurante.setMesas(restaurante.getMesas());

        //feitos os setter, o valor esta atualizado
        buscaRestaurante = restauranteRepository.save(buscaRestaurante);
        return buscaRestaurante;

    }

    public void delete(Long id){
        restauranteRepository.deleteById(id);
    }
}
