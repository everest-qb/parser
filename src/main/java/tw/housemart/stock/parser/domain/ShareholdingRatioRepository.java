package tw.housemart.stock.parser.domain;

import org.springframework.data.cassandra.repository.CassandraRepository;

import tw.housemart.stock.parser.domain.obj.ShareholdingRatio;

public interface ShareholdingRatioRepository extends CassandraRepository<ShareholdingRatio> {

}
