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

    @GetMapping("/getUsuarios")
    public ResponseEntity<List<Usuario>> getUsuarios() {
        List<Usuario> usuarios = usuariosRepository.findAll();
        System.out.println(usuarios);
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuariosJSON(@PathVariable int id) {
        Usuario u = this.usuariosRepository.findById(id).get();
        return ResponseEntity.ok(u);
    }

    @PostMapping("/usuario")
    public ResponseEntity<Usuario> addUsuario(@Valid @RequestBody Usuario usuario) {
        Usuario u = this.usuariosRepository.save(usuario);
        return ResponseEntity.ok(u);
    }

    @PostMapping(value = "/usuarioForm", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Usuario> addUsuarioForm(@RequestBody String dni,
                                                  @RequestParam String nombre,
                                                  @RequestParam String email,
                                                  @RequestParam String password,
                                                  @RequestParam String tipo) {
        Usuario u = new Usuario();
        u.setDni(dni);
        u.setNombre(nombre);
        u.setEmail(email);
        u.setPassword(password);
        u.setTipo(tipo);
        this.usuariosRepository.save(u);
        return ResponseEntity.created(null).body(u);
    }

    @PostMapping(value = "/usuarioFormFichero", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Usuario> addUsuarioFormFichero(@RequestBody String dni,
                                                         @RequestParam String nombre,
                                                         @RequestParam String email,
                                                         @RequestParam String password,
                                                         @RequestParam String tipo,
                                                         @RequestParam MultipartFile image) {
        Usuario u = new Usuario();
        u.setDni(dni);
        u.setNombre(nombre);
        u.setEmail(email);
        u.setPassword(password);
        u.setTipo(tipo);
        this.usuariosRepository.save(u);
        return ResponseEntity.created(null).body(u);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
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
