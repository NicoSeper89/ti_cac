package Nicolas.Sepertino.Api.tf_cac.Services;

import Nicolas.Sepertino.Api.tf_cac.Entities.Publication;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPublicationService {

    Page<Publication> getAllPublications(Pageable pageable);
    Publication getPublicationById(UUID newPublication);
    Publication createPublication(Publication newPublication);
    Publication updatePublication(UUID publicationId, Publication publicationUpdatedData);
    void deletePublication(UUID publicationId);
}
