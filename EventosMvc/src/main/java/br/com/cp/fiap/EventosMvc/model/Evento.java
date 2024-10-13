package br.com.cp.fiap.EventosMvc.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "Preencha o nome do evento ")
    @Size(max = 50)
    @Column(name = "nm_nome", length = 50, nullable = false)
    private String nome;

    @Size(min =  5, max = 200)
    @NotNull
    @Column(name = "ds_descricao", length = 50, nullable = false)
    private String descricao;

    @NotNull
    @Column(name = "nm_atracao", nullable = false)
    private String atracao;

    @NotNull
    @Column(name = "nm_localizacao", nullable = false)
    private String localizacao;

    @NotNull
    @Column(name = "st_status", nullable = false)
    private Status status;


    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yy")
    @Column(name = "dt_data")
    private LocalDate data;

}
