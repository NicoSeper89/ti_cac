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
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public Message getMessageById(UUID messageId) {
        return messageRepository.findById(messageId).get();
    }

    @Override
    public Message createMessage(Message newMessage) {

        return messageRepository.save(newMessage);
    }

    @Override
    public Message updateMessage(UUID messageId, Message messageUpdatedData) {
        Message message = messageRepository.findById(messageId).get();

        if (messageUpdatedData.getEmail() != null) message.setEmail(messageUpdatedData.getEmail());
        if (messageUpdatedData.getName() != null) message.setName(messageUpdatedData.getName());
        if (messageUpdatedData.getSurname() != null) message.setSurname(messageUpdatedData.getSurname());
        if (messageUpdatedData.getBody() != null) message.setBody(messageUpdatedData.getBody());

        return messageRepository.save(message);
    }

    @Override
    public void deleteMessage(UUID messageId) {
        messageRepository.deleteById(messageId);
    }
}
