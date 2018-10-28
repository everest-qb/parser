package tw.housemart.stock.parser.dao.parseimpl;

import java.util.List;

import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class ShareholdingRatioParse extends BasicPase {
	
	public ShareholdingRatioParse() {
		this(2,20);
	}
	
	public ShareholdingRatioParse(int headerLine,int btSize) {
		super(headerLine,btSize);		
	}

	@Override
	void callProcess(List<CSVRecord> list) {
		list.forEach(System.out::println);
		list.clear();		
	}

}
