package top.pcstar.mongodbfileserver.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @Author: PanChao
 * @Description:
 * @Date: Created in 11:11 2018/9/4
 */
@Configuration
@EnableMongoRepositories("top.pcstar.mongodbfileserver.repository") //启用MongoDB的Repository功能
public class MongoConfig extends AbstractMongoConfiguration {
    @Override
    public MongoClient mongoClient() {
        return new MongoClient();
    }

    @Override
    protected String getDatabaseName() {
        return "test";
    }
}
