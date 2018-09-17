package top.pcstar.mongodbfileserver.service;

import top.pcstar.mongodbfileserver.entity.FileEntity;

import java.util.List;
import java.util.Optional;

/**
 * @Author: PanChao
 * @Description: 文件Service接口
 * @Date: Created in 11:38 2018/9/4
 */
public interface FileService {
    /**
     * 根据id查询文件
     * @param id
     * @return
     */
    Optional<FileEntity> getFileById(String id);

    /**
     * 分页查询文件信息
     * @param pageIndex
     * @param pageSize
     * @return
     */
    List<FileEntity> listFilesByPage(int pageIndex, int pageSize);

    /**
     * 保存文件
     * @param file
     * @return
     */
    FileEntity saveFile(FileEntity file);

    /**
     * 根据文件Id删除文件
     * @param id
     */
    void deleteFile(String id);
}
