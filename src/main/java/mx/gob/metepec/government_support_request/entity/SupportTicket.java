package mx.gob.metepec.government_support_request.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "support_tickets")
public class SupportTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "support_tickets_id_gen")
    @SequenceGenerator(name = "support_tickets_id_gen", sequenceName = "support_tickets_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "num_ticket", nullable = false)
    private Long numTicket;

    @Column(name = "device_characteristics", nullable = false, length = Integer.MAX_VALUE)
    private String deviceCharacteristics;

    @Column(name = "repair_description", nullable = false, length = Integer.MAX_VALUE)
    private String repairDescription;

    @Column(name = "ticket_detail", nullable = false, length = Integer.MAX_VALUE)
    private String ticketDetail;

    @Column(name = "estimate_date", nullable = false)
    private LocalDate estimateDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "created_date", nullable = false)
    private LocalDate createdDate;

    @Column(name = "updated_date", nullable = false)
    private LocalDate updatedDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "service_status_id", nullable = false)
    private ServiceStatus serviceStatus;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "device_type_id", nullable = false)
    private DeviceType deviceType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "type_service_id", nullable = false)
    private TypeService typeService;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "diagnosis_id", nullable = false)
    private Diagnosis diagnosis;

    @OneToMany(mappedBy = "supportTicket", cascade = CascadeType.ALL)
    private List<Evidence> evidences = new ArrayList<>();

    @Column(name = "client_uuid", nullable = false)
    private UUID clientUuid;

    //@Column(name = "technical_uuid", nullable = false)
    @Column(name = "technical_uuid", nullable = true)
    private UUID technicalUuid;

    //@Column(name = "purchase_uuid", nullable = false)
    @Column(name = "purchase_uuid", nullable = true)
    private UUID purchaseUuid;

    @Column(name = "uuid", nullable = false)
    private UUID uuid;

}