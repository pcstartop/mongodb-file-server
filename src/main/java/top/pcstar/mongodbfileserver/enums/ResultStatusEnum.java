package top.pcstar.mongodbfileserver.enums;

/**
 * @Author: PanChao
 * @Description: 自定义返回结果状态
 * @Date: Created in 18:46 2018/9/4
 */
public enum ResultStatusEnum {
    SUCCESS(100, "成功"),
    ERROR(990099, "系统异常")
    ;

    /**
     * 返回码
     */
    private int code;
    /**
     * 返回结果描述
     */
    private String message;

    ResultStatusEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 根据code获取ResultStatusEnum
     *
     * @param code
     * @return
     */
    public ResultStatusEnum getResultStatusByCode(int code) {
        for (ResultStatusEnum resultStatus : ResultStatusEnum.values()) {
            if (code == resultStatus.getCode()) {
                return resultStatus;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
