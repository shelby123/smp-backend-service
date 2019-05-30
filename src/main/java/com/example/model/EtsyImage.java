package com.example.model;

public class EtsyImage {


	private int imageId;
	private int postId;
	private String imageUrl;
	
	
	public EtsyImage(int imageId, int postId, String imageUrl) {
		super();
		this.imageId = imageId;
		this.postId = postId;
		this.imageUrl = imageUrl;
	}
	
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	
	
}
