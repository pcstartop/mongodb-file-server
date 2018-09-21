package top.pcstar.mongodbfileserver.exception;

import java.io.Serializable;

/**
 * @Author: PanChao
 * @Description: 应用服务异常类
 * @Date: Created in 14:14 2018/9/17
 */
public class ApplicationException extends Exception implements Serializable {
    private static final long serialVersionUID = 4835291969698212259L;
    /**
     * 异常代码
     */
    private int code;
    /**
     * 异常信息
     */
    private String msg;

    public ApplicationException(int code, String msg) {
        super("code:" + code + "---msg:" + msg);
        this.code = code;
        this.msg = msg;
    }

    /**
     * 获取异常代码
     * @return
     */
    public int getCode() {
        return code;
    }

    /**
     * 获取异常信息
     * @return
     */
    public String getMsg() {
        return msg;
    }
}
