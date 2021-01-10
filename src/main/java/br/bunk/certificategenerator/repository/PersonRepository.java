package br.bunk.certificategenerator.repository;

import br.bunk.certificategenerator.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
