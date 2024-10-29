package mx.gob.metepec.government_support_request.service;

import mx.gob.metepec.government_support_request.dto.response.ServiceStatusResponse;
import mx.gob.metepec.government_support_request.entity.ServiceStatus;
import mx.gob.metepec.government_support_request.exceptions.ResourceNotException;
import mx.gob.metepec.government_support_request.mapper.ServiceStatusMapper;
import mx.gob.metepec.government_support_request.repository.ServiceStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServiceStatusService {

    @Autowired
    private ServiceStatusRepository serviceStatusRepository;

    //GET
    public List<ServiceStatusResponse> buscarTodos(){
        return ServiceStatusMapper.mapEntityListToResponseList(serviceStatusRepository.findAll());
    }

    //GET X ID
    public ServiceStatusResponse getByUuid(UUID uuid){
        ServiceStatus status = serviceStatusRepository.findByUuid(uuid).orElseThrow(() -> new ResourceNotException("Type Service not exist with UUID: " + uuid));
        return ServiceStatusMapper.mapEntityToResponse(status);
    }


}
