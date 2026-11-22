package barumi.pronunciation.controller;

import barumi.pronunciation.dto.PracticeRecordResponseDto;
import barumi.pronunciation.service.PracticeRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/records")
@RequiredArgsConstructor
public class PracticeRecordController {

    private final PracticeRecordService practiceRecordService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<PracticeRecordResponseDto> uploadAndCreateRecord(
            @RequestParam(value = "uid", defaultValue = "1") Long uid,
            @RequestParam("sid") Long sid,
            @RequestParam("file")MultipartFile file) {

        if (file.isEmpty())
            throw new IllegalArgumentException("업로드된 오디오 파일이 비어 있습니다.");

        PracticeRecordResponseDto responseDto = practiceRecordService.createRecord(uid, sid, file);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
}
