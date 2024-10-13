package br.com.cp.fiap.EventosMvc.service;

import br.com.cp.fiap.EventosMvc.model.Evento;
import br.com.cp.fiap.EventosMvc.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> searchByTitle(String nome) {
        return eventoRepository.findByNomeContaining(nome);
    }
}
