package org.example.miprimeraapirestful.Controllers;


import org.example.miprimeraapirestful.DAOS.Ejemplar;
import org.example.miprimeraapirestful.DAOS.Libro;
import org.example.miprimeraapirestful.Repositories.EjemplarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/ejemplar")
public class EjemplarControllerMOCK {
    EjemplarRepository ejemplarRepository;

    @Autowired
    public EjemplarControllerMOCK(EjemplarRepository ejemplarRepository) {
        this.ejemplarRepository = ejemplarRepository;
    }
    public EjemplarControllerMOCK(){
    }

    @GetMapping
    public ResponseEntity<List<Ejemplar>> getEjemplares() {
        return ResponseEntity.ok(this.ejemplarRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ejemplar> getEjemplarsJSON(@PathVariable int id) {
        Ejemplar e = this.ejemplarRepository.findById(id).get();
        return ResponseEntity.ok(e);
    }

    @PostMapping
    public ResponseEntity<Ejemplar> addEjemplar(@RequestBody Ejemplar ejemplar) {
        Ejemplar e = this.ejemplarRepository.save(ejemplar);
        return ResponseEntity.ok().body(e);
    }

    @PutMapping
    public ResponseEntity<Ejemplar> updateEjemplar(@RequestBody Ejemplar ejemplar) {
        Ejemplar e = this.ejemplarRepository.save(ejemplar);
        return ResponseEntity.ok().body(e);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEjemplar(@PathVariable int id) {
        this.ejemplarRepository.deleteById(id);
        String mensaje = "Ejemplar con ID " + id + " eliminado";
        return ResponseEntity.ok().body(mensaje);
    }
}
