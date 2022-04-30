package mvx.emsi.hospital_mvc;

import mvx.emsi.hospital_mvc.entities.Medecin;
import mvx.emsi.hospital_mvc.entities.Patient;
import mvx.emsi.hospital_mvc.repositories.MedecinRepository;
import mvx.emsi.hospital_mvc.sec.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import mvx.emsi.hospital_mvc.repositories.PatientRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication

public class HospitalMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalMvcApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository, MedecinRepository medecinRepository){
        return args -> {
            patientRepository.save(new Patient(null,"hassan",new Date(),false,122));
            patientRepository.save(new Patient(null,"mohammed",new Date(),true,120));
            patientRepository.save(new Patient(null,"yassine",new Date(),false,158));
            patientRepository.save(new Patient(null,"noha",new Date(),true,1200));
            patientRepository.findAll().forEach(p->{
                System.out.println("*************************");
                System.out.println(p.getId());
                System.out.println(p.getNom());
                System.out.println(p.getNom());
                System.out.println(p.getScore());
                System.out.println("*************************");






            });
            Stream.of("aymane","Hanane","yassmine").forEach(name->{
                Medecin medecin = new Medecin();
                medecin.setNom(name);
                medecin.setEmail(name+"@gmail.com");
                medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                medecinRepository.save(medecin);

            });


        };
    }
    //@Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args -> {
          /*  securityService.saveUser("mohammed","1234","1234");
            securityService.saveUser("yassmine","1234","1234");
            securityService.saveUser("hassan","1234","1234");
            securityService.saveNewRole("USER","");
            securityService.saveNewRole("ADMIN","");
            securityService.addRoleToUser("mohammed","USER");*/
           //securityService.addRoleToUser("hassan","ADMIN");
            securityService.addRoleToUser("hassan","USER");
        };
    }

}
