package miller.al.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Cat {

    @Id
    private String name;
    private Integer age;
    private String furColour;
    private String eyeColour;

}
