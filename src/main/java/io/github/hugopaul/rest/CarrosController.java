package io.github.hugopaul.rest;

import io.github.hugopaul.model.repository.CarrosRepository;
import io.github.hugopaul.pojo.Carros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carros")
@CrossOrigin("http://localhost:4200")
public class CarrosController {
    private final CarrosRepository repository;
    @Autowired
    public CarrosController(CarrosRepository repository){
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carros create(@RequestBody Carros c){
        c.setId(null);
        return new Carros(repository.save(c.toEntity()));
    }

    @GetMapping("{id}")
    public Carros get(@PathVariable Integer id){
        return new Carros(repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carro não encontrado")));
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
    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id, @RequestBody Carros carrosAtualizado){
        repository.findById(id)
                .map(carrosDesatualizado -> {
                    carrosAtualizado.setId(carrosDesatualizado.getId());
                    return repository.save(carrosAtualizado.toEntity());
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Carro não encontrado"));
    }
    @GetMapping
    public List<Carros> findAll(){
        return repository.findAll().stream().map(Carros::new).collect(Collectors.toList());
    }
}
