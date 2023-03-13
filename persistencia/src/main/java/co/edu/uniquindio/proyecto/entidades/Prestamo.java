package co.edu.uniquindio.proyecto.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Future;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Prestamo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime fechaPrestamo;

    @Future
    @Column(nullable = false)
    private LocalDate fechaDevolucion;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuarioPrestamo;
    @ManyToMany
    @ToString.Exclude
    private List<Libro> libros;

    public Prestamo(LocalDate fechaDevolucion, Usuario usuarioPrestamo, List<Libro> libros) {
        this.fechaDevolucion = fechaDevolucion;
        this.usuarioPrestamo = usuarioPrestamo;
        this.libros = libros;
    }
}
