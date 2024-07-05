package Nicolas.Sepertino.Api.tf_cac.controllers;

import Nicolas.Sepertino.Api.tf_cac.entities.Message;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/messages")
public class MessageControllers {

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public String getAllMessages () {
        return "All messages found";
    }

    @GetMapping("/{messageId}")
    @ResponseStatus(HttpStatus.OK)
    public String getMessageById(@PathVariable UUID messageId) {
        return "The message by id: " + messageId + " found";
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String createMessage(@RequestBody Message newMessage) {
        return "new message created : " + newMessage.toString();
    }

    @PutMapping("/{messageId}")
    @ResponseStatus(HttpStatus.OK)
    public String updateMessage(@PathVariable UUID id, @RequestBody Message messageUpdateData) {
        return "message with id " + id + " updated: " + messageUpdateData.toString();
    }

    @DeleteMapping("/{messageId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMessage() {
    }

}
