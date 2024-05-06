package com.tinyUrl.URLShortener.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class URL {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	String originalurl;
	String shortenurl;
	LocalDateTime creationtime;
	LocalDateTime expirationtime;
	public URL() {
		super();
	}
	public URL(long id, String originalurl, String shortenurl, LocalDateTime creationtime,
			LocalDateTime expirationtime) {
		super();
		this.id = id;
		this.originalurl = originalurl;
		this.shortenurl = shortenurl;
		this.creationtime = creationtime;
		this.expirationtime = expirationtime;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOriginalurl() {
		return originalurl;
	}
	public void setOriginalurl(String originalurl) {
		this.originalurl = originalurl;
	}
	public String getShortenurl() {
		return shortenurl;
	}
	public void setShortenurl(String shortenurl) {
		this.shortenurl = shortenurl;
	}
	public LocalDateTime getCreationtime() {
		return creationtime;
	}
	public void setCreationtime(LocalDateTime creationtime) {
		this.creationtime = creationtime;
	}
	public LocalDateTime getExpirationtime() {
		return expirationtime;
	}
	public void setExpirationtime(LocalDateTime expirationtime) {
		this.expirationtime = expirationtime;
	}
	@Override
	public String toString() {
		return "URL [id=" + id + ", originalurl=" + originalurl + ", shortenurl=" + shortenurl + ", creationtime="
				+ creationtime + ", expirationtime=" + expirationtime + "]";
	}
	
}
