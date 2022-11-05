package com.bean;

import org.springframework.web.multipart.MultipartFile;

public class JobBean {

	private int jobId;
	private String title;
	private String jdUrl;
	MultipartFile description;

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getJdUrl() {
		return jdUrl;
	}

	public void setJdUrl(String jdUrl) {
		this.jdUrl = jdUrl;
	}

	public MultipartFile getDescription() {
		return description;
	}

	public void setDescription(MultipartFile description) {
		this.description = description;
	}
}
