package miller.al.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Builder
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String catId;
    @Column( nullable = false )
    private String name;
    private Integer age;
    private FurColour furColour;
    private EyeColour eyeColour;

}
