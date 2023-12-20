package shortener.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shortener.entities.Url;
import shortener.services.UrlService;

@RestController
@RequestMapping("/")
public class UrlController {

    @Autowired
    UrlService urlService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Url url) {
        return ResponseEntity.ok(urlService.save(url));
    };

    @GetMapping("{shortCode}")
    public ResponseEntity<?> findByShortCode(@PathVariable String shortCode) {
        Url url = urlService.findByShortCode(shortCode);

        return ResponseEntity.ok(url);
    }
}
