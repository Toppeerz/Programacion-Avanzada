package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Libro implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 50)
    private String isbn;
    @Column(nullable = false, length = 100)
    private String nombre;

    @Positive
    @Column(nullable = false)
    private Integer unidades;

    @Positive
    @Column(nullable = false)
    private Integer anio;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 20)
    private GeneroLibro genero;
    @ManyToMany(mappedBy = "libros")
    @ToString.Exclude
    private List<Prestamo> prestamos;
    @ManyToMany
    @ToString.Exclude
    private List<Autor> autores;

    public Libro(String isbn, String nombre, Integer unidades, Integer anio, GeneroLibro genero, List<Autor> autores) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.unidades = unidades;
        this.anio = anio;
        this.genero = genero;
        this.autores = autores;
    }
}
