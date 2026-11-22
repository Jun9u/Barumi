package barumi.pronunciation.dto;

import barumi.pronunciation.entity.PracticeRecord;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PracticeRecordResponseDto {

    private final Long recordId;
    private final Long uid;
    private final Long sid;
    private final String audioUrl;
    private final Integer totalScore;
    private final String feedback;
    private final LocalDateTime practiceDate;

    public PracticeRecordResponseDto(PracticeRecord record) {
        this.recordId = record.getRecordId();
        this.uid = record.getUser().getUid();
        this.sid = record.getSentence().getSid();
        this.audioUrl = record.getAudioUrl();
        this.totalScore = record.getTotalScore();
        this.feedback = record.getFeedback();
        this.practiceDate = record.getPracticeDate();
    }
}
