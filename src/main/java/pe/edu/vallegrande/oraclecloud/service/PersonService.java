package pe.edu.vallegrande.oraclecloud.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.vallegrande.oraclecloud.model.entity.Person;
import pe.edu.vallegrande.oraclecloud.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAllByStatus("A");
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    @Transactional
    public Optional<Person> inactive(Long id) {
        personRepository.inactivePerson(id);
        return personRepository.findById(id);
    }

    @Transactional
    public Optional<Person> active(Long id) {
        personRepository.activePerson(id);
        return personRepository.findById(id);
    }

    @Transactional
    public void delete(Long id) {
        personRepository.deletePerson(id);
    }

}
