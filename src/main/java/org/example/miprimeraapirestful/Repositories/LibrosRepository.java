package org.example.miprimeraapirestful.Repositories;

import org.example.miprimeraapirestful.DAOS.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrosRepository extends JpaRepository<Libro, String> {
}
