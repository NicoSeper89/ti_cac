package Nicolas.Sepertino.Api.tf_cac.Services;

import Nicolas.Sepertino.Api.tf_cac.Entities.Message;

import java.util.List;
import java.util.UUID;

public interface IMessageService {

    List<Message> getAllMessages();
    Message getMessageById(UUID messageId);
    Message createMessage(Message newMessage);
    Message updateMessage(UUID messageId, Message messageUpdatedData);
    void deleteMessage(UUID messageId);

}
