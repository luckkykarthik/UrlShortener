package com.tinyUrl.URLShortener.DTO;

public class urlErrorResponseDto {
	String error;
	int status;
	public urlErrorResponseDto() {
		super();
	}
	public urlErrorResponseDto(String error, int status) {
		super();
		this.error = error;
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "urlErrorResponseDto [error=" + error + ", status=" + status + "]";
	}
	
}
