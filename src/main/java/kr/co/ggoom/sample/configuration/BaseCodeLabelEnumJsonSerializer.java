package kr.co.ggoom.sample.configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import kr.co.ggoom.sample.domain.BaseCodeLabelEnum;

public class BaseCodeLabelEnumJsonSerializer extends JsonSerializer<BaseCodeLabelEnum> {
	
	@Override
	public void serialize(BaseCodeLabelEnum value, JsonGenerator jsonGenerator, SerializerProvider provider) 
		throws IOException, JsonProcessingException {
		
		Map<String, Object> map = new HashMap<>();
		map.put("code", value.code());
		map.put("label",value.label());
		jsonGenerator.writeObject(map);
		
	}

}
