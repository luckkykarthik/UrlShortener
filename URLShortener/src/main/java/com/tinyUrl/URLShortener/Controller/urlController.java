package com.tinyUrl.URLShortener.Controller;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tinyUrl.URLShortener.DTO.UrlResponseDto;
import com.tinyUrl.URLShortener.DTO.inputDto;
import com.tinyUrl.URLShortener.DTO.urlErrorResponseDto;
import com.tinyUrl.URLShortener.Exception.NoUrlEnteredException;
import com.tinyUrl.URLShortener.model.URL;
import com.tinyUrl.URLShortener.service.UrlService;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class urlController {

	@Autowired
	private UrlService urlServ;
	
	@PostMapping("/generate")
	public ResponseEntity<UrlResponseDto> CreateUser(@RequestBody inputDto input){
		if(input.getUrl().equals("")){
			throw new NoUrlEnteredException("Blank Url Found");
		}
		return new ResponseEntity<>(urlServ.generateShortLink(input),HttpStatus.CREATED);
	}
	
	@GetMapping("/{shortenurl}")
	public ResponseEntity<?> redirectToOriginal(@PathVariable String shortenurl,HttpServletResponse response) throws IOException {
		if(shortenurl.equals("")) {
			urlErrorResponseDto ue=new urlErrorResponseDto("Invalid Url",400);
			return new ResponseEntity<>(ue,HttpStatus.OK);
			
		}
		URL url=urlServ.getEncodedUrl(shortenurl);
		if(url==null) {
			urlErrorResponseDto ue=new urlErrorResponseDto("Url Not exists",400);
			return new ResponseEntity<>(ue,HttpStatus.OK);
		}
		if(url.getExpirationtime().isBefore(LocalDateTime.now())) {
			urlServ.deleteShortUrl(url);
			urlErrorResponseDto ue=new urlErrorResponseDto("Url Expired,Generate Fresh One",400);
			return new ResponseEntity<>(ue,HttpStatus.OK);
		}
		response.sendRedirect(url.getOriginalurl());
		return null;
	}
}
