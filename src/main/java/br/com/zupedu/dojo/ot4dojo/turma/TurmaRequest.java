package br.com.zupedu.dojo.ot4dojo.turma;

import br.com.zupedu.dojo.ot4dojo.validacao.ValorUnico;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TurmaRequest {

    @NotBlank
    @Size(max=50)
    @ValorUnico(classe = Turma.class, campo = "nome")
    private String nome;

    @NotNull @JsonFormat(pattern ="yyyy-MM-dd" ,shape = JsonFormat.Shape.STRING)
    private LocalDate iniciaEm;

    @NotNull @JsonFormat(pattern ="yyyy-MM-dd" ,shape = JsonFormat.Shape.STRING)
    private LocalDate terminaEm;

    @Deprecated

    public TurmaRequest() {
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
    
    public Turma toModel() {
    	return new Turma(nome, iniciaEm, terminaEm);
    }
}
