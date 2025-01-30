package org.example.miprimeraapirestful.DAOS;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "prestamo")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull(message = "ID de usuario vacío")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private org.example.miprimeraapirestful.DAOS.Usuario usuario;

    @NotNull(message = "ID de ejemplar vacío")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ejemplar_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private org.example.miprimeraapirestful.DAOS.Ejemplar ejemplar;

    @NotNull(message = "Fecha inicial vacia")
    @Column(name = "fechaInicio", nullable = false)
    private LocalDate fechaInicio = LocalDate.now();

    @Column(name = "fechaDevolucion")
    private LocalDate fechaDevolucion = null;

}