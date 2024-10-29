package mx.gob.metepec.government_support_request.service;

import mx.gob.metepec.government_support_request.dto.request.TypeServiceRequest;
import mx.gob.metepec.government_support_request.dto.response.TypeServiceResponse;
import mx.gob.metepec.government_support_request.entity.TypeService;
import mx.gob.metepec.government_support_request.exceptions.ResourceNotException;
import mx.gob.metepec.government_support_request.mapper.TypeServiceMapper;
import mx.gob.metepec.government_support_request.repository.TypeServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TypeServiceService {

    @Autowired
    private TypeServiceRepository typeServiceRepository;

    //GET
    public List<TypeServiceResponse> buscarTodos() {
        return TypeServiceMapper.mapEntityListToResponseList(typeServiceRepository.findAll());
        //ERROR//return TypeServiceMapper.mapEntityListToResponseList(typeServiceRepository.findAll());
    }

    //GET POR ID
    public TypeServiceResponse getByUuid(UUID uuid){
        TypeService type = typeServiceRepository.findByUuid(uuid).orElseThrow(() -> new ResourceNotException("Type Service not exist with UUID: " + uuid));
        return TypeServiceMapper.mapEntityToResponse(type);
    }

    //POST
    public TypeServiceResponse save(TypeServiceRequest typeServiceRequest) {
        TypeService typeService = TypeServiceMapper.mapRequestToEntity(typeServiceRequest);//conversion a entidad
        TypeService savedTS = typeServiceRepository.save(typeService);//guarda la entidad en repositorio
        return TypeServiceMapper.mapEntityToResponse(savedTS); //respuesta guardada en entidad

    }


}
