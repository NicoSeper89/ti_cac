package Nicolas.Sepertino.Api.tf_cac.Controllers;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import Nicolas.Sepertino.Api.tf_cac.Dtos.PublicationDto;
import Nicolas.Sepertino.Api.tf_cac.Entities.Message;
import Nicolas.Sepertino.Api.tf_cac.Entities.Publication;
import Nicolas.Sepertino.Api.tf_cac.Services.IMessageService;
import Nicolas.Sepertino.Api.tf_cac.Services.IPublicationService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ViewControllers {

    private final IMessageService messageService;
    private final IPublicationService publicationService;

    @GetMapping("/")
    public String index(Model model) {

        List<Publication> publicationes = publicationService.getAllPublications();

        List<PublicationDto> publicationsDtos = publicationes.stream().map(publication -> {
            PublicationDto publicationDto = new PublicationDto();
            publicationDto.setTitle(publication.getTitle());
            publicationDto.setSubtitle(publication.getSubtitle());
            publicationDto.setText(publication.getText());
            publicationDto.setCategory(publication.getCategory());
            if (publication.getImage() != null) {
                publicationDto.setImage(Base64.getEncoder().encodeToString(publication.getImage()));
            }
            return publicationDto;
        }).collect(Collectors.toList());

        model.addAttribute("publications", publicationsDtos);

        model.addAttribute("messageForm", new Message());
        return "index";
    }
   
    @PostMapping("/submitForm")
    public String submitForm(@ModelAttribute Message messageForm) {

        messageService.createMessage(messageForm);
        
        return "redirect:/";
    }

}
