package org.example.miprimeraapirestful.Repositories;

import org.example.miprimeraapirestful.DAOS.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {
}
