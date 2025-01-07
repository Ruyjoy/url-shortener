package com.example.url_shortener.Repository;

import com.example.url_shortener.Entity.Url;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends MongoRepository<Url, String> {
    Url findByShorturl(String shorturl);
}
