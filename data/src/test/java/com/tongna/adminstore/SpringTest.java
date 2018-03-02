package com.tongna.adminstore;

import com.quhaodian.user.data.dao.UserAccountDao;
import com.quhaodian.user.data.service.UserAccountService;
import com.tongna.adminstore.data.service.MemberService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:applicationContext.xml"})
public class SpringTest {

    @Autowired
    MemberService memberService;

    @Test
    public void testObject() {

        Assert.assertNotNull(memberService);
    }
}
