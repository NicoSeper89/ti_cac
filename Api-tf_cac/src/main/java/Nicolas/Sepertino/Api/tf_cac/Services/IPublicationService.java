package Nicolas.Sepertino.Api.tf_cac.Services;

import Nicolas.Sepertino.Api.tf_cac.Entities.Publication;

import java.util.List;
import java.util.UUID;

public interface IPublicationService {

    List<Publication> getAllPublications();
    Publication getPublicationById(UUID newPublication);
    Publication createPublication(Publication newPublication);

}
