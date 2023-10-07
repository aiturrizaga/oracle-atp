package pe.edu.vallegrande.oraclecloud.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.oraclecloud.model.entity.Person;
import pe.edu.vallegrande.oraclecloud.service.PersonService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/persons")
public class PersonController {

    private final PersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> findAll() {
        return ResponseEntity.ok(personService.findAll());
    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person) {
        return ResponseEntity.ok(personService.save(person));
    }

    @GetMapping("/{idPer}")
    public ResponseEntity<Optional<Person>> findById(@PathVariable Long idPer) {
        return ResponseEntity.ok(personService.findById(idPer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/inactive/{id}")
    public ResponseEntity<Optional<Person>> inactive(@PathVariable Long id) {
        return ResponseEntity.ok(personService.inactive(id));
    }

    @PutMapping("/active/{id}")
    public ResponseEntity<Optional<Person>> active(@PathVariable Long id) {
        return ResponseEntity.ok(personService.active(id));
    }

}
