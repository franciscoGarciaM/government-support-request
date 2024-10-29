package mx.gob.metepec.government_support_request.service;

import jakarta.transaction.Transactional;
import mx.gob.metepec.government_support_request.dto.request.SupportTicketRequest;
import mx.gob.metepec.government_support_request.dto.response.SupportTicketResponse;
import mx.gob.metepec.government_support_request.entity.*;
import mx.gob.metepec.government_support_request.exceptions.ResourceNotException;
import mx.gob.metepec.government_support_request.mapper.SupportTicketMapper;
import mx.gob.metepec.government_support_request.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SupportTicketService {

    @Autowired
    private SupportTicketRepository supportTicketRepository;

    @Autowired
    private DeviceTypeRepository deviceTypeRepository;

    @Autowired
    private TypeServiceRepository typeServiceRepository;

    @Autowired
    private DIagnosisRepository diagnosisRepository;

    @Autowired
    private ServiceStatusRepository serviceStatusRepository;

    //GET
    public List<SupportTicketResponse> buscarTodos(){
        return SupportTicketMapper.mapEntityListToResponseList(supportTicketRepository.findAll());
    }

    public SupportTicketResponse getByUuid(UUID uuid){
        SupportTicket support = supportTicketRepository.findByUuid(uuid).orElseThrow(() -> new RuntimeException("Support ticket not found"));
        return SupportTicketMapper.mapEntityToResponse(support);
    }

    //POST
    @Transactional
    public SupportTicketResponse save(SupportTicketRequest supportTicketRequest){
        //uuid de DeviceType
        DeviceType device = deviceTypeRepository.findByUuid(supportTicketRequest.getDeviceType().getUuid())
                .orElseThrow(() -> new ResourceNotException("Device type not found"));
        //uuid de TypeService
        TypeService service = typeServiceRepository.findByUuid(supportTicketRequest.getTypeService().getUuid())
                .orElseThrow(() -> new ResourceNotException("Type service not found"));
        //uuid de Diagnosis
        Diagnosis diagnosis = diagnosisRepository.findDiagnosisByUuid(supportTicketRequest.getDiagnosis().getUuid())
                .orElseThrow(() -> new ResourceNotException("Diagnosis not found"));
        //uuid de ServiceStatus
        ServiceStatus status = serviceStatusRepository.findByUuid(supportTicketRequest.getServiceStatus().getUuid())
                .orElseThrow(() -> new ResourceNotException("Service status not found"));

        SupportTicket supportTicket = SupportTicketMapper.mapRequestToEntity(supportTicketRequest, device, diagnosis, status, service);

        List<Evidence> evidences = new ArrayList<>();
        /*
        if (supportTicketRequest.getEvidenceUuids() != null) {
            for (UUID uuid : supportTicketRequest.getEvidenceUuids()) {
                Evidence evidence = new Evidence();
                evidence.setRoute("rute-del-archivo");
                evidence.setUuid(UUID.randomUUID());
                evidence.setCreatedDate(LocalDate.now());
                evidence.setUpdatedDate(LocalDate.now());
                evidence.setSupportTickets(supportTicket);
                evidences.add(evidence);
            }
            supportTicket.setEvidence(evidences);
        }*/
        if (supportTicketRequest.getEvidenceRoute() != null) { // Cambia aquí
            Evidence evidence = new Evidence();
            evidence.setRoute(supportTicketRequest.getEvidenceRoute()); // Usa el texto del request
            evidence.setUuid(UUID.randomUUID());
            evidence.setCreatedDate(LocalDate.now());
            evidence.setUpdatedDate(LocalDate.now());
            evidence.setSupportTicket(supportTicket);
            evidences.add(evidence);
        }
        supportTicket.setEvidences(evidences);
        return SupportTicketMapper.mapEntityToResponse(supportTicketRepository.save(supportTicket));
    }
}
