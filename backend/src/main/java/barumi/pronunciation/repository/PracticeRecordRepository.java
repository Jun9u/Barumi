package barumi.pronunciation.repository;

import barumi.pronunciation.entity.PracticeRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PracticeRecordRepository extends JpaRepository<PracticeRecord, Long> {
    List<PracticeRecord> findByUser_UidOrderByPracticeDateDesc(Long Uid);
}
