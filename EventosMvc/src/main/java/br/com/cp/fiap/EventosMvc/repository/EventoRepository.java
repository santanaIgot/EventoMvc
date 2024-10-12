package br.com.cp.fiap.EventosMvc.repository;

import br.com.cp.fiap.EventosMvc.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventoRepository extends JpaRepository<Evento, Long> {
}
