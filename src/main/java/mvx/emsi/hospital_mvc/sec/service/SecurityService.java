package mvx.emsi.hospital_mvc.sec.service;

import mvx.emsi.hospital_mvc.sec.entities.AppRole;
import mvx.emsi.hospital_mvc.sec.entities.AppUser;

public interface SecurityService {
    AppUser saveUser(String username,String password,String rePassword);
    AppRole saveNewRole(String roleName,String description);
    void addRoleToUser(String username,String roleName);
    void removeRoleFromUser(String username,String roleName);
    AppUser loadUserByUserName(String username);
}
