package com.hy.crm.service.impl;

import com.hy.crm.bo.Flowable;
import org.flowable.engine.HistoryService;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.history.HistoricActivityInstance;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FlowableService {
    @Autowired
    private TaskService taskService;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private HistoryService historyService;

    List<Task> tasks=new ArrayList<>();

    ProcessInstance processInstance;

    /**
     * 启动流程
     */
    public String startProcessInstanceTest(Flowable flowable){
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("employee", flowable.getEmployee());
        variables.put("nrOfHolidays", flowable.getNrOfHolidays());
        variables.put("description", flowable.getDescription());
         processInstance =
                runtimeService.startProcessInstanceByKey("holidayRequest", variables);
        return processInstance.getProcessInstanceId();

    }

    /**
     * 将task map 封装到自己的实体类
     * @return
     */
    public List<Flowable> query(){
        List<Flowable> list=new ArrayList<>();
        tasks = taskService.createTaskQuery().taskCandidateGroup("managers").list();
        for (int i=0; i<tasks.size(); i++) {
            Task task = tasks.get(i);
            Map<String, Object> processVariables = taskService.getVariables(task.getId());
            Flowable flowable=new Flowable();
            flowable.setId(i);
            flowable.setEmployee((String)processVariables.get("employee"));
            flowable.setNrOfHolidays((String) processVariables.get("nrOfHolidays"));
            flowable.setDescription((String)processVariables.get("description"));
            System.out.println(flowable);
            list.add(flowable);
        }
        return list;
    }

    /**
     * 查看详情
     * @param index
     * @return
     */
    public Flowable toUpdate(Integer index){
        Flowable flowable=new Flowable();
        Task task = tasks.get(index);
        Map<String, Object> processVariables = taskService.getVariables(task.getId());
        flowable.setId(index);
        flowable.setEmployee(processVariables.get("employee")+"");
        flowable.setNrOfHolidays(processVariables.get("nrOfHolidays")+"");
        flowable.setDescription(processVariables.get("description")+"");
        return flowable;
    }

    /**
     * 完成
     * @param approved 同意不同意
     * @param index 下标
     * @param postil 批注
     */
    public void update(boolean approved,Integer index,String postil){
        Task task = tasks.get(index);
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("approved", approved);
        variables.put("postil", postil);
        taskService.complete(task.getId(), variables);
    }

    /**
     * 查询历史数据
     */
    public List<HistoricActivityInstance> queryHistoryData(){
        List<HistoricActivityInstance> activities =
                historyService.createHistoricActivityInstanceQuery()
                        .processInstanceId(processInstance.getId())
                        .finished()
                        .orderByHistoricActivityInstanceEndTime().asc()
                        .list();
        return activities;
        /*for (HistoricActivityInstance activity : activities) {
            System.out.println(activity.getActivityId() + " took "
                    + activity.getDurationInMillis() + " milliseconds");
        }*/
    }
}
