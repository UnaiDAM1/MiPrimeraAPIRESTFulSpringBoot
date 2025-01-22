package org.example.miprimeraapirestful.Repositories;

import org.example.miprimeraapirestful.DAOS.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamosRepository extends JpaRepository<Prestamo, Integer> {
}
