package mx.gob.metepec.government_support_request.mapper;

import mx.gob.metepec.government_support_request.dto.request.TypeServiceRequest;
import mx.gob.metepec.government_support_request.dto.response.TypeServiceResponse;
import mx.gob.metepec.government_support_request.entity.TypeService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TypeServiceMapper {

    public static TypeService mapRequestToEntity(TypeServiceRequest typeServiceRequest) {
        TypeService typeService = new TypeService();
        typeService.setDescription(typeServiceRequest.getDescription());
        typeService.setSlaHours(typeServiceRequest.getSlaHours());
        typeService.setUuid(UUID.randomUUID());
        typeService.setActive(true);
        typeService.setCreatedDate(LocalDate.now());
        typeService.setUpdatedDate(LocalDate.now());
        return typeService;
    }

    public static TypeServiceResponse mapEntityToResponse(TypeService typeService) {
        TypeServiceResponse typeServiceResponse = new TypeServiceResponse();
        typeServiceResponse.setDescription(typeService.getDescription());
        typeServiceResponse.setSlaHours(typeService.getSlaHours());
        typeServiceResponse.setUuid(typeService.getUuid());
        typeServiceResponse.setActive(typeService.getActive());
        return typeServiceResponse;
    }

    public static List<TypeServiceResponse> mapEntityListToResponseList(List<TypeService> typeServiceList) {
        List<TypeServiceResponse> typeServiceResponseList = new ArrayList<>();
        for (TypeService typeService : typeServiceList) {
            typeServiceResponseList.add(mapEntityToResponse(typeService));
        }
        return typeServiceResponseList;
    }
}
