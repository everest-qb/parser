package tw.housemart.stock.parser.dao;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.tika.parser.txt.CharsetDetector;
import org.springframework.stereotype.Component;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class FileDao {

	
	public String charset(Path p) throws IOException {		
		String charset=null;
		if(Files.exists(p)) {
			CharsetDetector d=new CharsetDetector();
			@Cleanup
			InputStream in=new BufferedInputStream(Files.newInputStream(p));
			charset = d.setText(in).detect().getName();
			log.trace("Encide:{}",charset);
		}
		return charset;
	}
}
