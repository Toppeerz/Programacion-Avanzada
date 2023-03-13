package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)

public class Autor extends Persona implements Serializable {

    @Positive
    @Max(9999)
    @Column(nullable = false)
    private Integer anioNacimiento;
    @ManyToMany(mappedBy = "autores")
    @ToString.Exclude
    private List<Libro> libros;

    public Autor(String codigo, String nombre, LocalDate fechaNacimiento, GeneroPersona genero, Integer anioNacimiento) {
        super(codigo, nombre, fechaNacimiento, genero);
        this.anioNacimiento = anioNacimiento;
    }
}
