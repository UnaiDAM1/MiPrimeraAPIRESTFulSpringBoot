package org.example.miprimeraapirestful.DAOS;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@Entity
@Table(name = "ejemplar")
public class Ejemplar {
    // Al generar un ejemplar se le asignará un ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    // Es una clase la cual contiene un objeto que es otra clase, por ello tiene relación ManyToOne
    // y tiene un OnDelete tipo cascade que si se elimina el libro que contiene también se borre
    // este objeto
    @NotNull(message = "ISBN vacío")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "isbn", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private org.example.miprimeraapirestful.DAOS.Libro isbn;

    @NotNull(message = "Estado vacío")
    @Column(name = "estado", nullable = false)
    @Pattern(regexp = "^(Disponible|Prestado|Dañado)$", message = "Estado no registrado: debe ser Disponible, Prestado, Dañado")
    private String Estado;

}