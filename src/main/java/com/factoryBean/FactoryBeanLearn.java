package com.factoryBean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @ClassName FactoryBeanLearn
 * @Description TODO
 * Author sunhong
 * Date 2020-3-22 16:44
 **/
@Component
public class FactoryBeanLearn implements FactoryBean {


    @Override
    public Object getObject() throws Exception {
        return new FactoryBeanServiceImpl();
    }

    @Override
    public Class<?> getObjectType() {
        return FactoryBeanService.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
