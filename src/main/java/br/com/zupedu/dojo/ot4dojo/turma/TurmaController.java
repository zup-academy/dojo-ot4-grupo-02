package br.com.zupedu.dojo.ot4dojo.turma;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/turma")
public class TurmaController {
	
	@Autowired
	private TurmaRepository turmaRepositry;

	@PostMapping
	public ResponseEntity<?> criarTurma(@RequestBody @Valid TurmaRequest request, UriComponentsBuilder uriBuilder) {
		try {
			Turma novaTurma = request.toModel();
			turmaRepositry.save(novaTurma);
			URI uri = uriBuilder.path("turma/{id}").build(novaTurma.getId());
			return ResponseEntity.created(uri).build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}

