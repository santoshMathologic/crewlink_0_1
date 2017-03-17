package com.mathologic.projects.Upload.utils;

import org.springframework.stereotype.Service;

@Service("TrainTimeTableDetails")
public class TrainTimeTableDetailsImpl implements CommonCsvToDataBase {

	public TrainTimeTableDetailsImpl() {
		super();

	}



	@Override
	public String processingRecords(String[] columns) {
		
		System.out.println(""+columns[0]);
		System.out.println(""+columns[1]);
		
		
		return "File Uploading Successfully";
	}

}
