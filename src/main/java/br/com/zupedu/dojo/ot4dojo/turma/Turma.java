package br.com.zupedu.dojo.ot4dojo.turma;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Size(max=50)
    private String nome;
    @NotNull
    private LocalDateTime iniciaEm;
    @NotNull
    private LocalDateTime terminaEm;

    //Constructor
    public Turma(String nome, LocalDateTime iniciaEm, LocalDateTime terminaEm) {
        this.nome = nome;
        this.iniciaEm = iniciaEm;
        this.terminaEm = terminaEm;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDateTime getIniciaEm() {
        return iniciaEm;
    }

    public LocalDateTime getTerminaEm() {
        return terminaEm;
    }
}
