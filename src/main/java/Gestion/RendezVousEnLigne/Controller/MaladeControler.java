package Gestion.RendezVousEnLigne.Controller;

import Gestion.RendezVousEnLigne.Entities.Malades;
import Gestion.RendezVousEnLigne.Service.MaladeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MaladeControler {

    @Autowired
    private MaladeService maladeService;


    @GetMapping("/")
    public String viewHomePage(Model model, String keyword){
      return  findPaginated(1,model);
    }


    @GetMapping("/NouveauMalade")
    public String NouveauMalade(Model model){
        Malades malades=new Malades();
        model.addAttribute("malades",malades);
        return "New_malade";
    }

    @PostMapping("/savePatient")
    public String savePatient(@ModelAttribute("malades") Malades malades){
      maladeService.saveMalade(malades);
      return "redirect:/";
    }


    @GetMapping("/Update_Malade/{id}")
    public  String Update_Malade(@PathVariable(value = "id") long  id, Model model){
        Malades malades=maladeService.getMaladesById(id);
        model.addAttribute("malades",malades);
        return"Update_Malade";
    }

    @GetMapping("/Delete_Malade/{id}")
    public String Delete_Malade(@PathVariable(value = "id") long id){
        this.maladeService.deleteMaladeById(id);
        return "redirect:/";
    }


    @GetMapping("/page/{pageN}")
    public  String findPaginated(@PathVariable(value = "pageN")int pageN, Model model){
        int pageSize=5;
        Page<Malades> page=maladeService.findPaginated(pageN,pageSize);
        List<Malades> listeMalades=page.getContent();
        model.addAttribute("currentPage", pageN);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listeMalades", listeMalades);
        return "index";

    }

}
