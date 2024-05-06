package com.tinyUrl.URLShortener.service;

import com.tinyUrl.URLShortener.DTO.UrlResponseDto;
import com.tinyUrl.URLShortener.DTO.inputDto;
import com.tinyUrl.URLShortener.model.URL;

public interface UrlService {
	public UrlResponseDto generateShortLink(inputDto urlDto);
	
	public URL getEncodedUrl(String url);
	
	public void deleteShortUrl(URL url);
}
