package top.ifhu.api.controller.auth.verifyCode;

import lombok.Data;
@Data
public class VerifyCode {
    private String code;
    private byte[] imgBytes;
    private long expireTime;
}