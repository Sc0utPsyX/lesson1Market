package ru.geekbrains.march.market.aspect;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class DebugServiceAspect {

    @Pointcut("execution (* ru.geekbrains.march.market.controllers.*.*(..))")
    public void debugServiceAspectPointcut() {
    }

    @Before("debugServiceAspectPointcut()")
    public void logginStartAnyMethodWithArgs(JoinPoint jp) {
        StringBuilder args = new StringBuilder();
        int i = 1;
        if (jp.getArgs().length >= 1){
            for (Object a: jp.getArgs()){
                args.append("Arg №").append(i++).append(": ").append(a).append("; ");
            }
        }
        log.info(jp.getSignature() + " " + args.toString());
    }
}
