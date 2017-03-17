package com.mathologic.projects.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mathologic.projects.Upload.utils.CommonCsvToDataBase;


import com.opencsv.CSVReader;

@RestController
@RequestMapping("/api/v1/upload")
public class UploadController {

	public UploadController() {
		
	}
	
	 @Autowired
	 @Qualifier("TrainDetails")
	 CommonCsvToDataBase trainDetailsCsvToDatabase;

	@RequestMapping(value = "/getInfo", method = RequestMethod.GET)
	public String getUploadInfo() {
		return "Upload files";
	}

	@RequestMapping(value = "/trainDetails", method = RequestMethod.POST)
	public @ResponseBody String trainDetails(@RequestParam("file") MultipartFile fileTrainDetails,
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
		     	trainDetailsCsvToDatabase.processingRecords(line);
		    	   
		     }



		} catch (Exception e) {
			System.out.println("" + e);
		}

		return "Upload files";
	}
	
	
	@RequestMapping(value = "/trainTimeTable", method = RequestMethod.POST)
	public @ResponseBody String trainTimeTable(@RequestParam("file") MultipartFile fileTrainDetails,
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
		     	trainDetailsCsvToDatabase.processingRecords(line);
		    	   
		     }



		} catch (Exception e) {
			System.out.println("" + e);
		}

		return "Upload files";
	}
	 	

}
