package tw.housemart.stock.parser.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileDaoTest {
	
	@Autowired
	private FileDao dao;
	
	@Test
	public void testCharset() throws IOException {
		Path p=Paths.get("J:\\eclipse\\workspace\\oxygen_01\\download\\data\\每日\\盤後資訊  個股日本益比、殖利率及股價淨值比（依日期查詢）\\");
		
		final Check check=new Check();
		
		Files.list(p).forEach(d->{			
			try {
				Files.list(d).forEach(f->{
					if(Files.exists(f)) {
						try {
							String c=dao.charset(f);
							if(c.equals("Big5")) {
								check.setBig5(true);
							}else if(c.equals("UTF-8")){
								check.setUtf8(true);
							}
						} catch (IOException e) {						
							e.printStackTrace();
						}
					}
				});
			} catch (IOException e) {				
				e.printStackTrace();
			}
		});
		
		assertTrue(check.check());
	}

	private class Check{
		
		private boolean big5=false;
		private boolean utf8=false;
		
		public boolean check() {
			return big5 & utf8;
		}

		public void setBig5(boolean big5) {
			this.big5 = big5;
		}

		public void setUtf8(boolean utf8) {
			this.utf8 = utf8;
		}
	}
}
