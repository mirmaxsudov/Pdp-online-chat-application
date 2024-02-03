package pdp_pnnline.abdurahmon.code.model;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private UUID id;
    private String name;
    private String email;
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.id = UUID.randomUUID();
    }
}