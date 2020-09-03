package io.github.hugopaul.rest;

import io.github.hugopaul.model.repository.CarrosRepository;
import io.github.hugopaul.model.repository.MotosRepository;
import io.github.hugopaul.pojo.Carros;
import io.github.hugopaul.pojo.Motos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/motos")
public class MotosController {
    private final MotosRepository repository;
    @Autowired
    public MotosController(MotosRepository repository){
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Motos create(@RequestBody @Valid Motos m){
        m.setId(null);
        return new Motos(repository.save(m.toEntity()));
    }

    @GetMapping("{id}")
    public Motos get(@PathVariable Integer id){
        return new Motos(repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Moto não encontrado")));
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
                                "Moto não encontrada"));
    }
    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id, @RequestBody Motos motosAtualizado){
        repository.findById(id)
                .map(motosDesatualizado -> {
                    motosAtualizado.setId(motosDesatualizado.getId());
                    return repository.save(motosAtualizado.toEntity());
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Moto não encontrada"));
    }
    @GetMapping
    public List<Motos> findAll(){
        return repository.findAll().stream().map(Motos::new).collect(Collectors.toList());
    }
}
