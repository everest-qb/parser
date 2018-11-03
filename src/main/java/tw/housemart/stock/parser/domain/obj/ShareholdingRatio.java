package tw.housemart.stock.parser.domain.obj;

import java.util.Date;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import lombok.Data;
import lombok.NonNull;

/**
 * 三大法人  外資及陸資投資類股持股比率表
 * @author QB
 *
 */
@Table
@Data
public class ShareholdingRatio {
	
	@NonNull
	@PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.PARTITIONED)
	private Date date;
	/**
	 * 產業別
	 */
	@NonNull
	@PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private String industry;
	/**
	 * 家數
	 */
	private int numberOfHouseholds;
	/**
	 * 總發行股數
	 */
	private long totalNumberOfSharesIssued;
	/**
	 * 外資持有股數
	 */
	private long foreignOwnedShares;
	/**
	 * 外資持股比率
	 */
	private float foreignShareholdingRatio;
}
