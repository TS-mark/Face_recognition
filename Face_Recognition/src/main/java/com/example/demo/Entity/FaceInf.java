package com.example.demo.Entity;

public class FaceInf {
	private boolean face;//如果非人脸时face值为false
	public boolean isFace() {
		return face;
	}
	public void setFace(boolean face) {
		this.face = face;
	}
	private String age;
	private String beauty;
	private String expression;//表情
	private String gender;
	private String glasses;
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getBeauty() {
		return beauty;
	}
	public void setBeauty(String beauty) {
		this.beauty = beauty;
	}
	public String getExpression() {
		return expression;
	}
	public void setExpression(String expression) {
		this.expression = expression;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGlasses() {
		return glasses;
	}
	public void setGlasses(String glass) {
		this.glasses = glass;
	}
	
	
}
