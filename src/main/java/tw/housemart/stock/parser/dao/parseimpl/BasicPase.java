package tw.housemart.stock.parser.dao.parseimpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;

@Log4j2
public abstract class BasicPase {

	private int batchSize=20;
	private int columnLine=0;
	List<CSVRecord> bufferList=new ArrayList<>();
	
	public BasicPase(int headerLine,int btSize) {
		columnLine=headerLine;
		batchSize=btSize;
	}
	
	public void parse(Path p,Charset charset) throws IOException {
		@Cleanup
		BufferedReader in
		   = new BufferedReader(new InputStreamReader(Files.newInputStream(p),charset));
		Iterable<CSVRecord> records =CSVFormat.DEFAULT.parse(in);		
		for (CSVRecord r : records) {		
			if(r.getRecordNumber()>columnLine)
				call(r);
		}
		finallCall();
	}
		
	private void call(CSVRecord r) {		
		bufferList.add(r);		
		if(bufferList.size()>=batchSize){
			log.trace("Size:{}",bufferList.size());
			callProcess(bufferList);			
		}		
	}

	private void finallCall() {
		if(bufferList.size()>0) {
			log.trace("Size:{}",bufferList.size());
			callProcess(bufferList);			
		}		
	}
	
	abstract void callProcess(List<CSVRecord> list);
}
