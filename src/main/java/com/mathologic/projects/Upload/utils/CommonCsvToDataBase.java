package com.mathologic.projects.Upload.utils;

import org.springframework.stereotype.Service;

@Service
public interface CommonCsvToDataBase {
	
	public String processingRecords(String[] columns);

}
