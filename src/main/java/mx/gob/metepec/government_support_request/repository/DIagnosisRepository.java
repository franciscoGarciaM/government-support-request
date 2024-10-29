package mx.gob.metepec.government_support_request.repository;

import mx.gob.metepec.government_support_request.entity.Diagnosis;
import mx.gob.metepec.government_support_request.service.DiagnosisService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DIagnosisRepository extends JpaRepository<Diagnosis, Long> {
    Optional<Diagnosis> findDiagnosisByUuid(UUID uuid);
}
