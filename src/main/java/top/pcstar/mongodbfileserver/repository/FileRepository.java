package top.pcstar.mongodbfileserver.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import top.pcstar.mongodbfileserver.entity.File;

/**
 * @Author: PanChao
 * @Description: 文件Repository接口
 * @Date: Created in 11:35 2018/9/4
 */
public interface FileRepository extends MongoRepository<File, String> {
}
