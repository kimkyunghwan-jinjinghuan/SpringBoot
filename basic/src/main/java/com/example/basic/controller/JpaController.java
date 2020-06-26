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


@Controller
public class JpaController {
	@Autowired
	ArticleRepository atr;

	@GetMapping("/write") // 보여주는
	public String write() {
		return "write"; // write.html만들어야
	}

	@PostMapping("/write") // 입력받은걸 처리한다
	@ResponseBody
	public Article writePost(@ModelAttribute Article article, MultipartHttpServletRequest mRequest) {

		System.out.println(article);
		System.out.println(mRequest); // 파일업로드요청했고, 잘들어왔는지 데이터확인검사

		MultipartFile mfile = mRequest.getFile("file");
		String oFileName = mfile.getOriginalFilename();
		File file = new File("c:/dev/" + oFileName);
		String sFileName = ""; // 지역변수선언 해주고 할당은 안에서 , 초기화는 해주고
		// sFileName = oFileName; 중복필터링해주고

		int index = oFileName.lastIndexOf(".");
		String name = oFileName.substring(0, index);
		String ext = oFileName.substring(index);

		
		//중복검사를 하기 전에 
		if (file.exists()) {
			sFileName = name + "_" + System.currentTimeMillis() + ext;
		} else {
			sFileName = oFileName;
		}
		try {
			mfile.transferTo(new File("c:/dev/" + sFileName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		article.setOFileName(oFileName);
		article.setSFileName(sFileName);

		Article result = atr.save(article); // 디비로 데이터가
		return result;

	}
//	2. 글쓰기 기능에 파일업로드 기능 추가 
//	 - writePost 메소드 수정
//	 - Article 클래스에 oFileName, sFileName 변수 추가 (original, save)
//	 - 글쓰기내용(content)과 파일정보(title, owner, creDate, hit)를 데이터베이스 함께 저장
//   파일업로드할때 중복되는 파일이 있늕

	@Autowired
	TreeRepository tr;
	@Autowired
	AnimalRepository ar;
	@Autowired
	Animal animal;

	@GetMapping("/animal_html")
	public String animal(Model model, HttpSession session) {
		User id = (User) session.getAttribute("user");
		if (id == null) {
			return "redirect:/login";
		}
		// System.out.println(animal); //스프링이 알아서 new를 해서 메모리상에 등록된 객체를 autowired어노테이션
		// 활용하여 데려올 수 있다. 가르킬 수 있다. 현animal syso하기전에 new한적이 없는데도 콘솔에 찍힌다.
		List<Animal> list = ar.findAll(); // select All 조회시
		model.addAttribute("userlist", list); // 키, 밸류
		return "animal";
	}
	// 리턴타입 맞추는것까지 String animal() { return list.toString();}
	// JDBC코드보다 스프링코드 jpa가 더 짧게
	// model을 list에 add해야한다 model. ("key",

	@GetMapping("/animal")
	@ResponseBody
	public List<Animal> animal() {
		List<Animal> list = ar.findAll(); // select All 조회시
		return list;
	} // 리턴타입 맞추는것까지 String animal() { return list.toString();}
		// JDBC코드보다 스프링코드 jpa가 더 짧게

	@GetMapping("/tree_add")
	@ResponseBody
	public String tree_add() {
		Tree tree = new Tree();
		tree.setColor("RED");
		tree.setName("소나무");
		tr.save(tree); // select All
		return "ok";
	}
}




































//메모
// @ModelAttribute Article article html폼에서 받은 데이터 PostMapping거쳐서
// MultipartHttpServletRequest mRequest 위의 것과 서로 다른 타입