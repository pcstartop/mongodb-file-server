package top.pcstar.mongodbfileserver.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import top.pcstar.mongodbfileserver.constants.ApplicationConstants;

import javax.servlet.*;
import java.util.EnumSet;

/**
 * @Author: PanChao
 * @Description: WebApp初始化配置文件类
 * @Date: Created in 9:20 2018/9/4
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        /*配置multipart的具体细节
        临时文件路径
        上传文件最大值
        整个请求信息最大值
        文件大小阈值
         */
        registration.setMultipartConfig(new MultipartConfigElement(ApplicationConstants.TEMP_UPLOAD_FILE_PATH, 2 * 1024 * 1024, 4 * 1024 * 1024, 0));
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 系统启动时注册listener
        addListener(servletContext);
        // 系统启动时注册filter
        addFilter(servletContext);
        // 系统启动时注册servlet
        addServlet(servletContext);
        super.onStartup(servletContext);
    }

    /**
     * 注册listener
     *
     * @param servletContext
     */
    private void addListener(ServletContext servletContext) {
    }

    /**
     * 注册filter
     *
     * @param servletContext
     */
    private void addFilter(ServletContext servletContext) {
        //注册characterEncodingFilter字符编码过滤器
        FilterRegistration characterEncodingFilter = servletContext.addFilter("characterEncodingFilter", CharacterEncodingFilter.class);
        // 设置init param, param可以从properties文件中读取或其他方式获取，提供一个想法
        characterEncodingFilter.setInitParameter("encoding", "UTF-8");
        characterEncodingFilter.setInitParameter("forceEncoding", "true");
        characterEncodingFilter.addMappingForServletNames(EnumSet.allOf(DispatcherType.class), true, getServletName());
//        characterEncodingFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class) , true, "/*");
    }

    /**
     * 注册servlet
     *
     * @param servletContext
     */
    private void addServlet(ServletContext servletContext) {
    }
}
