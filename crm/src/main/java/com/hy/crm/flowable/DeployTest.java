package com.hy.crm.flowable;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeployTest {
    /**
     *部署流程
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        FlowableTest flowable= (FlowableTest)applicationContext.getBean("flowable");
        flowable.testDeploy();
    }
}
