package com.hy.crm.flowable;
import com.hy.crm.bo.Flowable;
import org.flowable.engine.*;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlowableTest {
    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private ManagementService managementService;

    /**
     * 部署流程模型
     */
    public void testDeploy(){
        Deployment deployment = repositoryService.createDeployment()
                .name("testDeploy")
                .addClasspathResource("flowable/sourceBpmn-from-bpmn20.xml")
                .deploy();
        System.out.println("DeployTest successfullly, deployId:" + deployment.getId() + "; deployName:" + deployment.getName());
    }

    /**
     * 查询流程定义
     */
    public void queryProcessDefinitionTest(){
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .deploymentId("1") // 用上一步中的结果
                .singleResult();
        System.out.println("Found process definition : " + processDefinition.getName() + "; key:"  + processDefinition.getKey() + ";id:" + processDefinition.getId());
    }

    /**
     * 启动流程
     */
    public void startProcessInstanceTest(Flowable flowable){
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("employee", flowable.getEmployee());
        variables.put("nrOfHolidays", flowable.getNrOfHolidays());
        variables.put("description", flowable.getDescription());
        ProcessInstance processInstance =
                runtimeService.startProcessInstanceByKey("holidayRequest", variables);

    }

    /**
     * 查询并完成任务
     */
    public void queryAndCompleteTask(){
        // 查询
        List<Task> tasks = taskService.createTaskQuery().taskCandidateGroup("managers").list();
        System.out.println("You have " + tasks.size() + " tasks:");
        for (int i=0; i<tasks.size(); i++) {
            System.out.println((i+1) + ") " + tasks.get(i).getName());
        }

        // 选择
        Task task = tasks.get(1);
        Map<String, Object> processVariables = taskService.getVariables(task.getId());
        System.out.println(processVariables.get("employee") + " wants " +
                processVariables.get("nrOfHolidays") + " of holidays. Do you approve this?");

        //完成
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("approved", true);
        taskService.complete(task.getId(), variables);
    }

    /**
     * 查询历史数据
     */
    public void queryHistoryData(){
        List<HistoricActivityInstance> activities =
                historyService.createHistoricActivityInstanceQuery().processInstanceId("4")
                        .orderByHistoricActivityInstanceEndTime().asc()
                        .list();

        for (HistoricActivityInstance activity : activities) {
            System.out.println(activity.getActivityId() + " took "
                    + activity.getDurationInMillis() + " milliseconds");
            System.out.println("======================================");
        }
    }
}