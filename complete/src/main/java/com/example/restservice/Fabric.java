package com.example.restservice;

public class Fabric {

	private long id;
	private  String content;

	public Fabric(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}
