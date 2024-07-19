package com.RestCrud.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileHelper {
	
	//custom directory path
	public final String UPLOAD_DIR="D:\\SpringBoot\\SpringBoot-RestCRUD\\src\\main\\resources\\static\\image";
	
	public boolean uploadFile(MultipartFile multipartFile)
	{
		boolean f=false;
		
		try {
			// read file data 
//		InputStream is=multipartFile.getInputStream();
//		byte data[]=new byte[is.available()];
//		is.read(data);
//		
//		// write file data to the directory
//		FileOutputStream fos= new FileOutputStream(UPLOAD_DIR+"\\"+File.separator+multipartFile.getOriginalFilename());
//			fos.write(data);
//			fos.flush();
//			fos.close();
//			f=true;
			
			Files.copy(multipartFile.getInputStream(),Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()) ,StandardCopyOption.REPLACE_EXISTING );
			f=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
}
