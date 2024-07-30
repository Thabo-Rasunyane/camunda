package com.thabo.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class FetchEmailDelegate implements JavaDelegate {
    //OVERRIDING THE ABSTRACT METHODS IN JAVA DELEGATE CLASS
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        //BUSINESS LOGIC TO BE WRITTEN INSIDE THIS METHOD
        System.out.println("Coming from FetchEmail Delegate");
        System.out.println("userIdInput in FetchEmail Delegate :: " + execution.getVariable("userIdInput"));
        //assigning a variable to global scope
        execution.setVariable("userEmailIdFromDelegate", "thabo@test.com");
    }
}
