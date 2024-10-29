package mx.gob.metepec.government_support_request.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "evidence")
public class Evidence {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evidence_id_gen")
    @SequenceGenerator(name = "evidence_id_gen", sequenceName = "evidence_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "route", nullable = false, length = Integer.MAX_VALUE)
    private String route;

    @Column(name = "created_date", nullable = false)
    private LocalDate createdDate;

    @Column(name = "updated_date", nullable = false)
    private LocalDate updatedDate;

    @Column(name = "uuid", nullable = false)
    private UUID uuid;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "support_tickets_id", nullable = false)
    private SupportTicket supportTicket;

}