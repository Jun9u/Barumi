package barumi.pronunciation.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileStorageService {
    private final String uploadDir = System.getProperty("user.dir") + "/uploads/";

    public String storeFile(MultipartFile file) {
        File directory = new File(uploadDir);
        if (!directory.exists())
            directory.mkdirs();

        String originalFilename = file.getOriginalFilename();
        String extension = "";
        if (originalFilename != null && originalFilename.contains("."))
            extension = originalFilename.substring(originalFilename.lastIndexOf("."));

        String savedFileName = UUID.randomUUID() + extension;

        try {
            File destination = new File(uploadDir + savedFileName);
            file.transferTo(destination);
        } catch (IOException e) {
            throw new RuntimeException("오디오 파일 저장 중 오류가 발생했습니다.", e);
        }

        return "/uploads/" + savedFileName;
    }
}
