package br.com.zupedu.dojo.ot4dojo.turma;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class TurmaRequest {

    @NotBlank
    @Size(max=50)
    private String nome;
    @NotNull
    private LocalDateTime iniciaEm;
    @NotNull
    private LocalDateTime terminaEm;

    @Deprecated
    public TurmaRequest() {
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
    
    public Turma toModel() {
    	return new Turma(nome, iniciaEm, terminaEm);
    }
}
