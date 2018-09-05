package top.pcstar.mongodbfileserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import top.pcstar.mongodbfileserver.entity.File;
import top.pcstar.mongodbfileserver.service.FileService;

import java.util.List;

/**
 * @Author: PanChao
 * @Description: 首页
 * @Date: Created in 12:33 2018/9/4
 */
@Controller
public class HomePageController {
    @Autowired
    private FileService fileService;

    @GetMapping("/")
    public ModelAndView index() {
        List<File> files = fileService.listFilesByPage(0, 10);
        return new ModelAndView("index", "files", files);
    }
}
