package com.hy.crm.flowable;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;

public class TableTest {
    public static void main(String[] args) {
        ProcessEngineConfiguration cfg = new StandaloneProcessEngineConfiguration()
                .setJdbcUrl("jdbc:mysql://127.0.0.1:3306/cmd?useUnicode=true&characterEncoding=UTF-8")
                .setJdbcUsername("root")
                .setJdbcPassword("huayu")
                .setJdbcDriver("com.mysql.jdbc.Driver")
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        ProcessEngine processEngine = cfg.buildProcessEngine();
    }
}
