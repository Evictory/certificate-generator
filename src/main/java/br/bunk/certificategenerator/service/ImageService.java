package br.bunk.certificategenerator.service;

import br.bunk.certificategenerator.model.BackgroundImage;
import br.bunk.certificategenerator.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    private ImageRepository repository;

    List<BackgroundImage> findAll() {
        return repository.findAll();
    }

    public BackgroundImage save(BackgroundImage image){
       return repository.save(image);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
