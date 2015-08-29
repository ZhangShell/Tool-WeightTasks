package shell.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {

	public static Properties load(String filename) {
		
		Properties props = new Properties();
		ClassLoader loader = PropertiesUtils.class.getClassLoader();
		
		InputStream in = loader.getResourceAsStream(filename);
		try {
			props.load(in);
		} catch (IOException e) { e.printStackTrace();
		}
		
		return props;
	}
	
}
