package com.example.basic.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;
import lombok.Data;

@Data
@Entity
public class Article {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String title;
	String content;
	String owner;
	int hit;
	String creDate; // cre_date
	String oFileName;
	String sFileName ;
	
	
}
