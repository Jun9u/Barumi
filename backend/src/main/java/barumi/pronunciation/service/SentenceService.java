package barumi.pronunciation.service;

import barumi.pronunciation.dto.SentenceResponseDto;
import barumi.pronunciation.repository.SentenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SentenceService {

    private final SentenceRepository sentenceRepository;

    public List<SentenceResponseDto> getAllSentences() {
        return sentenceRepository.findAll()
                .stream()
                .map(SentenceResponseDto::new)
                .toList();
    }
}
