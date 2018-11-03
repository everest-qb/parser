package tw.housemart.stock.parser.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories("tw.housemart.stock.parser.domain")
public class Cassandra {

}
