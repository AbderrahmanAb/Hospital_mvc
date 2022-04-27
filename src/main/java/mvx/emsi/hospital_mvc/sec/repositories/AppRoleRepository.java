package mvx.emsi.hospital_mvc.sec.repositories;

import mvx.emsi.hospital_mvc.sec.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    AppRole findByRoleName(String rolename);
}
