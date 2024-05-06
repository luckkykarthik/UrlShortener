package com.tinyUrl.URLShortener.ServImp;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;
import com.tinyUrl.URLShortener.DTO.UrlResponseDto;
import com.tinyUrl.URLShortener.DTO.inputDto;
import com.tinyUrl.URLShortener.Repository.UrlRepository;
import com.tinyUrl.URLShortener.model.URL;
import com.tinyUrl.URLShortener.service.UrlService;

@Service
public class UrlServImp implements UrlService{
	
	@Autowired
	private UrlRepository ur;

	@Override
	public UrlResponseDto generateShortLink(inputDto urlDto) {
		if(urlDto.getUrl().length()>0) {
			String encodedUrl=encodeUrl(urlDto.getUrl());
			URL obj=new URL();
			obj.setCreationtime(LocalDateTime.now());
			obj.setOriginalurl(urlDto.getUrl());
			obj.setShortenurl(encodedUrl);
			obj.setExpirationtime(getExpiration(obj.getCreationtime()));
			URL savedUrl=ur.save(obj);
			UrlResponseDto dto=new UrlResponseDto();
			dto.setExpirationDate(savedUrl.getExpirationtime());
			dto.setOrigin_Url(savedUrl.getOriginalurl());
			dto.setShorturl(savedUrl.getShortenurl());
			return dto;
		}
		return null;
	}

	private LocalDateTime getExpiration(LocalDateTime createDate) {
		return createDate.plusDays(1);
	}

	private String encodeUrl(String url) {
		String EncodedUrl="";
		LocalDateTime time=LocalDateTime.now();
		EncodedUrl=Hashing.murmur3_32().hashString(url.concat(time.toString()), StandardCharsets.UTF_8).toString();
		return EncodedUrl;
	}

	@Override
	public URL getEncodedUrl(String url) {
		URL Url=ur.findByshortenurl(url);
		return Url;
	}

	@Override
	public void deleteShortUrl(URL url) {
		ur.delete(url);
		
	}

}
