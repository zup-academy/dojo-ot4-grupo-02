package br.com.zupedu.dojo.ot4dojo.turma;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "turma_nome_unico", columnNames = "nome"),
                @UniqueConstraint(name = "turma_data_inicio_unica", columnNames = "iniciaEm")
        }
)
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Size(max=50)
    private String nome;
    @NotNull
    private LocalDate iniciaEm;
    @NotNull
    private LocalDate terminaEm;

    //Constructor
    public Turma(String nome, LocalDate iniciaEm, LocalDate terminaEm) {
        this.nome = nome;
        this.iniciaEm = iniciaEm;
        this.terminaEm = terminaEm;
    }
    
    @Deprecated
    public Turma() {
	}

    //Getters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getIniciaEm() {
        return iniciaEm;
    }

    public LocalDate getTerminaEm() {
        return terminaEm;
    }
}
