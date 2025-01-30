package org.example.miprimeraapirestful.DAOS;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 15)
    @NotNull(message = "DNI de usuario vacío")
    @Column(name = "dni", nullable = false, length = 15)
    @Pattern(regexp = "^[0-9]{8}[A-Z]$", message = "El DNI debe contener 8 números seguidos de una letra mayúscula.")
    private String dni;

    @Size(max = 100)
    @NotNull(message = "Nombre de usuario vacío")
    @Column(name = "nombre", nullable = false, length = 100)
    @Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚ0-9 ]+$", message = "El nombre solo puede contener carácteres alfanuméricos")
    private String nombre;

    @Size(max = 100)
    @NotNull(message = "Email de usuario vacío")
    @Column(name = "email", nullable = false, length = 100)
    @Pattern(regexp = "^[A-Za-z0-9]{1,50}@gmail.com", message = "El correo debe ser de tipo @gmail.com.")
    private String email;

    @Size(min = 4, max = 12, message = "La contraseña debe tener entre 4 y 12 caracteres")
    @NotNull(message = "Contraseña de usuario vacío")
    @Column(name = "password", nullable = false)
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "La contraseña solo puede contener caracteres alfanuméricos")
    private String password;

    @NotNull(message = "Tipo de usuario vacío")
    @Lob
    @Column(name = "tipo", nullable = false)
    @Pattern(regexp = "^(normal|aSdministrador)$", message = "Tipo de usuario no reconocido")
    private String tipo;

    @Column(name = "penalizacion_hasta")
    private LocalDate penalizacionHasta = null;

}