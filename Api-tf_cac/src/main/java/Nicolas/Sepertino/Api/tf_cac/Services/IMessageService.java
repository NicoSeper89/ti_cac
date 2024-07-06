package Nicolas.Sepertino.Api.tf_cac.Services;

import Nicolas.Sepertino.Api.tf_cac.Entities.Message;

import java.util.List;
import java.util.UUID;

public interface IMessageService {

    List<Message> getAllPublications();
    Message getPublicationById(UUID messageId);
    Message createPublication(Message newMessage);
    Message updatePublication(UUID messageId, Message messageUpdatedData);
    void deletePublication(UUID messageId);

}
