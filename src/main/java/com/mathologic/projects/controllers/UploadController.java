package com.mathologic.projects.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;

@RestController
@RequestMapping("/api/v1/upload")
public class UploadController {

	public UploadController() {
		
	}

	@RequestMapping(value = "/getInfo", method = RequestMethod.GET)
	public String getUploadInfo() {
		return "Upload files";
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody String handleFileUpload(@RequestParam("file") MultipartFile fileTrainDetails,
			HttpServletRequest request) {

		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		String fullpath = s + "/uploads";

		try {
			File file = new File(fullpath);
			file.mkdirs();
			fullpath += "/" + fileTrainDetails.getOriginalFilename();
			file = new File(fullpath);
			byte[] bytes = fileTrainDetails.getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
			stream.write(bytes);
			stream.close();
			
			CSVReader reader = new CSVReader(new FileReader(fullpath),',','\'',1);
		     for (String[] line; (line = reader.readNext()) != null;) {
		     	
		    	   System.out.println(""+line[0]);
		    	   System.out.println(""+line[1]);
		     }



		} catch (Exception e) {
			System.out.println("" + e);
		}

		return "Upload files";
	}
	 	

}
