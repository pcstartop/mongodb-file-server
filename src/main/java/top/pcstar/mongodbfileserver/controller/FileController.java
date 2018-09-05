package top.pcstar.mongodbfileserver.controller;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import top.pcstar.mongodbfileserver.entity.File;
import top.pcstar.mongodbfileserver.service.FileService;
import top.pcstar.mongodbfileserver.util.MD5Util;
import top.pcstar.mongodbfileserver.vo.ResultModel;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

/**
 * @Author: PanChao
 * @Description: 文件Controller类
 * @Date: Created in 9:28 2018/9/4
 */
@Controller
public class FileController {
    @Autowired
    private FileService fileService;

    @RequestMapping("/view/{id}")
    public ResponseEntity<Object> viewFile(@PathVariable String id) {
        Optional<File> optionalFile = fileService.getFileById(id);
        if (!optionalFile.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header(HttpHeaders.CONTENT_TYPE, "text/html;charset=UTF-8")
                    .body("文件不存在!");
        }
        File file = optionalFile.get();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "fileName=\"" + file.getName() + "\"")
                .header(HttpHeaders.CONTENT_TYPE, file.getContentType())
                .header(HttpHeaders.CONTENT_LENGTH, String.valueOf(file.getSize()))
                .header(HttpHeaders.CONNECTION, "close")
                .body(file.getContent().getData());
    }

    @RequestMapping("/download/{id}")
    public ResponseEntity<Object> downloadFile(@PathVariable String id) {
        Optional<File> optionalFile = fileService.getFileById(id);
        if (!optionalFile.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header(HttpHeaders.CONTENT_TYPE, "text/html;charset=UTF-8")
                    .body("文件不存在!");
        }
        File file = optionalFile.get();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; fileName=\"" + file.getName() + "\"")
                .header(HttpHeaders.CONTENT_TYPE, file.getContentType())
                .header(HttpHeaders.CONTENT_LENGTH, String.valueOf(file.getSize()))
                .header(HttpHeaders.CONNECTION, "close")
                .body(file.getContent().getData());
    }

    @PostMapping("/upload")
    public ModelAndView uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        try {
            File saveFile = new File(file.getOriginalFilename(), file.getContentType(), file.getSize(), new Binary(file.getBytes()));
            saveFile.setMd5(MD5Util.getMD5(file.getInputStream()));
            fileService.saveFile(saveFile);
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "上传文件(" + file.getOriginalFilename() + ")有误!");
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("redirect:/");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResultModel> uploadFile(@PathVariable String id) {
        try {
            fileService.deleteFile(id);
            return ResponseEntity.ok().body(ResultModel.ok());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResultModel.error("系统错误!"));
        }
    }
}
