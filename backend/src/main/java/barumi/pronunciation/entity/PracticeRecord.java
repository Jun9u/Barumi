package barumi.pronunciation.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "practice_records")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PracticeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recordId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sid", nullable = false)
    private Sentence sentence;

    @Column(nullable = false, length = 500)
    private String audioUrl;

    private Integer totalScore;

    @Column(columnDefinition = "TEXT")
    private String feedback;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime practiceDate;

    @Builder
    public PracticeRecord(User user, Sentence sentence, String audioUrl, Integer totalScore, String feedback) {
        this.user = user;
        this.sentence = sentence;
        this.audioUrl = audioUrl;
        this.totalScore = totalScore;
        this.feedback = feedback;
    }
}
