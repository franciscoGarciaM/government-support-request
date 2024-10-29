package mx.gob.metepec.government_support_request.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "type_service")
public class TypeService {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_service_id_gen")
    @SequenceGenerator(name = "type_service_id_gen", sequenceName = "sla_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "description", nullable = false, length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "sla_hours", nullable = false)
    private Integer slaHours;

    @Column(name = "created_date", nullable = false)
    private LocalDate createdDate;

    @Column(name = "updated_date", nullable = false)
    private LocalDate updatedDate;

    @Column(name = "uuid", nullable = false)
    private UUID uuid;

    @Column(name = "active", nullable = false)
    private Boolean active = false;

}