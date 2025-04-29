package com.esprit.examenblanche.configs;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    // loula * type de retour
    // thenya * package/ localisation
    // teltha * esm service
    // erabaaa esm l methode
    // khamsa (..) ay type arguemtn

   // @After("execution(* com.esprit.examenblanche.services.*(..))")

    @After("execution(* com.esprit.examenblanche.services.*.add*(..))")
    public void logAfter(JoinPoint joinPoint) {

        System.out.println("After method execution");

        String name = joinPoint.getSignature().getName();
        log.info("********************In method " + name + " : ");
    }

}
