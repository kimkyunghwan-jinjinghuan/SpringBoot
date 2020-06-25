package com.example.basic.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class UploadController {
	@GetMapping("/upload1")
	public String upload1() {
		return "upload1";
	}

	@PostMapping("/upload1")
	@ResponseBody
	// �߰��Ǿ�� �ϴ� ��� 1.������ġ�� ������ ����(���ϸ��ߺ��˻��ؾ�) 2.������ ������ DB�� ����
	public String upload1Post(MultipartHttpServletRequest mRequest) {
		String result = "";
		List<MultipartFile> mFiles = mRequest.getFiles("file"); // getFile�� �ƴϰ� getFiles(), getFiles(String name):
																// List<MultipartFile>
		for (int i = 0; i < mFiles.size(); i++) {
			MultipartFile mFile = mFiles.get(i); // MultipartFileŸ�� List����. get(int index): MultipartFile - List

			String oName = mFile.getOriginalFilename(); // original
			int idx = oName.lastIndexOf("."); // ���� ��ġ�� ã�� 0�� ���� ������ ���꽺Ʈ��
			String name = oName.substring(0, idx);
			String ext = oName.substring(idx); // idx���� ������

			File file = new File("c:/dev/" + oName);
			String saveName = "";
			// ���ϸ� �ߺ��˻�, �ߺ��Ǹ� ���ϸ� �ٲپ �����ϰԲ� �����
			if (ext.equals(".jpg") || 
				ext.equals(".png") || 
				ext.equals(".gif")) { // jpg png gif ������ ���� ����

				if ((file.exists())) { // ������ �����Ͽ� �ߺ��Ǵ� ���

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
		}
		return result;
	}
}




/*
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
		System.out.println(mRequest); //� �����Ͱ� ���Դ��� �ܼ�â�� ����
		List<MultipartFile> mFiles = mRequest.getFiles("file"); //File�� �ƴ϶� Files. MultipartFileŸ��
		for (MultipartFile mfile : mFiles) { //Enhanced for ��
			System.out.println(mfile); //������Ȯ��
			String oName = mfile.getOriginalFilename(); //MultipartFileŬ������ getOriginalFilename()�޼ҵ� 
			File file = new File("c:/dev/" + oName);

			String saveName = ""; //�ߺ��˻��Ŀ� ���� ����� ���ϸ� 
	
			int index = oName.lastIndexOf(".");
			String name = oName.substring(0, index);
			String ext = oName.substring(index);
			if(	ext.toLowerCase().equals("jpg")||
				ext.toLowerCase().equals("gif")||
				ext.toLowerCase().equals("png")) { //(".jpg")�� .�� �پ�� �ϴ°� �ƴѰ�?

				
				if( file.exists() ) {
					saveName = name + "_" + System.currentTimeMillis() + ext;
				} else {
					saveName = oName;
				} 
				
				try {
					mfile.transferTo(new File("c:/dev/" + saveName )); //FileŬ������ transferTo()�޼ҵ尡 ������ ����
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
				result += "�̹������ϸ� ���ε����ּ���.";
			}
		}
		return result;
	}
}
 
 */
