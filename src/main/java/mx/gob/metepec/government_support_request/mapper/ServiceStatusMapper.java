package mx.gob.metepec.government_support_request.mapper;

import mx.gob.metepec.government_support_request.dto.response.ServiceStatusResponse;
import mx.gob.metepec.government_support_request.entity.ServiceStatus;

import java.util.ArrayList;
import java.util.List;

public class ServiceStatusMapper {

    public static ServiceStatusResponse mapEntityToResponse(ServiceStatus status) {
        ServiceStatusResponse response = new ServiceStatusResponse();
        response.setNameStatus(status.getNameStatus());
        response.setDescription(status.getDescription());
        response.setUuid(status.getUuid());
        response.setActive(status.getActive());
        response.setCreatedDate(status.getCreatedDate());
        response.setUpdatedDate(status.getUpdatedDate());
        return response;
    }

    public static List<ServiceStatusResponse> mapEntityListToResponseList(List<ServiceStatus> statusList) {
        List<ServiceStatusResponse> responseList = new ArrayList<>();
        for (ServiceStatus status : statusList) {
            responseList.add(mapEntityToResponse(status));
        }
        return responseList;
    }
}
