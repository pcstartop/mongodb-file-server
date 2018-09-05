package top.pcstar.mongodbfileserver.util;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Author: PanChao
 * @Description: MD5工具类
 * @Date: Created in 16:46 2018/9/4
 */
public class MD5Util {
    /**
     * @param is
     * @return 获取输入流的MD5值
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public static String getMD5(InputStream is) throws NoSuchAlgorithmException, IOException {
        StringBuffer md5 = new StringBuffer();
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] dataBytes = new byte[1024];

        int nread = 0;
        while ((nread = is.read(dataBytes)) != -1) {
            md.update(dataBytes, 0, nread);
        }
        ;
        byte[] mdbytes = md.digest();

        // convert the byte to hex format
        for (int i = 0; i < mdbytes.length; i++) {
            md5.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return md5.toString();
    }
}
