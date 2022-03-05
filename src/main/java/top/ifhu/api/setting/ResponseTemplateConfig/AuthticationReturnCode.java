package top.ifhu.api.setting.ResponseTemplateConfig;

public enum AuthticationReturnCode implements  CommonCode {
    RC100(100,"操作成功");
    /**自定义状态码**/
    private final int code;
    /**自定义描述**/
    private final String message;

    AuthticationReturnCode(int code, String message){
        this.code = code;
        this.message = message;
    }
    @Override
    public int getCode() {
        return 0;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
