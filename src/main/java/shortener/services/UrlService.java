package shortener.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shortener.entities.Url;
import shortener.repositories.UrlRepository;

import java.security.SecureRandom;

@Service
public class UrlService {

    @Autowired
    UrlRepository urlRepository;

    /**
     * Generate a short code
     * returns a String 0f 8 characters (UpperCase, Lowercase, numbers)
     */
    private String generateShortCode() {
        final String ALLOWED_CHARACTERS = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890";
        final SecureRandom random = new SecureRandom();

        StringBuilder sb = new StringBuilder(8);

        for (int i = 0; i < 8; i++) {
            int randomIdx = random.nextInt(ALLOWED_CHARACTERS.length());
            char c = ALLOWED_CHARACTERS.charAt(randomIdx);

            sb.append(c);
        }

        return sb.toString();
    }

    public Url save(Url url) {
        String code = generateShortCode();
        url.setShortCode(code);
        return urlRepository.save(url);
    }

    public Url findByShortCode(String shortCode) {
        return urlRepository.findByShortCode(shortCode);
    }
}
