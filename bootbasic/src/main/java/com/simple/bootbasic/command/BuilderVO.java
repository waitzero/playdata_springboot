package com.simple.bootbasic.command;

public class BuilderVO {

	//1. 멤버변수
	private String name;
	private int age;
	
	//5. 외부에서 객체 생성을 요구할 때 static키워드를 이용해서 내부의 빌더클래스를 생성해서 반환
	public static Builder builder() {
		return new Builder(); //내부클래스의 생성자
	}
	
	//.8 외부클래스의 생성자는 내부클래스를 받고, 멤버변수값을 저장한다
	private BuilderVO(Builder builder) {
		this.name = builder.name;
		this.age = builder.age;
	}
	//값 확인
	@Override
	public String toString() {
		return "BuilderVO [name=" + name + ", age=" + age + "]";
	}

	//2. 내부클래스 -> 외부클래스를 생성하지 않고도, 내부클래스에 접근이가능 
	public static class Builder {
		
		//3. 내부클래스의 멤버변수
		private String name;
		private int age;
		
		//4. 생성자를 제한
		private Builder() {}
		
		//6. setter메서드를 생성하고, 나를 반환시킨다.
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder age(int age) {
			this.age = age;
			return this;
		}
		
		//7. 최종적으로 내부클래스에서 build()메서드를 이용해서
		//바깥에 있는 클래스에 내부멤버변수를 전달.
		public BuilderVO build() {
			return new BuilderVO(this); //나자신을 전달
		}
	}
	
	
	
	
	
	
}
