package Nicolas.Sepertino.Api.tf_cac.Controllers;

import Nicolas.Sepertino.Api.tf_cac.Entities.Message;
import Nicolas.Sepertino.Api.tf_cac.Services.IMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/messages")
@RequiredArgsConstructor
public class MessageControllers {

    private final IMessageService messageService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Message> getAllMessages () {
        return messageService.getAllPublications();
    }

    @GetMapping("/{messageId}")
    @ResponseStatus(HttpStatus.OK)
    public Message getMessageById(@PathVariable UUID messageId) {
        return messageService.getPublicationById(messageId);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Message createMessage(@RequestBody Message newMessage) {
        return messageService.createPublication(newMessage);
    }

    @PutMapping("/{messageId}")
    @ResponseStatus(HttpStatus.OK)
    public Message updateMessage(@PathVariable UUID messageId, @RequestBody Message messageUpdateData) {
        return messageService.updatePublication(messageId, messageUpdateData);
    }

    @DeleteMapping("/{messageId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMessage(@PathVariable UUID messageId) {
        messageService.deletePublication(messageId);
    }

}
