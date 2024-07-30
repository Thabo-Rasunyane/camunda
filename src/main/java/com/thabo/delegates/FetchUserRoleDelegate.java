package com.thabo.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;


@Component("fetchUserRoleDelegate")
public class FetchUserRoleDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        System.out.println("Coming from FetchUserRole Delegate");

        execution.setVariable("userRoleFromDelegate", "Software Developer");
    }
}
