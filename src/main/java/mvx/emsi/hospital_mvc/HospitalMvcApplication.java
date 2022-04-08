package mvx.emsi.hospital_mvc;

import mvx.emsi.hospital_mvc.entities.Patient;
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

@SpringBootApplication

public class HospitalMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalMvcApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
          /*  patientRepository.save(new Patient(null,"hassan",new Date(),false,122));
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






            });*/


        };
    }

}
