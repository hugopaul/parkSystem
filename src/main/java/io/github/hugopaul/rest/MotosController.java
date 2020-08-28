package io.github.hugopaul.rest;

import io.github.hugopaul.model.entity.Motos;
import io.github.hugopaul.model.entity.Pessoas;
import io.github.hugopaul.model.repository.MotosRepository;
import io.github.hugopaul.model.repository.PessoasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/motos")
public class MotosController {
    private final MotosRepository repository;
    @Autowired
    public MotosController(MotosRepository repository){
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Motos salvar(@RequestBody @Valid Motos p){
        return repository.save(p);
    }

    @GetMapping("{id}")
    public Motos acharPorId(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Moto não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        repository.findById(id).
                map(motos -> {
                    repository.delete(motos);
                    return Void.TYPE;
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Moto não encontrado"));
    }
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id, @RequestBody Motos motosAtualizado){
        repository.findById(id)
                .map(motos -> {
                    motosAtualizado.setId(motos.getId());
                    return repository.save(motosAtualizado);
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
