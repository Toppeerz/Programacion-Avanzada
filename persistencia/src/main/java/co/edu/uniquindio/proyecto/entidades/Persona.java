package co.edu.uniquindio.proyecto.entidades;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Persona implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(length = 10)
    private String cedula;

    @Column(nullable = false,length = 100)
    private String nombre;
    @Column(nullable = false,unique = true,length = 120)
    private String email;
    @ElementCollection
    @Column(nullable = false)
    private Map<String,String> telefono;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GeneroPersona genero;

    public Persona(String cedula, String nombre, String email) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.email = email;
    }

}