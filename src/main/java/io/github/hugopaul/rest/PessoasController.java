package io.github.hugopaul.rest;

import io.github.hugopaul.model.repository.PessoasRepository;
import io.github.hugopaul.pojo.Pessoas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoas")
public class PessoasController {
    private final PessoasRepository repository;
    @Autowired
    public PessoasController(PessoasRepository repository){
        this.repository = repository;
    }

    @PostMapping
    public Pessoas salvar(@RequestBody Pessoas p){
        p.setId(null);
        return new Pessoas (repository.save(p.toEntity()));
    }

    @GetMapping("{id}")
    public Pessoas acharPorId(@PathVariable Integer id){
        return new Pessoas(repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado")));
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
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Cliente não encontrado"));
    }
    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id, @RequestBody Pessoas pessoasAtualizado){
        repository.findById(id)
                .map(pessoasDesatualizado -> {
                    pessoasDesatualizado.setId(pessoasAtualizado.getId());
                    return new Pessoas(repository.save(pessoasAtualizado.toEntity()));
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada"));
    }
    @GetMapping
    public List<Pessoas> findAll(){
        return repository.findAll().stream().map(Pessoas::new).collect(Collectors.toList());
    }

}
