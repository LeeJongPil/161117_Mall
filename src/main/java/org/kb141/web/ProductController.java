package org.kb141.web;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.UUID;

import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.kb141.domain.ProductVO;
import org.kb141.persistence.ProductDAO;
import org.kb141.web.HomeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProductController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Inject
	private ProductDAO dao;

	@GetMapping("/register")
	public void register() throws Exception {

	}

	// ���� ���ε�
	@PostMapping("/registerAction")
	public String buffer(ProductVO vo, Model model) throws Exception {

		logger.info(vo.toString());
		dao.create(vo);
		return "redirect:list";
		
	}

	// ��� �Ѹ���
	@GetMapping("/list")
	public void list(Model model) throws Exception {

		model.addAttribute("list", dao.getList());

	}

	// ���ϸ� �ѱ�� ���� �����ֱ�
	@GetMapping(value="/showselect", produces={"image/jpg","image/gif","image/png", "image/jpeg"})
	public @ResponseBody byte[] download(String name) throws Exception {
		InputStream in = new FileInputStream("E:\\zzz\\" + name);
		
		return IOUtils.toByteArray(in);
	}
	
	
	// DND ���� ���ε� �޼ҵ�
	@PostMapping("/uploadFile")
	@ResponseBody
	public String uploadFile(MultipartFile file) throws Exception{
		
		logger.info(file.getOriginalFilename());
		UUID uid = UUID.randomUUID();
		
		String fileName = file.getOriginalFilename();	// �����̸�
		
		String uploadName = uid+"_"+fileName;
		
		FileOutputStream fos = new FileOutputStream("E:\\zzz\\"+uploadName);
		
		IOUtils.copy(file.getInputStream(),fos);
		
		fos.close();
		
		return uploadName;
	}
	
	
	
}
