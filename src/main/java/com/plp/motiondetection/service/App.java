package com.plp.motiondetection.service;

import org.wso2.msf4j.MicroservicesRunner;

public class App 
{
    public static void main(String[] args) {
        new MicroservicesRunner()
                .deploy(new MotionDetectionService())
                .start();
    }
}
