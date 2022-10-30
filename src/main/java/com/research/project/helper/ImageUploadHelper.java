package com.research.project.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Component
public class ImageUploadHelper{
	
//	public final String uploadDir = "E:\\java\\spring-tool-suite\\image-upload\\src\\main\\resources\\static\\images";
	public final String uploadDir = new ClassPathResource("static/images").getFile().getAbsolutePath();
//	public String uploadDir;// = new ClassPathResource("static/images").getFile().getAbsolutePath();
	
	
	public ImageUploadHelper() throws IOException
	{
		
	}
	
	
	
	public <T> Object uploadFile(MultipartFile file)
	{
		try {
			InputStream is = file.getInputStream();
			byte data[] = new byte[is.available()];
			is.read(data);
			
			String fileExtention = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			
			String fileName = System.currentTimeMillis()+fileExtention;
			System.out.println(fileName);
			
			FileOutputStream fos = new FileOutputStream(uploadDir+File.separator+fileName);
			fos.write(data);
			
			fos.flush();
			fos.close();
			return ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(fileName).toUriString();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return "error";
		}
		
//		return "error";
	}
	
	public boolean deleteFile(String imageUrl) throws IOException
	{
		
		String ss[] = imageUrl.split("/");
		String fileName = ss[ss.length-1];
		
		File file = new ClassPathResource("static/images/"+fileName).getFile();
//		System.out.println("Directory path file exists : "+file.exists());
		if(file.delete()) {
			return true;
		}
		return false;
	}
	
	

}
