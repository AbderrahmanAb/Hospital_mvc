package mvx.emsi.hospital_mvc.web;

import lombok.AllArgsConstructor;
import mvx.emsi.hospital_mvc.entities.Medecin;
import mvx.emsi.hospital_mvc.entities.Patient;
import mvx.emsi.hospital_mvc.repositories.MedecinRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.Null;

@Controller
@AllArgsConstructor
public class MedecinController {
    MedecinRepository medecinRepository;
    @GetMapping(path = "/medecin")
    public String medecins(Model model, @RequestParam(name = "page",defaultValue = "0") int page, @RequestParam(name = "size",defaultValue = "5") int size, @RequestParam(name = "keyword",defaultValue = "") String keyword){
        Page<Medecin> pageMedecins = medecinRepository.findByNomContains(keyword, PageRequest.of(page, size));
        model.addAttribute("pages",new int[pageMedecins.getTotalPages()]);
        model.addAttribute("listMedecins",pageMedecins.getContent());
        model.addAttribute("CurrentPage",page);
        model.addAttribute("keyword",keyword);

        return "medecins";
    }
    @GetMapping(path = "/admin/formMedecins")
    public String formMedecins(Model model){
        model.addAttribute("medecin",new Medecin());
        return "formMedecins";
    }
    @GetMapping(path = "/admin/deleteM")
    public String delete(Long id){
        medecinRepository.deleteById(id);

        return "redirect:/medecin";
    }
    @GetMapping(path = "/admin/editM")
    public String editM(Model model,Long id){
        Medecin medecin =medecinRepository.findById(id).orElse(null);
        if(medecin==null) throw new RuntimeException("Page introuvable");
        model.addAttribute("medecin",medecin);

        return "editMedecin";
    }
    @PostMapping(path = "/admin/SaveM")
    public String Save(Model model, @Valid Medecin medecin, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "formPatients";
        medecinRepository.save(medecin);
        return "redirect:/medecin";

    }


}
