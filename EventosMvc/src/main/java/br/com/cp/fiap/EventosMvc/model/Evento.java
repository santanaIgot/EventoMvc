package br.com.cp.fiap.EventosMvc.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Getter@Setter
@Table(name = "TB_EVENTO_CP02_JAVA")
public class Evento {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "nm_nome", length = 50, nullable = false)
    private String nome;
    @Column(name = "ds_descricao", length = 50, nullable = false)
    private String descricao;
    @Column(name = "nm_atracao", nullable = false)
    private String atracao;
    @Column(name = "nm_localizacao", nullable = false)
    private String localizacao;
    @Column(name = "st_status", nullable = false)
    private Status status;

    @DateTimeFormat(pattern = "dd/MM/yy")
    @Column(name = "dt_data")
    private LocalDate data;

}
