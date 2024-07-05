package Nicolas.Sepertino.Api.tf_cac.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "publication")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NonNull
    private String title;
    @NonNull
    private String subtitle;
    @NonNull
    private String category;
    @NonNull
    private String text;
    @NonNull
    private Date date;

}
