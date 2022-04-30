package mvx.emsi.hospital_mvc.repositories;



import mvx.emsi.hospital_mvc.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
