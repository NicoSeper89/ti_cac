package Nicolas.Sepertino.Api.tf_cac.controllers;

import Nicolas.Sepertino.Api.tf_cac.entities.Publication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/publications")
public class PublicationControllers {

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
    public String createPublication(@RequestBody Publication newPublication) {
        return "new publication created :" + newPublication.toString();
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
