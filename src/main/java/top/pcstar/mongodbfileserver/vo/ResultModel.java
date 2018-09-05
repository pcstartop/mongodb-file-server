package top.pcstar.mongodbfileserver.vo;

import top.pcstar.mongodbfileserver.enums.ResultStatusEnum;

/**
 * @Author: PanChao
 * @Description: 自定义返回结果
 * @Date: Created in 18:43 2018/9/4
 */
public class ResultModel<T> {
    /**
     * 返回码
     */
    private int code;
    /**
     * 返回结果描述
     */
    private String message;
    /**
     * 返回内容
     */
    private T data;

    public ResultModel() {
    }

    public ResultModel(ResultStatusEnum resultStatus) {
        this(resultStatus, null);
    }

    public ResultModel(ResultStatusEnum resultStatus, T data) {
        this.code = resultStatus.getCode();
        this.message = resultStatus.getMessage();
        this.data = data;
    }

    public void setResultStatus(ResultStatusEnum resultStatus) {
        this.code = resultStatus.getCode();
        this.message = resultStatus.getMessage();
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public static <T> ResultModel<T> ok() {
        return new ResultModel<>(ResultStatusEnum.SUCCESS);
    }

    public static <T> ResultModel<T> ok(T data) {
        return new ResultModel<>(ResultStatusEnum.SUCCESS, data);
    }

    public static <T> ResultModel<T> error() {
        return new ResultModel<>(ResultStatusEnum.SUCCESS);
    }

    public static <T> ResultModel<T> error(T data) {
        return new ResultModel<>(ResultStatusEnum.SUCCESS, data);
    }

    @Override
    public String toString() {
        return "ResultModel{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
