package com.example.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.basic.Test;

import lombok.Data;

@Data
class Test{
	int age;
	char c;
}

@SpringBootApplication
public class BasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicApplication.class, args);
		Test t = new Test();
		t.setAge(11);
		
		new Test().setC('c');
	}

}
