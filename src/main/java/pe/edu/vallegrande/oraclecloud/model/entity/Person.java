package pe.edu.vallegrande.oraclecloud.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "PERSONA")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDPER")
    private Long id;

    @Column(name = "DNIPER")
    private String dni;

    @Column(name = "NOMPER")
    private String name;

    @Column(name = "APEPER")
    private String lastname;

    @Column(name = "EMAPER")
    private String email;

    @Column(name = "CELPER")
    private String phone;

    @Column(name = "TIPPER")
    private String type;

    @Column(name = "ESTPER")
    private String status;

    @Column(name = "FECNACPER")
    private LocalDate birthdate;

}
