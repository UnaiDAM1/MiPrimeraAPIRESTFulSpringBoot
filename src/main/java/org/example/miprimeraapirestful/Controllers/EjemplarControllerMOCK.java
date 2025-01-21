package org.example.miprimeraapirestful.Controllers;


import org.example.miprimeraapirestful.DAOS.Ejemplar;
import org.example.miprimeraapirestful.DAOS.Libro;
import org.example.miprimeraapirestful.Repositorys.EjemplarRepository;
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

    @GetMapping("/getEjemplares")
    public ResponseEntity<List<Ejemplar>> getEjemplares() {
        List<Ejemplar> ejemplares = this.ejemplarRepository.findAll();
        System.out.println(ejemplares);
        return ResponseEntity.ok(ejemplares);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ejemplar> getEjemplarsJSON(@PathVariable int id) {
        Ejemplar e = this.ejemplarRepository.findById(id).get();
        return ResponseEntity.ok(e);
    }

    @PostMapping("/ejemplar")
    public ResponseEntity<Ejemplar> addEjemplar(@RequestBody Ejemplar ejemplar) {
        Ejemplar e = this.ejemplarRepository.save(ejemplar);
        return ResponseEntity.ok().body(e);
    }

    @PostMapping(value = "/ejemplarForm", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Ejemplar> addEjemplarForm(@RequestBody Libro libro,
                                                    @RequestParam String estado) {
        Ejemplar ejemplar = new Ejemplar();
        ejemplar.setIsbn(libro);
        ejemplar.setEstado(estado);
        this.ejemplarRepository.save(ejemplar);
        return ResponseEntity.created(null).body(ejemplar);
    }

    @PostMapping(value = "/ejemplarFormFichero", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Ejemplar> addEjemplarFormFichero(@RequestBody Libro libro,
                                                           @RequestParam String estado,
                                                           @RequestParam MultipartFile file) {
        Ejemplar ejemplar = new Ejemplar();
        ejemplar.setIsbn(libro);
        ejemplar.setEstado(estado);
        this.ejemplarRepository.save(ejemplar);
        return ResponseEntity.created(null).body(ejemplar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ejemplar> updateEjemplar(@PathVariable int id, @RequestBody Ejemplar ejemplar) {
        Ejemplar e = this.ejemplarRepository.save(ejemplar);
        return ResponseEntity.ok().body(e);
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> deleteEjemplar(@PathVariable int id) {
        this.ejemplarRepository.deleteById(id);
        String mensaje = "Ejemplar con ID " + id + " eliminado";
        return ResponseEntity.ok().body(mensaje);
    }
}
