package Nicolas.Sepertino.Api.tf_cac.Repositories;

import Nicolas.Sepertino.Api.tf_cac.Entities.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, UUID> {

}
