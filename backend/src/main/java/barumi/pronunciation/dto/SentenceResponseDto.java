package barumi.pronunciation.dto;

import barumi.pronunciation.entity.Sentence;
import lombok.Getter;

@Getter
public class SentenceResponseDto {

    private final Long sid;
    private final String content;
    private final String tag;

    public SentenceResponseDto(Sentence sentence) {
        this.sid = sentence.getSid();
        this.content = sentence.getContent();
        this.tag = sentence.getTag();
    }
}
