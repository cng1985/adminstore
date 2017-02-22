package com.tongna.adminstore;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import com.tongna.adminstore.rest.api.CodeApi;
import com.tongna.adminstore.rest.domain.base.AbstractVo;
import com.tongna.adminstore.rest.domain.dto.CodeSendDto;

/**
 * Created by ada on 2016/12/19.
 */
public class SendCodePlug  implements CodeApi{

    static String url = "http://gw.api.taobao.com/router/rest";
    private String appkey ;//= "23295373";
    private String secret ;//= "5323ef746ae21951ae74d141cec496c6";

    public SendCodePlug(String appkey, String secret) {
        this.appkey = appkey;
        this.secret = secret;
    }

    @Override
    public AbstractVo send(CodeSendDto dto) {
        AbstractVo result = new AbstractVo();

        SendVCode codes = new SendVCode();
        codes.setCode(dto.getCode());
        codes.setProduct(dto.getProduct());
        Gson gson = new Gson();
        TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setExtend("123456");
        req.setSmsType("normal");
        req.setSmsFreeSignName(dto.getSignname());
        req.setSmsParamString(gson.toJson(codes));
        req.setRecNum(dto.getPhone());
        req.setSmsTemplateCode("SMS_4260061");
        AlibabaAliqinFcSmsNumSendResponse rsp = null;
        try {
            rsp = client.execute(req);
            System.out.println(rsp.getBody());
            JsonParser parser=new JsonParser();
            JsonElement jsonObject = parser.parse(rsp.getBody());
            JsonElement jsonObject2 = jsonObject.getAsJsonObject().get("alibaba_aliqin_fc_sms_num_send_response");
            JsonElement jsonObject3 = jsonObject2.getAsJsonObject().get("result");
            if (jsonObject3.getAsJsonObject().get("success").getAsBoolean()) {
                result.setCode(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(-1);
            result.setMsg(""+e.getMessage());
        }

        return result;
    }
}
