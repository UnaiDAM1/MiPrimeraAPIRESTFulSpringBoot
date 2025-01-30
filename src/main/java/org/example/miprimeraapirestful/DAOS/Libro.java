package org.example.miprimeraapirestful.DAOS;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Parameter;

@Data
@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @Size(max = 20)
    @Column(name = "isbn", nullable = false, length = 20)
    @NotNull(message = "ISBN vacío")
    @Pattern(regexp = "^978\\d{10}$", message = "El ISBN debe comenzar con 978 y seguir con 10 dígitos")
    private String isbn;

    @Size(max = 200)
    @NotNull(message = "Titulo vacío")
    @Column(name = "titulo", nullable = false, length = 200)
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚ0-9 ]*$", message = "El título solo puede contener caracteres alfanuméricos y espacios")
    private String titulo;

    @Size(max = 100)
    @NotNull(message = "Autor vacío")
    @Column(name = "autor", nullable = false, length = 100)
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚ0-9 ]*$", message = "El autor solo puede contener caracteres alfanuméricos y espacios")
    private String autor;

}