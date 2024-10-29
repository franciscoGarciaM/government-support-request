package mx.gob.metepec.government_support_request.repository;

import mx.gob.metepec.government_support_request.entity.TypeService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TypeServiceRepository extends JpaRepository<TypeService, Long> {
    Optional<TypeService> findByUuid(UUID uuid);
}
