package top.ifhu.api.setting.ResponseTemplateConfig;

//Return Code define rules
// if code < 0 => client respons
// if code >= 0 && code <= 1000 don't need anything
// if code > 1000 client  => tip use
public enum ReturnCode implements CommonCode {
//    code >= 0 && code <= 1000
    /**操作成功**/
    RC100(100,"操作成功"),
    /**操作失败**/

    /**服务限流**/
    RC200(200,"请求成功"),
    /**服务降级**/
    RC201(201,"服务开启降级保护,请稍后再试!"),
    /**热点参数限流**/

    /**系统规则不满足**/
    RC203(203,"系统规则不满足要求,请稍后再试!"),
    /**授权规则不通过**/
    RC204(204,"授权规则不通过,请稍后再试!"),

    /**access_denied**/
    RC403(403,"无访问权限,请联系管理员授予权限"),
    /**access_denied**/
    RC401(401,"匿名用户访问无权限资源时的异常"),


    // code < 0
    NO_TOKEN(-403,"用户未认证，请登录"),//重定向到/login
    RC404(-404,"资源不存在"),// 重定向到/404
    // code > 1000
    RC202(1202,"访问过于频繁,请稍后再试!"),
    /** not found接口不存在 **/

    /**服务异常**/
    RC500(1500,"系统异常，请稍后重试,不然就联系管理员me@ifhu.top"),
    RC999(1999,"操作失败"),
    INVALID_TOKEN(2001,"访问令牌不合法"),
    ACCESS_DENIED(2003,"权限不足"),

    UNLAWFUL_TOKEN(2005,"非法令牌,小伙子,你在玩火"),
    UNLAWFUL_PARAMETER(2006,"参数不合法，校验未通过"),
    CLIENT_AUTHENTICATION_FAILED(1001,"客户端认证失败"),
    USERNAME_OR_PASSWORD_ERROR(1002,"用户名或密码错误"),
    UNSUPPORTED_GRANT_TYPE(1003, "不支持的认证模式"),
    UNDEINED_INTERFACE(1004,"接口不存在:"),
    UNLAWFUL_MEDIATYPE(1500,"不允许通过的媒体类型MediaType@"),
    //sessioin
    SESSION_EXPIRED(3000,"会话已过期"),
    NO_SESSION(3001,"会话不存在,请创建会话"),
    NO_USER_ACCOUNT(3404,"用户不存在"),
    ERROR_PASSWORD(3405,"密码错误"),
    USER_WAS_LOGINED(3406,"用户已登录"),
    NO_VERIFY_ID(3214,"验证ID不能为空"),
    VERIFY_UNSUCCESS(3222,"验证未通过"),
    LOGOUT_FAILED(3333,"注销失败"),
    USER_REGISTERED(3211,"用户已经注册，请登录"),
    VERIFY_CODE_ERROR(3666,"验证码错误"),
    REGSITER_FAILED(3399,"注册失败"),
    NO_VERIFY_CODE(3366,"验证码不能为空"),
    ORDER_PAYD(4000,"订单已支付"),
    NO_ENOUGH_MONEY(4001,"余额不足"),
    HELLO_WORLD(9999,"你好，世界！");

    /**自定义状态码**/
    private final int code;
    /**自定义描述**/
    private final String message;

    ReturnCode(int code, String message){
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}