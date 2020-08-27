package io.github.hugopaul.rest;

import io.github.hugopaul.model.entity.Pessoas;
import io.github.hugopaul.model.repository.PessoasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/pessoas")
public class PessoasController {
    private final PessoasRepository repository;
    @Autowired
    public PessoasController(PessoasRepository repository){
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoas salvar(@Valid @RequestBody Pessoas p){
        return repository.save(p);
    }

    @GetMapping("{id}")
    public Pessoas acharPorId(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        repository.findById(id).
                map(pessoas -> {
                    repository.delete(pessoas);
                    return Void.TYPE;
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id, @RequestBody Pessoas pessoasAtualizado){
        repository.findById(id)
                .map(pessoas -> {
                    pessoasAtualizado.setId(pessoas.getId());
                    return repository.save(pessoasAtualizado);
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
