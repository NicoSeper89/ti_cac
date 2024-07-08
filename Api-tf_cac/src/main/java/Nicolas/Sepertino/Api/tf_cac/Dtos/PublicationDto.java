package Nicolas.Sepertino.Api.tf_cac.Dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicationDto {

    private String title;

    private String subtitle;

    private String category;

    private String text;

    private String image;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
