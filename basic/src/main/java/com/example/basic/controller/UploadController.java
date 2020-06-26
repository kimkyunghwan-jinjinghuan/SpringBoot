package com.example.basic.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.basic.model.Animal;
import com.example.basic.repository.AnimalRepository;


//연습한거고
//과제는 writePost()
@Controller
public class UploadController {
	
	
	@Autowired
	AnimalRepository ar;
	@Autowired
	Animal animal;
	
	
	@GetMapping("/animal")
	@ResponseBody
	public List<Animal> animal() {
		List<Animal> list = ar.findAll(); // select All 조회시
		return list;
	} // 리턴타입 맞추는것까지 String animal() { return list.toString();}
		// JDBC코드보다 스프링코드 jpa가 더 짧게
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/upload1")
	public String upload1() {
		return "upload1";
	}

	@PostMapping("/upload1")
	@ResponseBody
	// 추가되어야 하는 기능 1.저장장치에 파일을 저장(파일명중복검사해야) 2.파일의 정보를 DB에 저장
	public String upload1Post(MultipartHttpServletRequest mRequest) {
		String result = "";
		List<MultipartFile> mFiles = mRequest.getFiles("file"); // getFile이 아니고 getFiles(), getFiles(String name):
																// List<MultipartFile>
		for (int i = 0; i < mFiles.size(); i++) {
			MultipartFile mFile = mFiles.get(i); // MultipartFile타입 List구조. get(int index): MultipartFile - List

			String oName = mFile.getOriginalFilename(); // original
			int idx = oName.lastIndexOf("."); // 점의 위치를 찾고 0번 부터 어디까지 서브스트링
			String name = oName.substring(0, idx);
			String ext = oName.substring(idx); // idx부터 끝까지 substring(이상,미만)

			File file = new File("c:/dev/" + oName);
			String saveName = "";
			// 파일명 중복검사, 중복되면 파일명 바꾸어서 저장하게끔 만들기
			if (ext.equals(".jpg") || 
				ext.equals(".png") || 
				ext.equals(".gif")) { // jpg png gif 맞으면 파일 저장
			// if(!ext.toLowerCase.equals(".jpg") && 
			//		ext.toLowerCase.equals(".gif") && 
			//		ext.toLowerCase.equals(".png"){
			//	continue
			//} 문자열비교는 equals()로. 원하는 확장파일이 아니면 또 다른 파일로 넘어간다 .대소문자 아스키코드 32차이가 남
			// ctrl + H로 검색 File Search로 검색
			// ctrl + shift + R로 파일엵
				
				if ((file.exists())) { // 파일이 존재하여 중복되는 경우

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
		}
		return result;
	}
}


















/*
 * 종훈코드
@Controller
public class UploadController {
	@GetMapping("/upload1")
	public String upload1() {
		return "upload1";
	}

	@PostMapping("/upload1")
	@ResponseBody
	public String upload1Post(MultipartHttpServletRequest mRequest) {
		String result = "";
		System.out.println(mRequest); //어떤 데이터가 들어왔는지 콘솔창에 찍어보고
		List<MultipartFile> mFiles = mRequest.getFiles("file"); //File이 아니라 Files. MultipartFile타입
		for (MultipartFile mfile : mFiles) { //Enhanced for 문
			System.out.println(mfile); //데이터확인
			String oName = mfile.getOriginalFilename(); //MultipartFile클래스의 getOriginalFilename()메소드 
			File file = new File("c:/dev/" + oName);

			String saveName = ""; //중복검사후에 실제 저장될 파일명 
	
			int index = oName.lastIndexOf(".");
			String name = oName.substring(0, index);
			String ext = oName.substring(index);
			if(	ext.toLowerCase().equals("jpg")||
				ext.toLowerCase().equals("gif")||
				ext.toLowerCase().equals("png")) { //(".jpg")로 .이 붙어야 하는거 아닌가?

				
				if( file.exists() ) {
					saveName = name + "_" + System.currentTimeMillis() + ext;
				} else {
					saveName = oName;
				} 
				
				try {
					mfile.transferTo(new File("c:/dev/" + saveName )); //File클래스의 transferTo()메소드가 실질적 저장
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				result += oName + "\n";
			}
			else {
				result += "이미지파일만 업로드해주세요.";
			}
		}
		return result;
	}
}
 
 */
