/**
 * 
 */
package com.mathologic.projects.utils;

import java.io.IOException;
import java.time.LocalDateTime;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * @author SANTOSH
 *
 */
public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime>{

	/**
	 * 
	 */
	public LocalDateTimeSerializer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void serialize(LocalDateTime arg0, JsonGenerator arg1, SerializerProvider arg2)
			throws IOException, JsonProcessingException {
		arg1.writeString(arg0.toString());
		
		
	}

}
