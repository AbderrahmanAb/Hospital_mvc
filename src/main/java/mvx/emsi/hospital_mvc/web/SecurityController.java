package mvx.emsi.hospital_mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    @GetMapping("/403")
    public String notAutorized(){
        return "403";
    }
}
