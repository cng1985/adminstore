package com.taobao.api;
/**
 * 秘钥异常
 * 
 * @author changchun
 * @since 2016年3月3日 下午3:20:18
 */
public class SecretException extends Exception {

    private static final long serialVersionUID = -238091758285157331L;

    private String errCode;
    private String errMsg;

    public SecretException() {
        super();
    }

    public SecretException(String message, Throwable cause) {
        super(message, cause);
    }

    public SecretException(String message) {
        super(message);
    }

    public SecretException(Throwable cause) {
        super(cause);
    }

    public SecretException(String errCode, String errMsg) {
        super(errCode + ":" + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

}