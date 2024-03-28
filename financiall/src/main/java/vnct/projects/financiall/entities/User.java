package vnct.projects.financiall.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vnct.projects.financiall.model.UserDTO;
import vnct.projects.financiall.model.UserObject;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    private String role;

    public User(String name) {
        this.name = name;
        this.role = "member";
    }

    public UserObject toUserObject() {
        return new UserObject().id(id).name(name).role(role);
    }

    public UserDTO toUserDto() {
        return new UserDTO().name(name);
    }

    public static User fromUserObject(UserObject obj) {
        return new User(obj.getId(), obj.getName(), obj.getRole());
    }

    public static User fromUserDto(UserDTO dto) {
        return new User(dto.getName());
    }
}
