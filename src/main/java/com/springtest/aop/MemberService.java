package com.springtest.aop;

import com.springtest.aop.ImemberService;
import org.springframework.stereotype.Component;

/**
 * @ClassName MemberService
 * @Description TODO
 * Author sunhong
 * Date 2020-3-27 9:20
 **/
@Component
public class MemberService implements ImemberService {
    @Override
    public void save() {
        System.out.println("±£´æ²Ù×÷");
    }
}
