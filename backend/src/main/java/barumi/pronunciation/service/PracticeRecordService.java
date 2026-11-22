package barumi.pronunciation.service;

import barumi.pronunciation.dto.PracticeRecordResponseDto;
import barumi.pronunciation.entity.PracticeRecord;
import barumi.pronunciation.entity.Sentence;
import barumi.pronunciation.entity.User;
import barumi.pronunciation.repository.PracticeRecordRepository;
import barumi.pronunciation.repository.SentenceRepository;
import barumi.pronunciation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class PracticeRecordService {

    private final PracticeRecordRepository practiceRecordRepository;
    private final UserRepository userRepository;
    private final SentenceRepository sentenceRepository;
    private final FileStorageService fileStorageService;

    @Transactional
    public PracticeRecordResponseDto createRecord(Long uid, Long sid, MultipartFile audioFile) {
        User user = userRepository.findById(uid)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다. uid=" + uid));
        Sentence sentence = sentenceRepository.findById(sid)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 예문입니다. sid=" + sid));

        String savedAudioUrl = fileStorageService.storeFile(audioFile);

        // 임시 AI 분석 로직
        Integer mockScore = 88;
        String mockFeedback = "전반적으로 또박또박 잘 발음했습니다. (테스트용 임시 결과)";

        PracticeRecord record = PracticeRecord.builder()
                .user(user)
                .sentence(sentence)
                .audioUrl(savedAudioUrl)
                .totalScore(mockScore)
                .feedback(mockFeedback)
                .build();

        PracticeRecord savedRecord = practiceRecordRepository.save(record);

        return new PracticeRecordResponseDto(savedRecord);
    }
}
