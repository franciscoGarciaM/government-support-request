package mx.gob.metepec.government_support_request.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "device_type")
public class DeviceType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "device_type_id_gen")
    @SequenceGenerator(name = "device_type_id_gen", sequenceName = "device_type_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name_device", nullable = false, length = Integer.MAX_VALUE)
    private String nameDevice;

    @Column(name = "code", length = Integer.MAX_VALUE)
    private String code;

    @Column(name = "created_date", nullable = false)
    private LocalDate createdDate;

    @Column(name = "updated_date", nullable = false)
    private LocalDate updatedDate;

    @Column(name = "uuid", nullable = false)
    private UUID uuid;

    @Column(name = "active", nullable = false)
    private Boolean active = false;

}