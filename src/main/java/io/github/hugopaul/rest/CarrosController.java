package io.github.hugopaul.rest;

import io.github.hugopaul.model.entity.Carros;
import io.github.hugopaul.model.entity.Motos;
import io.github.hugopaul.model.entity.Pessoas;
import io.github.hugopaul.model.repository.CarrosRepository;
import io.github.hugopaul.model.repository.MotosRepository;
import io.github.hugopaul.model.repository.PessoasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/carros")
public class CarrosController {
    private final CarrosRepository repository;
    @Autowired
    public CarrosController(CarrosRepository repository){
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carros salvar(@RequestBody Carros c){
        return repository.save(c);
    }
    @GetMapping("{id}")
    public Carros acharPorId(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id){
        repository.findById(id).
                map(carros -> {
                    repository.delete(carros);
                    return Void.TYPE;
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id, @RequestBody Carros pessoasAtualizado){
        repository.findById(id)
                .map(carros -> {
                    pessoasAtualizado.setId(carros.getId());
                    return repository.save(pessoasAtualizado);
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
