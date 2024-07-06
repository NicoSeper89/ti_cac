package Nicolas.Sepertino.Api.tf_cac.Repositories;

import Nicolas.Sepertino.Api.tf_cac.Entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MessageRepository extends JpaRepository<Message, UUID> {

}
