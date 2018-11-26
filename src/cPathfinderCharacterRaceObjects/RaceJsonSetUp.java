package cPathfinderCharacterRaceObjects;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RaceJsonSetUp {

	public static void main(String[] args) {
		Map<String, String[]> rst = RacialTrait.racialTraitsMap;
		
		try {
			final ByteArrayOutputStream out = new ByteArrayOutputStream(); 
			final ObjectMapper mapper = new ObjectMapper();
			
			mapper.writeValue(out, rst);
			
			final byte[] data = out.toByteArray();
			System.out.println(new String(data));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
