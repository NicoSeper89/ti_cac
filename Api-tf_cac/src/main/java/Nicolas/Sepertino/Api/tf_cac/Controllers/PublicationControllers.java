package Nicolas.Sepertino.Api.tf_cac.Controllers;

import Nicolas.Sepertino.Api.tf_cac.Entities.Publication;
import Nicolas.Sepertino.Api.tf_cac.Services.IPublicationService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/publications")
@RequiredArgsConstructor
public class PublicationControllers {

    private final IPublicationService publicationService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Page<Publication> getAllPublications(
            @PageableDefault(page = 0, size = Integer.MAX_VALUE, sort = "createdAt", direction = Sort.Direction.ASC) Pageable pageable
           ) {      
                                
        return publicationService.getAllPublications(pageable);
    }

    @GetMapping("/{publicationId}")
    @ResponseStatus(HttpStatus.OK)
    public Publication getPublicationById(@PathVariable UUID publicationId) {
        return publicationService.getPublicationById(publicationId);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Publication createPublication(@RequestBody Publication newPublication) {
        return publicationService.createPublication(newPublication);
    }

    @PutMapping("/{publicationId}")
    @ResponseStatus(HttpStatus.OK)
    public Publication updatePublication(@PathVariable UUID publicationId,
            @RequestBody Publication publicationUpdateData) {
        return publicationService.updatePublication(publicationId, publicationUpdateData);
    }

    @DeleteMapping("/{publicationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublication(@PathVariable UUID publicationId) {
        publicationService.deletePublication(publicationId);
    }

}
