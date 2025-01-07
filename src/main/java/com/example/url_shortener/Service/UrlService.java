package com.example.url_shortener.Service;

import com.example.url_shortener.Dto.UrlResponseDTO;
import com.example.url_shortener.Entity.Url;
import com.example.url_shortener.Repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    private static final String BASE_URL = "http://localhost:9000/";


    // Método para acortar la URL
    public UrlResponseDTO shortenUrl(String originalUrl) {
        String shortUrl = generateShortUrl();
        Url url = new Url(shortUrl, originalUrl);
        urlRepository.save(url);
        // Devuelve el DTO con la URL corta y la original
        return new UrlResponseDTO(BASE_URL + shortUrl, originalUrl);
    }


    // Método para recuperar la URL original desde la URL corta
    public String getOriginalUrl(String shortUrl) {
        Url url = urlRepository.findByShorturl(shortUrl);
        return url != null ? url.getOriginalurl() : null;
    }


    private String generateShortUrl() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder shortUrl = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            shortUrl.append(characters.charAt(random.nextInt(characters.length())));
        }
        return shortUrl.toString();
    }
}
