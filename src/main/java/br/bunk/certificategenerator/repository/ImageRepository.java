package br.bunk.certificategenerator.repository;

import br.bunk.certificategenerator.model.BackgroundImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<BackgroundImage, Long> {
}
