package Nicolas.Sepertino.Api.tf_cac.Services;

import Nicolas.Sepertino.Api.tf_cac.Entities.Message;
import Nicolas.Sepertino.Api.tf_cac.Repositories.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements IMessageService {

    private final MessageRepository messageRepository;

    @Override
    public List<Message> getAllPublications() {
        return messageRepository.findAll();
    }

    @Override
    public Message getPublicationById(UUID messageId) {
        return messageRepository.findById(messageId).get();
    }

    @Override
    public Message createPublication(Message newMessage) {
        return messageRepository.save(newMessage);
    }

    @Override
    public Message updatePublication(UUID messageId, Message messageUpdatedData) {
        Message message = messageRepository.findById(messageId).get();

        if (messageUpdatedData.getEmail() != null) message.setEmail(messageUpdatedData.getEmail());
        if (messageUpdatedData.getOwner_name() != null) message.setOwner_name(messageUpdatedData.getOwner_name());
        if (messageUpdatedData.getMessage() != null) message.setMessage(messageUpdatedData.getMessage());
        if (messageUpdatedData.getDate() != null) message.setDate(messageUpdatedData.getDate());

        return messageRepository.save(message);
    }

    @Override
    public void deletePublication(UUID messageId) {
        messageRepository.deleteById(messageId);
    }
}
