package Nicolas.Sepertino.Api.tf_cac.Services;

import Nicolas.Sepertino.Api.tf_cac.Entities.Publication;
import Nicolas.Sepertino.Api.tf_cac.Repositories.PublicationRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PublicationServiceImpl implements IPublicationService {

    private final PublicationRepository publicationRepository;

    @Override
    public Page<Publication> getAllPublications(Pageable pageable) {

        return publicationRepository.findAll(pageable);
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

    @Override
    public Publication updatePublication(UUID publicationId, Publication publicationUpdatedData) {

        Publication publication = publicationRepository.findById(publicationId).get();

        if (publicationUpdatedData.getTitle() != null) publication.setTitle(publicationUpdatedData.getTitle());
        if (publicationUpdatedData.getSubtitle() != null) publication.setSubtitle(publicationUpdatedData.getSubtitle());
        if (publicationUpdatedData.getCategory() != null) publication.setCategory(publicationUpdatedData.getCategory());
        if (publicationUpdatedData.getText() != null) publication.setText(publicationUpdatedData.getText());

        return publicationRepository.save(publication);
    }

    @Override
    public void deletePublication(UUID publicationId) {
        publicationRepository.deleteById(publicationId);
    }

}
