package mvx.emsi.hospital_mvc.sec.repositories;

import mvx.emsi.hospital_mvc.sec.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,String> {
    AppUser findByUsername(String username);

}
