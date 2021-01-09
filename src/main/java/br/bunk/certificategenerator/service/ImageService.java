package br.bunk.certificategenerator.service;

import br.bunk.certificategenerator.model.Image;
import br.bunk.certificategenerator.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    private ImageRepository repository;

    List<Image> findAll() {
        return repository.findAll();
    }

    public Image save(Image image){
       return repository.save(image);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
