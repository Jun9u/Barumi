package barumi.pronunciation.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sentences")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Sentence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(length = 100)
    private String tag;

    @Builder
    public Sentence(String content, String tag) {
        this.content = content;
        this.tag= tag;
    }
}
