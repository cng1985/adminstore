package com.tongna.adminstore;

import com.tongna.adminstore.rest.domain.base.AbstractVo;
import com.tongna.adminstore.rest.domain.dto.CodeSendDto;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SendCodePlug plug=new SendCodePlug("23295373","5323ef746ae21951ae74d141cec496c6");

        CodeSendDto dto=new CodeSendDto();
        dto.setCode("8888");
        dto.setPhone("18229060103");
        dto.setProduct("猫头鹰");
        dto.setSignname("猫头鹰");
        dto.setSmsTemplateCode("SMS_4260063");
        AbstractVo vo=  plug.send(dto);
        System.out.println(vo);
    }
}
