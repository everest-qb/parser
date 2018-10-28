package tw.housemart.stock.parser.dao.parseimpl;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tw.housemart.stock.parser.dao.FileDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShareholdingRatioParseTest {

	@Autowired
	private ShareholdingRatioParse  dao;
	
	@Autowired
	private FileDao file;
	
	@Test
	public void testParse() throws IOException {
		Path p=Paths.get("J:\\eclipse\\workspace\\oxygen_01\\download\\data\\每日\\三大法人  外資及陸資投資類股持股比率表\\20180301\\f0.csv");
		Charset charset=Charset.forName(file.charset(p));
		dao.parse(p, charset);
	}

}
