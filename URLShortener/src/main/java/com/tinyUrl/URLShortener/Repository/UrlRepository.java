package com.tinyUrl.URLShortener.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tinyUrl.URLShortener.model.URL;

@Repository
public interface UrlRepository extends JpaRepository<URL,Long>{
	public URL findByshortenurl(String Shortenurl);
}
