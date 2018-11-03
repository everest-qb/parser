package tw.housemart.stock.parser.dao.parseimpl;

import java.util.List;

import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;
import tw.housemart.stock.parser.domain.ShareholdingRatioRepository;
import tw.housemart.stock.parser.domain.obj.ShareholdingRatio;

@Log4j2
@Component
public class ShareholdingRatioParse extends BasicPase {
	
	@Autowired
	private ShareholdingRatioRepository rpo;
	
/*	public ShareholdingRatioParse() {
		this(2,20);
	}
	
	public ShareholdingRatioParse(int headerLine,int btSize) {
		super(headerLine,btSize);		
	}*/

	@Override
	void callProcess(List<CSVRecord> list) {
		list.forEach(r->{
			log.trace(r);
			ShareholdingRatio obj=new ShareholdingRatio(date,r.get(0));
			obj.setNumberOfHouseholds(Integer.parseInt(r.get(1).replaceAll(",", "")));
			obj.setTotalNumberOfSharesIssued(Long.parseLong(r.get(2).replaceAll(",", "")));
			obj.setForeignOwnedShares(Long.parseLong(r.get(3).replaceAll(",", "")));
			obj.setForeignShareholdingRatio(Float.parseFloat(r.get(4)));
			log.trace(obj);
		});
		list.clear();		
	}

}
