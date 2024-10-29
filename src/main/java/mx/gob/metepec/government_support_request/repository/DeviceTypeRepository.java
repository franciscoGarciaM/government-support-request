package mx.gob.metepec.government_support_request.repository;

import mx.gob.metepec.government_support_request.entity.DeviceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DeviceTypeRepository extends JpaRepository<DeviceType, Long> {
    Optional<DeviceType> findByUuid(UUID uuid);
}
