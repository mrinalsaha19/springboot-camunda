package com.javatech.mrinal.service;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;
import java.util.Map;

@Named
public class ProcessOrder implements JavaDelegate {


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        Map<String, Object> variables = delegateExecution.getVariables();
        RuntimeService runtimeService = delegateExecution.getProcessEngineServices().getRuntimeService();
        Map<String, Object> variables1 = delegateExecution.getVariables();
        String input = (String) delegateExecution.getVariable("itemType");
        System.out.println("Message : "+ input);
        // Some business logic
        if (input.equals("TV")) {
            delegateExecution.setVariable("available", "Yes");
        } else {
            delegateExecution.setVariable("available", "No");
        }
    }
}
