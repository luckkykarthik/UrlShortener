package com.tinyUrl.URLShortener.DTO;

public class inputDto {
	String url;

	public inputDto() {
		super();
	}

	public inputDto(String url) {
		super();
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "inputDto [url=" + url + "]";
	}

	
}
