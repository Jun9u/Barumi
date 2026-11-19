package barumi.pronunciation;

import barumi.pronunciation.entity.PracticeRecord;
import barumi.pronunciation.entity.Sentence;
import barumi.pronunciation.entity.User;
import barumi.pronunciation.repository.PracticeRecordRepository;
import barumi.pronunciation.repository.SentenceRepository;
import barumi.pronunciation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner { // 실행 테스트 파일

    private final UserRepository userRepository;
    private final SentenceRepository sentenceRepository;
    private final PracticeRecordRepository practiceRecordRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (userRepository.count() > 0)
            return;

        User testUser = User.builder()
                .loginId("testUser1")
                .password("1234")
                .gender("M")
                .age(25)
                .build();
        User savedUser = userRepository.save(testUser);

        Sentence s1 = sentenceRepository.save(Sentence.builder()
                .content("사과가 맛있습니다.123")
                .tag("치조 마찰음(ㅅ)")
                .build());
        Sentence s2 = sentenceRepository.save(Sentence.builder()
                .content("불과 뿔과 풀을 구분해 보세요.")
                .tag("평음/경음/격음(ㅂ/ㅃ/ㅍ)")
                .build());
        Sentence s3 = sentenceRepository.save(Sentence.builder()
                .content("신라의 역사를 공부합니다.")
                .tag("음운 변동(유음화)")
                .build());

        PracticeRecord record = PracticeRecord.builder()
                .user(savedUser)
                .sentence(s1)
                .audioUrl("/uploads/sameple_test.wav")
                .totalScore(85)
                .feedback("전반적으로 좋으나 'ㅅ' 발음이 약간 샙니다.")
                .build();
        practiceRecordRepository.save(record);

        System.out.println("=== 초기 테스트 데이터 세팅 완료 ===");
    }
}
