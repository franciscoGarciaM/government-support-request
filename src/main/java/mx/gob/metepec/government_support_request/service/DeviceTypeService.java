package mx.gob.metepec.government_support_request.service;

import mx.gob.metepec.government_support_request.dto.request.DeviceTypeRequest;
import mx.gob.metepec.government_support_request.dto.response.DeviceTypeResponse;
import mx.gob.metepec.government_support_request.entity.DeviceType;
import mx.gob.metepec.government_support_request.exceptions.ResourceNotException;
import mx.gob.metepec.government_support_request.mapper.DeviceTypeMapper;
import mx.gob.metepec.government_support_request.repository.DeviceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.UUID;

@Service
public class DeviceTypeService {

    @Autowired
    private DeviceTypeRepository deviceTypeRepository;

    //GET
    public List<DeviceTypeResponse> buscarTodos(){
        return DeviceTypeMapper.mapEntityListToResponseList(deviceTypeRepository.findAll());
    }

    //GET X ID
    public DeviceTypeResponse getByUuid(UUID uuid){
        DeviceType device = deviceTypeRepository.findByUuid(uuid).orElseThrow(() -> new ResourceNotException("Type Service not exist with UUID: " + uuid));
        return DeviceTypeMapper.mapEntityToResponse(device);
    }

    //POST
    public DeviceTypeResponse save(DeviceTypeRequest request){
        DeviceType device = DeviceTypeMapper.mapRequestToEntity(request);
        DeviceType savedDevice = deviceTypeRepository.save(device);
        return DeviceTypeMapper.mapEntityToResponse(savedDevice);
    }

    //DELETE
    public void delete(UUID uuid){
        DeviceType device = deviceTypeRepository.findByUuid(uuid).orElseThrow(() -> new ResourceNotException("Employee not exist with uuid :" + uuid));
        deviceTypeRepository.delete(device);
    }
}
