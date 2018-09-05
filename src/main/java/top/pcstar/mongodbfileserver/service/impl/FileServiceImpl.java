package top.pcstar.mongodbfileserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import top.pcstar.mongodbfileserver.entity.File;
import top.pcstar.mongodbfileserver.repository.FileRepository;
import top.pcstar.mongodbfileserver.service.FileService;

import java.util.List;
import java.util.Optional;

/**
 * @Author: PanChao
 * @Description:
 * @Date: Created in 11:40 2018/9/4
 */
@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileRepository fileRepository;

    @Override
    public Optional<File> getFileById(String id) {
        return fileRepository.findById(id);
    }

    @Override
    public List<File> listFilesByPage(int pageIndex, int pageSize) {
        Sort sort = new Sort(Sort.Direction.DESC, "uploadDate");
        Pageable pageable = PageRequest.of(pageIndex, pageSize, sort);
        Page<File> page = fileRepository.findAll(pageable);
        return page.getContent();
    }

    @Override
    public File saveFile(File file) {
        return fileRepository.save(file);
    }

    @Override
    public void deleteFile(String id) {
        fileRepository.deleteById(id);
    }
}
