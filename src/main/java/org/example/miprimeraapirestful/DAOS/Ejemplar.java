package org.example.miprimeraapirestful.DAOS;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


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
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "isbn", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private org.example.miprimeraapirestful.DAOS.Libro isbn;

    public Ejemplar(Libro isbn) {
        this.isbn = isbn;
        this.estado = "Disponible";
    }

    public Ejemplar() {
    }

    // La columna estado será por defecto Disponible
    @ColumnDefault("'Disponible'")
    @Lob
    @Column(name = "estado")

    private String estado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Libro getIsbn() {
        return isbn;
    }

    public void setIsbn(Libro isbn) {
        this.isbn = isbn;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Ejemplar{" +
                "id=" + id +
                ", isbn=" + isbn +
                ", estado='" + estado + '\'' +
                '}';
    }
}