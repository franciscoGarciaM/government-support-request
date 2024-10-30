package mx.gob.metepec.government_support_request.dto.request;

import lombok.Getter;
import lombok.Setter;
import mx.gob.metepec.government_support_request.entity.DeviceType;
import mx.gob.metepec.government_support_request.entity.Diagnosis;
import mx.gob.metepec.government_support_request.entity.ServiceStatus;
import mx.gob.metepec.government_support_request.entity.TypeService;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
public class SupportTicketRequest {

    private Long numTicket;
    private String deviceCharacteristics;
    private String repairDescription;
    private String ticketDetail;
    private LocalDate estimateDate;
    private LocalDate endDate;
    private ServiceStatusRequest serviceStatus;
    private DeviceTypeRequest deviceType;
    private TypeServiceRequest typeService;
    private DiagnosisRequest diagnosis;
    private String evidenceRoute;
    private List<UUID> evidenceUuids;
    private UUID clientUuid;
    private UUID technicalUuid;
    private UUID purchaseUuid;

}
