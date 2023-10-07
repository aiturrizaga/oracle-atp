package pe.edu.vallegrande.oraclecloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import pe.edu.vallegrande.oraclecloud.model.entity.Person;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findAllByStatus(String status);

    @Modifying
    @Query(value = "update Person p set p.status = 'I' where p.id = ?1")
    void inactivePerson(Long id);

    @Modifying
    @Query(value = "update Person p set p.status = 'A' where p.id = ?1")
    void activePerson(Long id);

    @Modifying
    @Query(value = "delete Person p where p.id = ?1")
    void deletePerson(Long id);
}
