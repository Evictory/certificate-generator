package br.bunk.certificategenerator.repository;

import br.bunk.certificategenerator.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
