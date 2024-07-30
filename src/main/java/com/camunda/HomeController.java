package com.camunda;


import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.runtime.ProcessInstantiationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    public String home(){
        return "Today is a bad day!";
    }

    @GetMapping("/execute/{processKey}")
    public String execute(@PathVariable String processKey){
        try {
            ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
            ProcessInstantiationBuilder instance = processEngine.getRuntimeService().createProcessInstanceByKey(processKey);
//            accessing variables inside bpmn
            String item = "Computers";
            instance.setVariable("itemName", item);

            //business key to detect endpoint where bpmn was invoked
            instance.businessKey("execute-endpoint");

            instance.executeWithVariablesInReturn();
            return "BPMN executed :: " + processKey;
        }catch (Exception e){
            return "Execution failed" + e.getMessage();
        }

    }
    //endpoint to invoke new bpmn
//    @GetMapping("/tasks")
//    public String tasks(){
//
//        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
//        ProcessInstantiationBuilder instance = engine.getRuntimeService().createProcessInstanceByKey("tasks_executor");
//        instance.executeWithVariablesInReturn();
//
//        return "Task BPMN has been executed!";
//    }
}
