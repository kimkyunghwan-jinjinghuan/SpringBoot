package com.example.basic.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.basic.model.Animal;
import com.example.basic.model.Article;
import com.example.basic.model.Tree;
import com.example.basic.model.User;
import com.example.basic.repository.AnimalRepository;
import com.example.basic.repository.ArticleRepository;
import com.example.basic.repository.TreeRepository;

//@RestController vs @Contrller 차이는?
@Controller
public class JpaController {
	@Autowired ArticleRepository atr;
	
	@GetMapping("/write")  //보여주는
	public String write() {
		return "write"; //write.html만들어야 
	}
	
	@PostMapping("/write") //입력받은걸 처리한다
	@ResponseBody
	public Article writePost(@ModelAttribute Article article, MultipartHttpServletRequest mRequest) {
		Article result = atr.save(article); //디비로 데이터가 
		return result;
		
		/*
		String result = "";
		List<MultipartFile> mFiles = mRequest.getFiles("file"); // getFile이 아니고 getFiles(), getFiles(String name):
																// List<MultipartFile>
		for (int i = 0; i < mFiles.size(); i++) {
			MultipartFile mFile = mFiles.get(i); // MultipartFile타입 List구조. get(int index): MultipartFile - List

			String oName = mFile.getOriginalFilename(); // original

			File file = new File("c:/dev/" + oName);
			String saveName = "";
			// 파일명 중복검사, 중복되면 파일명 바꾸어서 저장하게끔 만들기
			if ((file.exists())) { // 파일이 존재하여 중복되는 경우
				int idx = oName.lastIndexOf("."); // 점의 위치를 찾고 0번 부터 어디까지 서브스트링
				String name = oName.substring(0, idx);
				String ext = oName.substring(idx); // idx부터 끝까지
				
				//if, continue 써서
				if ((ext.equals('jpg') || ext.equals(gif) || extequals(png)) {
					saveName = name + "_" + System.currentTimeMillis() + ext;
					// css1.html -> css1_12307123.html
				} else {
					continue;
				}
				saveName = oName; // 중복안됬을때는 그대로 저장
				
				try {
					mFile.transferTo(new File("c:/dev/" + saveName));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				result += oName + "\n";

			}

		}
		return result;
		*/
		
		
		

	}
//	2. 글쓰기 기능에 파일업로드 기능 추가 
//	 - writePost 메소드 수정
//	 - Article 클래스에 oFileName, sFileName 변수 추가 (original, save)
//	 - 글쓰기내용(content)과 파일정보(title, owner, creDate, hit)를 데이터베이스 함께 저장
//   파일업로드할때 중복되는 파일이 있늕
	
	
	
	
	
	
	
	
	
	
	
	
	@Autowired TreeRepository tr;
	@Autowired AnimalRepository ar;
	@Autowired Animal animal;
	
	
	
	@GetMapping("/animal_html")
	public String animal(Model model, HttpSession session) {
		User id = (User) session.getAttribute("user");
		if(id == null) {
			return "redirect:/login";
		}
	  //오버로딩 overloading - 메소드명은 같고, 인자의 개수/종류/순서가 다른 형태. 메소드형제들
	  //System.out.println(animal); //스프링이 알아서 new를 해서 메모리상에 등록된 객체를 autowired어노테이션 활용하여 데려올 수 있다. 가르킬 수 있다. 현animal syso하기전에 new한적이 없는데도 콘솔에 찍힌다.
		List<Animal> list = ar.findAll(); //select All 조회시
		model.addAttribute("userlist", list); //키, 밸류
		return "animal";
	} //리턴타입 맞추는것까지 String animal() { return list.toString();}
	  //JDBC코드보다 스프링코드 jpa가 더 짧게
	  //model을 list에 add해야한다 model. ("key", 
	
	
	
	@GetMapping("/animal")
	@ResponseBody
	public List<Animal> animal() {
		List<Animal> list = ar.findAll(); //select All 조회시
		return list;
	} //리턴타입 맞추는것까지 String animal() { return list.toString();}
	  //JDBC코드보다 스프링코드 jpa가 더 짧게
	  
	
	
	
	
	
	@GetMapping("/tree_add")
	@ResponseBody
	public String tree_add() {
		Tree tree = new Tree();
		tree.setColor("RED");
		tree.setName("소나무");
		tr.save(tree); //select All
		return "ok";
	}
}

// @ModelAttribute Article article html폼에서 받은 데이터 PostMapping거쳐서
// MultipartHttpServletRequest mRequest 위의 것과 서로 다른 타입