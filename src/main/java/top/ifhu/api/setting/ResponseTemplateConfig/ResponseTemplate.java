package top.ifhu.api.setting.ResponseTemplateConfig;

import lombok.Data;

@Data
public class ResponseTemplate<T> {
    private Integer code;
    private String message;
    private T data;
    private long timestamp;

    public static <T> ResponseTemplate<T> success(T data) {
        ResponseTemplate<T> result = new ResponseTemplate<>();
        result.setCode(ReturnCode.RC100.getCode());
        result.setMessage(ReturnCode.RC100.getMessage());
        result.setData(data);
        result.setTimestamp(System.currentTimeMillis());
        return result;
    }
    public static <T> ResponseTemplate<T> fail(CommonCode failCode) {
        ResponseTemplate<T> result = new ResponseTemplate<>();
        result.setCode(failCode.getCode());
        result.setMessage(failCode.getMessage());
        result.setTimestamp(System.currentTimeMillis());
        return result;
    }
    public static <T> ResponseTemplate<T> fail(CommonCode failCode,String newMessage) {
        ResponseTemplate<T> result = new ResponseTemplate<>();
        result.setCode(failCode.getCode());
        result.setMessage(newMessage);
        result.setTimestamp(System.currentTimeMillis());
        return result;
    }
}
