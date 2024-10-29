package mx.gob.metepec.government_support_request.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "diagnosis")
public class Diagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "diagnosis_id_gen")
    @SequenceGenerator(name = "diagnosis_id_gen", sequenceName = "support_diagnosis_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "failure", nullable = false, length = Integer.MAX_VALUE)
    private String failure;

    @Column(name = "uuid", nullable = false)
    private UUID uuid;

    @Column(name = "active", nullable = false)
    private Boolean active = false;

    @Column(name = "created_date", nullable = false)
    private LocalDate createdDate;

    @Column(name = "updated_date", nullable = false)
    private LocalDate updatedDate;

}