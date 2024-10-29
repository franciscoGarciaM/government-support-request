package mx.gob.metepec.government_support_request.mapper;

import mx.gob.metepec.government_support_request.dto.request.SupportTicketRequest;
import mx.gob.metepec.government_support_request.dto.response.*;
import mx.gob.metepec.government_support_request.entity.*;
import mx.gob.metepec.government_support_request.exceptions.ResourceNotException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SupportTicketMapper {

    public static SupportTicket mapRequestToEntity(SupportTicketRequest STicketRequest, DeviceType device, Diagnosis diagnosis, ServiceStatus status, TypeService type) {
        SupportTicket st = new SupportTicket();
        st.setNumTicket(STicketRequest.getNumTicket());
        st.setDeviceCharacteristics(STicketRequest.getDeviceCharacteristics());
        st.setRepairDescription(STicketRequest.getRepairDescription());
        st.setTicketDetail(STicketRequest.getTicketDetail());
        st.setUuid(UUID.randomUUID());
        st.setEstimateDate(STicketRequest.getEstimateDate());
        st.setEndDate(STicketRequest.getEndDate());
        //st.setEndDate(STicketRequest.getEndDate()); // Asegúrate de que este campo se establezca correctamente
        st.setCreatedDate(LocalDate.now());
        st.setUpdatedDate(LocalDate.now());
        st.setServiceStatus(status);
        st.setDeviceType(device);
        st.setTypeService(type);
        st.setDiagnosis(diagnosis);
        st.setClientUuid(UUID.randomUUID()); // O asigna el valor desde STicketRequest si corresponde
        //st.setPurchaseUuid(STicketRequest.getPurchaseUuid());
        //st.setPurchaseUuid(UUID.randomUUID());
        if (STicketRequest.getPurchaseUuid() != null) {
            st.setPurchaseUuid(STicketRequest.getPurchaseUuid());
        } else {
            st.setPurchaseUuid(null); // O simplemente puedes omitir esta línea, ya que ya es null por defecto.
        }
        // Maneja el technicalUuid
        if (STicketRequest.getTechnicalUuid() != null) {
            st.setTechnicalUuid(STicketRequest.getTechnicalUuid());
        } else {
            st.setTechnicalUuid(null); // O simplemente puedes omitir esta línea
        }
        return st;
    }

    public static SupportTicketResponse mapEntityToResponse(SupportTicket supportTicket) {
        SupportTicketResponse supportResponse = new SupportTicketResponse();
        supportResponse.setNumTicket(supportTicket.getNumTicket());
        supportResponse.setDeviceCharacteristics(supportTicket.getDeviceCharacteristics());
        supportResponse.setRepairDescription(supportTicket.getRepairDescription());
        supportResponse.setTicketDetail(supportTicket.getTicketDetail());
        supportResponse.setUuid(supportTicket.getUuid());
        supportResponse.setEstimateDate(supportTicket.getEstimateDate());
        supportResponse.setEndDate(supportTicket.getEndDate());

        //Mapeo Service Status
          ServiceStatus status = supportTicket.getServiceStatus();
        if (status != null) {
            ServiceStatusResponse sResponse = new ServiceStatusResponse();
            sResponse.setUuid(status.getUuid());
            sResponse.setNameStatus(status.getNameStatus());
            supportResponse.setServiceStatus(sResponse);//ERROR
        } else {
            supportResponse.setServiceStatus(null);
            throw new ResourceNotException("El status del service no existe");
        }

        //Mapeo Device Type
        DeviceType deviceType = supportTicket.getDeviceType();
        if (deviceType != null) {
            DeviceTypeResponse deviceResponse = new DeviceTypeResponse();
            deviceResponse.setUuid(deviceType.getUuid());
            deviceResponse.setNameDevice(deviceType.getNameDevice());
            supportResponse.setDeviceType(deviceResponse);
        } else {
            supportResponse.setDeviceType(null);
            throw new ResourceNotException("El type de device no existe");
        }

        //Mapeo Type Service
        TypeService typeService = supportTicket.getTypeService();
        if (typeService != null) {
            TypeServiceResponse typeServiceResponse = new TypeServiceResponse();
            typeServiceResponse.setUuid(typeService.getUuid());
            typeServiceResponse.setDescription(typeService.getDescription());
            typeServiceResponse.setSlaHours(typeService.getSlaHours());
            supportResponse.setTypeService(typeServiceResponse);
        } else {
            supportResponse.setTypeService(null);
            throw new ResourceNotException("El type de service no existe");
        }

        //mapeo Diagnosis
        Diagnosis diagnosis = supportTicket.getDiagnosis();
        if (diagnosis != null) {
            DiagnosisResponse diagnosisResponse = new DiagnosisResponse();
            diagnosisResponse.setUuid(diagnosis.getUuid());
            diagnosisResponse.setFailure(diagnosis.getFailure());
            supportResponse.setDiagnosis(diagnosisResponse);
        } else {
            supportResponse.setDiagnosis(null);
            throw new ResourceNotException("La Falla no existe");
        }

        return supportResponse;
    }

    public static List<SupportTicketResponse> mapEntityListToResponseList(List<SupportTicket> STicketList) {
        List<SupportTicketResponse> responseList = new ArrayList<>();
        for (SupportTicket supportTicket: STicketList) {
            responseList.add(mapEntityToResponse(supportTicket));
        }
        return responseList;
    }
}
