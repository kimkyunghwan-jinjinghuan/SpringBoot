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

//@RestController vs @Contrller ���̴�?
@Controller
public class JpaController {
	@Autowired ArticleRepository atr;
	
	@GetMapping("/write")  //�����ִ�
	public String write() {
		return "write"; //write.html������ 
	}
	
	@PostMapping("/write") //�Է¹����� ó���Ѵ�
	@ResponseBody
	public Article writePost(@ModelAttribute Article article, MultipartHttpServletRequest mRequest) {
		Article result = atr.save(article); //���� �����Ͱ� 
		return result;
		
		/*
		String result = "";
		List<MultipartFile> mFiles = mRequest.getFiles("file"); // getFile�� �ƴϰ� getFiles(), getFiles(String name):
																// List<MultipartFile>
		for (int i = 0; i < mFiles.size(); i++) {
			MultipartFile mFile = mFiles.get(i); // MultipartFileŸ�� List����. get(int index): MultipartFile - List

			String oName = mFile.getOriginalFilename(); // original

			File file = new File("c:/dev/" + oName);
			String saveName = "";
			// ���ϸ� �ߺ��˻�, �ߺ��Ǹ� ���ϸ� �ٲپ �����ϰԲ� �����
			if ((file.exists())) { // ������ �����Ͽ� �ߺ��Ǵ� ���
				int idx = oName.lastIndexOf("."); // ���� ��ġ�� ã�� 0�� ���� ������ ���꽺Ʈ��
				String name = oName.substring(0, idx);
				String ext = oName.substring(idx); // idx���� ������
				
				//if, continue �Ἥ
				if ((ext.equals('jpg') || ext.equals(gif) || extequals(png)) {
					saveName = name + "_" + System.currentTimeMillis() + ext;
					// css1.html -> css1_12307123.html
				} else {
					continue;
				}
				saveName = oName; // �ߺ��ȉ������� �״�� ����
				
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
//	2. �۾��� ��ɿ� ���Ͼ��ε� ��� �߰� 
//	 - writePost �޼ҵ� ����
//	 - Article Ŭ������ oFileName, sFileName ���� �߰� (original, save)
//	 - �۾��⳻��(content)�� ��������(title, owner, creDate, hit)�� �����ͺ��̽� �Բ� ����
//   ���Ͼ��ε��Ҷ� �ߺ��Ǵ� ������ �ֈd
	
	
	
	
	
	
	
	
	
	
	
	
	@Autowired TreeRepository tr;
	@Autowired AnimalRepository ar;
	@Autowired Animal animal;
	
	
	
	@GetMapping("/animal_html")
	public String animal(Model model, HttpSession session) {
		User id = (User) session.getAttribute("user");
		if(id == null) {
			return "redirect:/login";
		}
	  //�����ε� overloading - �޼ҵ���� ����, ������ ����/����/������ �ٸ� ����. �޼ҵ�������
	  //System.out.println(animal); //�������� �˾Ƽ� new�� �ؼ� �޸𸮻� ��ϵ� ��ü�� autowired������̼� Ȱ���Ͽ� ������ �� �ִ�. ����ų �� �ִ�. ��animal syso�ϱ����� new������ ���µ��� �ֿܼ� ������.
		List<Animal> list = ar.findAll(); //select All ��ȸ��
		model.addAttribute("userlist", list); //Ű, ���
		return "animal";
	} //����Ÿ�� ���ߴ°ͱ��� String animal() { return list.toString();}
	  //JDBC�ڵ庸�� �������ڵ� jpa�� �� ª��
	  //model�� list�� add�ؾ��Ѵ� model. ("key", 
	
	
	
	@GetMapping("/animal")
	@ResponseBody
	public List<Animal> animal() {
		List<Animal> list = ar.findAll(); //select All ��ȸ��
		return list;
	} //����Ÿ�� ���ߴ°ͱ��� String animal() { return list.toString();}
	  //JDBC�ڵ庸�� �������ڵ� jpa�� �� ª��
	  
	
	
	
	
	
	@GetMapping("/tree_add")
	@ResponseBody
	public String tree_add() {
		Tree tree = new Tree();
		tree.setColor("RED");
		tree.setName("�ҳ���");
		tr.save(tree); //select All
		return "ok";
	}
}

// @ModelAttribute Article article html������ ���� ������ PostMapping���ļ�
// MultipartHttpServletRequest mRequest ���� �Ͱ� ���� �ٸ� Ÿ��