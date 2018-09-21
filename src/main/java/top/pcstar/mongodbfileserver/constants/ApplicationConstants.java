package top.pcstar.mongodbfileserver.constants;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationConstants {
    private static final String APPLICATION_FILE_PATH = "config/application.properties";
    /**
     * 静态资源存放路径
     */
    public static final String STATIC_LOCATIONS;
    /**
     * 静态资源访问路径
     */
    public static final String STATIC_PATH_PATTERN;
    /**
     * 临时上传文件路径
     */
    public static final String TEMP_UPLOAD_FILE_PATH;

    static {
        Properties properties = new Properties();
        try (InputStream resourceAsStream = ApplicationConstants.class.getClassLoader().getResourceAsStream(APPLICATION_FILE_PATH);) {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        STATIC_LOCATIONS = properties.getProperty("mongodb-file-server.resources.static-locations", "");
        STATIC_PATH_PATTERN = properties.getProperty("mongodb-file-server.mvc.static-path-pattern", "");
        TEMP_UPLOAD_FILE_PATH = properties.getProperty("mongodb-file-server-upload-file-path", "");
    }

    private ApplicationConstants() {
    }
}
