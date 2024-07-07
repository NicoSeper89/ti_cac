package Nicolas.Sepertino.Api.tf_cac.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import Nicolas.Sepertino.Api.tf_cac.Entities.Message;
import Nicolas.Sepertino.Api.tf_cac.Services.IMessageService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ViewControllers {

    private final IMessageService messageService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("messageForm", new Message());
        return "index";
    }
   
    @PostMapping("/submitForm")
    public String submitForm(@ModelAttribute Message messageForm) {

        System.out.println(messageForm);
        messageService.createMessage(messageForm);
        
        return "redirect:/";
    }

}
