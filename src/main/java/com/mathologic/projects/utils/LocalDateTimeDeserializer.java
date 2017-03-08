/**
 * 
 */
package com.mathologic.projects.utils;

import java.io.IOException;
import java.time.LocalDateTime;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * @author SANTOSH
 *
 */
public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime>  {

	public LocalDateTimeDeserializer() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public LocalDateTime deserialize(JsonParser arg0, DeserializationContext arg1)
			throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		return LocalDateTime.parse(arg0.getText());
	}

}
