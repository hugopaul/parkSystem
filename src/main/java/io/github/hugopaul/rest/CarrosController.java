package io.github.hugopaul.rest;

import io.github.hugopaul.model.entity.Carros;
import io.github.hugopaul.model.repository.CarrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

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
    public Carros salvar( @RequestBody @Valid Carros c){
        return repository.save(c);
    }

    @GetMapping("{id}")
    public Carros acharPorId(@PathVariable Integer id){
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carro não encontrado"));
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
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Carro não encontrado"));
    }
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id, @RequestBody Carros carrosAtualizado){
        repository.findById(id)
                .map(carros -> {
                    carrosAtualizado.setId(carros.getId());
                    return repository.save(carrosAtualizado);
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
