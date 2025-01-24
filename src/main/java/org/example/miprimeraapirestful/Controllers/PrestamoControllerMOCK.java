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

    @GetMapping
    public ResponseEntity<List<Prestamo>> getPrestamos() {
        return ResponseEntity.ok(this.prestamosRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> getPrestamoJSON(@PathVariable int id){
        Prestamo p = this.prestamosRepository.findById(id).get();
        return ResponseEntity.ok(p);
    }

    @PostMapping
    public ResponseEntity<Prestamo> addPrestamo(@RequestBody Prestamo prestamo){
        Prestamo p = this.prestamosRepository.save(prestamo);
        return ResponseEntity.ok().body(p);
    }

    @PutMapping
    public ResponseEntity<Prestamo> updatePrestamo(@RequestBody Prestamo prestamo){
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
