package com.example.url_shortener.Controller;

import com.example.url_shortener.Dto.UrlRequestDto;
import com.example.url_shortener.Dto.UrlResponseDTO;
import com.example.url_shortener.Service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UrlController {
    @Autowired
    private UrlService urlService;

    // Endpoint para acortar una URL


    @PostMapping("/shorten")
    public ResponseEntity<UrlResponseDTO> shortenUrl(@RequestBody UrlRequestDto urlRequestDto) {
        UrlResponseDTO response = urlService.shortenUrl(urlRequestDto.getOriginalUrl());
        return ResponseEntity.ok(response);
    }


    // Método para recuperar la URL original
    @GetMapping("/{shortUrl}")
    public ResponseEntity<?> getOriginalUrl(@PathVariable String shortUrl) {
        String originalUrl = urlService.getOriginalUrl(shortUrl);
        if (originalUrl != null) {
            UrlResponseDTO response = new UrlResponseDTO("http://localhost:9000/" + shortUrl, originalUrl);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Url no encotrada"); // Puedes enviar un mensaje personalizado en lugar de `null`
        }
    }
}
