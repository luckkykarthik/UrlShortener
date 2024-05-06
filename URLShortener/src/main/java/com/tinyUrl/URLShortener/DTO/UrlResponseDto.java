package com.tinyUrl.URLShortener.DTO;

import java.time.LocalDateTime;

public class UrlResponseDto {

	private String Origin_Url;
	private String Shorturl;
	private LocalDateTime expirationDate;
	public UrlResponseDto() {
		super();
	}
	public UrlResponseDto(String origin_Url, String Shorturl, LocalDateTime expirationDate) {
		super();
		this.Origin_Url = origin_Url;
		this.Shorturl = Shorturl;
		this.expirationDate = expirationDate;
	}
	public String getOrigin_Url() {
		return Origin_Url;
	}
	public void setOrigin_Url(String origin_Url) {
		Origin_Url = origin_Url;
	}
	public String getShorturl() {
		return Shorturl;
	}
	public void setShorturl(String Shorturl) {
		this.Shorturl = Shorturl;
	}
	public LocalDateTime getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}
	@Override
	public String toString() {
		return "UrlResponseDto [Origin_Url=" + Origin_Url + ", Shorturl=" + Shorturl + ", expirationDate="
				+ expirationDate + "]";
	}
	
}
