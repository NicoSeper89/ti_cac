package Nicolas.Sepertino.Api.tf_cac.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String username;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private Number age;
    private Date birthday;
    private String country;
    private String province;
    private String city;
    private String address;

}
