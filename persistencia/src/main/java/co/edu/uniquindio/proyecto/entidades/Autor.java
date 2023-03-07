package co.edu.uniquindio.proyecto.entidades;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Autor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;
    @Column(length=100,nullable = false)
    private String nombre;
    @Positive
    @Max(9999)
    @Column(nullable = false)
    private Integer anioNacimiento;


    public Autor(String nombre, Integer anioNacimiento) {
        this.nombre = nombre;
        this.anioNacimiento = anioNacimiento;
    }

}
