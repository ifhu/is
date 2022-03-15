package top.ifhu.base.system.authorize.verifyCode;

import lombok.Data;
@Data
public class VerifyCode {
    private String code;
    private byte[] imgBytes;
    private long expireTime;
}