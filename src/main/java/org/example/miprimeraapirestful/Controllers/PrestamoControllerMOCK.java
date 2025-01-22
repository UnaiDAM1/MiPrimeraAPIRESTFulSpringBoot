package org.example.miprimeraapirestful.Controllers;

import org.example.miprimeraapirestful.DAOS.Ejemplar;
import org.example.miprimeraapirestful.DAOS.Libro;
import org.example.miprimeraapirestful.DAOS.Prestamo;
import org.example.miprimeraapirestful.DAOS.Usuario;
import org.example.miprimeraapirestful.Repositories.PrestamosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/prestamos")
public class PrestamoControllerMOCK {
    PrestamosRepository prestamosRepository;

    public PrestamoControllerMOCK() {
    }

    @Autowired
    public PrestamoControllerMOCK(PrestamosRepository prestamosRepository) {
        this.prestamosRepository = prestamosRepository;
    }

    @GetMapping("/getPrestamos")
    public ResponseEntity<List<Prestamo>> getPrestamos() {
        List<Prestamo> prestamos = prestamosRepository.findAll();
        System.out.println(prestamos);
        return ResponseEntity.ok(prestamos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> getPrestamoJSON(@PathVariable int id){
        Prestamo p = this.prestamosRepository.findById(id).get();
        return ResponseEntity.ok(p);
    }

    @PostMapping("/prestamo")
    public ResponseEntity<Prestamo> addPrestamo(@RequestBody Prestamo prestamo){
        Prestamo p = this.prestamosRepository.save(prestamo);
        return ResponseEntity.ok().body(p);
    }

    @PostMapping(value = "/prestamoForm", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Prestamo> addPrestamoForm(@RequestBody Ejemplar ejemplar,
                                                    @RequestBody Usuario usuario){
        Prestamo prestamo = new Prestamo();
        prestamo.setEjemplar(ejemplar);
        prestamo.setUsuario(usuario);
        this.prestamosRepository.save(prestamo);
        return ResponseEntity.created(null).body(prestamo);
    }

    @PostMapping(value = "/ejemplarFormFichero", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Prestamo> addEjemplarFormFichero(@RequestBody Ejemplar ejemplar,
                                                           @RequestBody Usuario usuario,
                                                           @RequestParam MultipartFile file){
        Prestamo prestamo = new Prestamo();
        prestamo.setEjemplar(ejemplar);
        prestamo.setUsuario(usuario);
        this.prestamosRepository.save(prestamo);
        return ResponseEntity.created(null).body(prestamo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prestamo> updatePrestamo(@PathVariable int id, @RequestBody Prestamo prestamo){
        Prestamo p = this.prestamosRepository.save(prestamo);
        return ResponseEntity.ok().body(p);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePrestamo(@PathVariable int id){
        this.prestamosRepository.deleteById(id);
        String mensaje = "Prestamo con ID " + id + " eliminado";
        return ResponseEntity.ok().body(mensaje);
    }


}
