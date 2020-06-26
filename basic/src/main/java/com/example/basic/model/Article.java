package com.example.basic.model;

import java.util.List;

import javax.persistence.Column;
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
	private long id;
	private String title;
	private String content;
	private String owner;
	private int hit;
	private String creDate; // cre_date
	
	@Column(name="s_file_name", length =1000)
	private String oFileName;
	private String sFileName ;
	
	
}
