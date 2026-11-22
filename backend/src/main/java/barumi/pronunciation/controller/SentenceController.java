package barumi.pronunciation.controller;

import barumi.pronunciation.dto.SentenceResponseDto;
import barumi.pronunciation.service.SentenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sentences")
@RequiredArgsConstructor
public class SentenceController {
    private final SentenceService sentenceService;

    @GetMapping
    public ResponseEntity<List<SentenceResponseDto>> getSentences() {
        List<SentenceResponseDto> sentences = sentenceService.getAllSentences();
        return ResponseEntity.ok(sentences);
    }
}
