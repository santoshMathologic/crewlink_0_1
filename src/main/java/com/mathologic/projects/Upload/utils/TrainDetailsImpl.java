package com.mathologic.projects.Upload.utils;

import org.springframework.stereotype.Service;

@Service("TrainDetails")
public class TrainDetailsImpl implements CommonCsvToDataBase {

	public TrainDetailsImpl() {
		super();

	}



	@Override
	public String processingRecords(String[] columns) {
		
		System.out.println(""+columns[0]);
		System.out.println(""+columns[1]);
		
		
		return "File Uploading Successfully";
	}

}
