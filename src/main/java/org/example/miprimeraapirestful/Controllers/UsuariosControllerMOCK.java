package org.example.miprimeraapirestful.Controllers;

import jakarta.validation.Valid;
import org.example.miprimeraapirestful.DAOS.Usuario;
import org.example.miprimeraapirestful.Repositories.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/usuario")

public class UsuariosControllerMOCK {
    UsuariosRepository usuariosRepository;

    public UsuariosControllerMOCK() {

    }

    @Autowired
    public UsuariosControllerMOCK(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuarios() {
        return ResponseEntity.ok(this.usuariosRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuariosJSON(@PathVariable int id) {
        Usuario u = this.usuariosRepository.findById(id).get();
        return ResponseEntity.ok(u);
    }

    @PostMapping
    public ResponseEntity<Usuario> addUsuario(@Valid @RequestBody Usuario usuario) {
        Usuario u = this.usuariosRepository.save(usuario);
        return ResponseEntity.ok(u);
    }

    @PutMapping
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioPersistido =usuariosRepository.save(usuario);
        return ResponseEntity.ok().body(usuarioPersistido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable int id) {
        this.usuariosRepository.deleteById(id);
        String mensaje = "Usuario con ID " + id + " borrado";
        return ResponseEntity.ok().body(mensaje);
    }
}
