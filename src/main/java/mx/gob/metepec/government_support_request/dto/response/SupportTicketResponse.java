package mx.gob.metepec.government_support_request.dto.response;

import lombok.Getter;
import lombok.Setter;
import mx.gob.metepec.government_support_request.dto.response.external.EmployeeResponse;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
public class SupportTicketResponse {

    private Long numTicket;
    private String deviceCharacteristics;
    private String repairDescription;
    private String ticketDetail;
    private UUID uuid;
    private LocalDate estimateDate;
    private LocalDate endDate;
    private LocalDate createdDate;
    private ServiceStatusResponse serviceStatus;
    private DeviceTypeResponse deviceType;
    private TypeServiceResponse typeService;
    private DiagnosisResponse diagnosis;
    private List<UUID> evidenceUuids;
    private UUID clientUuid;
    private UUID technicalUuid;
    private UUID purchaseUuid;

    private EmployeeResponse client;
    private EmployeeResponse technical;
}
