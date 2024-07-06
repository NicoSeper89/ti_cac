package Nicolas.Sepertino.Api.tf_cac.Services;

import Nicolas.Sepertino.Api.tf_cac.Entities.Publication;
import Nicolas.Sepertino.Api.tf_cac.Repositories.PublicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PublicationServiceImpl implements IPublicationService {

    private final PublicationRepository publicationRepository;

    @Override
    public List<Publication> getAllPublications() {
        return publicationRepository.findAll();
    }

    @Override
    public Publication getPublicationById(UUID idPublication) {
        return publicationRepository.findById(idPublication).get();
    }

    @Override
    public Publication createPublication(Publication newPublication) {

        publicationRepository.save(newPublication);

        return newPublication;
    }

}
