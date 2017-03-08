package com.mathologic.projects.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectViewModel {
	
	private SelectionDetails selectionDetails;
	private List<?> data;
	private Class<?> clazz;
	private Map<String,Integer> fields;
	
	private void fillFields(){
		fields = new HashMap<String,Integer>();
		for(int i=0; i<clazz.getDeclaredFields().length; i++){
			fields.put(clazz.getDeclaredFields()[i].getName(), i);
		}
	}

	public SelectViewModel(Class<?> clazz, SelectionDetails selectionDetails,
			List<?> data) {
		super();
		this.clazz = clazz;
		this.data = data;
		this.selectionDetails = selectionDetails;
		fillFields();
	}

	public SelectionDetails getSelectionDetails() {
		return selectionDetails;
	}

	public void setSelectionDetails(SelectionDetails selectionDetails) {
		this.selectionDetails = selectionDetails;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

}
