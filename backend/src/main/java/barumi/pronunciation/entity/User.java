package barumi.pronunciation.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @Column(nullable = false, unique = true, length = 50)
    private String loginId;

    @Column(nullable = false)
    private String password;

    @Column(length = 10)
    private String gender;
    private Integer age;

    @Builder
    public User(String loginId, String password, String gender, Integer age) {
        this.loginId = loginId;
        this.password = password;
        this.gender = gender;
        this.age = age;
    }
}
