package Nicolas.Sepertino.Api.tf_cac.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewControllers {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
    
}
