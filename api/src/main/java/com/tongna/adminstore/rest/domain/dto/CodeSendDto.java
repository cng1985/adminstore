package com.tongna.adminstore.rest.domain.dto;

import com.tongna.adminstore.rest.domain.base.BaseDto;

/**
 * Created by ada on 2016/12/19.
 */
public class CodeSendDto extends BaseDto {

    /**
     * 验证码
     */
    String code;

    /**
     * 发送验证码的产品
     */
    String product;

    /**
     * 手机号
     */
    String phone;

    /**
     * 消息模板
     */
    String smsTemplateCode;

    /**
     * 签名
     */
    String signname;

    public String getSignname() {
        return signname;
    }

    public void setSignname(String signname) {
        this.signname = signname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSmsTemplateCode() {
        return smsTemplateCode;
    }

    public void setSmsTemplateCode(String smsTemplateCode) {
        this.smsTemplateCode = smsTemplateCode;
    }
}
