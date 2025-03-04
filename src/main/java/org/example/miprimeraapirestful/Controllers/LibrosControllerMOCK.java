package org.example.miprimeraapirestful.Controllers;

import jakarta.validation.Valid;
import org.example.miprimeraapirestful.Repositories.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.example.miprimeraapirestful.DAOS.Libro;

import java.util.List;

@RestController
@RequestMapping("/libros")

public class LibrosControllerMOCK {
    LibrosRepository repositorioLibros;


    public LibrosControllerMOCK(){
    }

    @Autowired
    public LibrosControllerMOCK(LibrosRepository repositorioLibros){
        this.repositorioLibros = repositorioLibros;
    }

    //GET --> SELECT *
    @GetMapping()
    public ResponseEntity<List<Libro>> getLibro(){
        return ResponseEntity.ok(this.repositorioLibros.findAll());
    }

//    //GET BY ISBN --> SELECT BY ISBN
//    @GetMapping("/{isbn}")
//    @Cacheable
//    public ResponseEntity<Libro> getLibroJson(@PathVariable String isbn){
//            Libro l = this.repositorioLibros.findById(isbn).get();
//            return ResponseEntity.ok(l);
//    }

   //POST --> INSERT
    @PostMapping()
    public ResponseEntity<Libro> addLibro(@Valid @RequestBody Libro libro){
        Libro libroPersistido = this.repositorioLibros.save(libro);
        return ResponseEntity.ok(libroPersistido);
    }

//    //POST con Form normal, se trabajará con JSONs normalmente...
//    @PostMapping(value = "/libroForm")
//    public ResponseEntity<Libro> addLibroForm(@RequestParam String isbn,
//                                              @RequestParam String titulo,
//                                              @RequestParam String autor){
//        Libro libro = new Libro();
//        libro.setIsbn(isbn);
//        libro.setTitulo(titulo);
//        libro.setAutor(autor);
//        this.repositorioLibros.save(libro);
//        return ResponseEntity.created(null).body(libro);
//    }
//
//    //POST con Form normal y fichero, se trabajará con JSONs normalmente...
//    @PostMapping(value = "/libroFormFichero", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<Libro> addLibroFormFichero(@RequestParam String isbn,
//                                                     @RequestParam String titulo,
//                                                     @RequestParam String autor,
//                                                     @RequestParam MultipartFile imagen){
//        //Datos básicos del libro
//        Libro libro = new Libro();
//        libro.setIsbn(isbn);
//        libro.setTitulo(titulo);
//        libro.setAutor(autor);
//
//        //guardado en la bbdd del libro
//        this.repositorioLibros.save(libro);
//
//        //devolución del objeto en formato json para el cliente
//        return ResponseEntity.created(null).body(libro);
//    }

    //PUT --> UPDATE
    //falta actualizar ficheros
    @PutMapping
    public ResponseEntity<Libro> updateLibro(@RequestBody Libro libro){
        Libro libroPersistido = repositorioLibros.save(libro);
        return ResponseEntity.ok().body(libroPersistido);
    }

    //DELETE
    @DeleteMapping("/{isbn}")
    public ResponseEntity<String> deleteLibro(@PathVariable String isbn){
            repositorioLibros.deleteById(isbn);
            String mensaje = "libro con isbn: "+isbn+" borrado";
            return ResponseEntity.ok().body(mensaje);
        }
    }


