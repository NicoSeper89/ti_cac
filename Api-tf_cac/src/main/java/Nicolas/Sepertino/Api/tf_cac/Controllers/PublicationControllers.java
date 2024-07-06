package Nicolas.Sepertino.Api.tf_cac.Controllers;

import Nicolas.Sepertino.Api.tf_cac.Entities.Publication;
import Nicolas.Sepertino.Api.tf_cac.Services.IPublicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("api/publications")
@RequiredArgsConstructor
public class PublicationControllers {

    private final IPublicationService publicationService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public String getAllPublications () {
        return "all publications found";
    }

    @GetMapping("/{publicationId}")
    @ResponseStatus(HttpStatus.OK)
    public String getPublicationById(@PathVariable UUID publicationId) {
        return "publication by id: " + publicationId + " found";
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Publication createPublication(@RequestBody Publication newPublication) {
        return publicationService.createPublication(newPublication);
    }

    @PutMapping("/{publicationId}")
    @ResponseStatus(HttpStatus.OK)
    public String updatePublication(@PathVariable UUID publicationId, @RequestBody Publication publicationUpdateData) {
        return "publication with id " + publicationId + " updated: " + publicationUpdateData.toString();
    }

    @DeleteMapping("/{publicationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePublication(@PathVariable UUID publicationId) {
    }

}
