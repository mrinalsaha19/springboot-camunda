package com.javatech.mrinal.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Named
public class ProcessLoan implements JavaDelegate {


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String approval = null;
        Double amountRequested = (Double) delegateExecution.getVariable("amountRequested");
        System.out.println("Requested Amount: "+ amountRequested);
        if(amountRequested >10000) {
            approval = "Declined";
        } else {
            approval = "Approved";
        }
        delegateExecution.setVariable("status", approval);
    }
}
