package ru.geekbrains.march.market.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class TimerAspect {

    @Pointcut("@within(ru.geekbrains.march.market.aspect.Timer)")
    public void classesTimerShortcut() {
    }

    @Pointcut("@annotation(Timer)")
    public void methodTimerShortcut() {
    }

    @Pointcut("classesTimerShortcut() || methodTimerShortcut()")
    public void targetShortcut() {
    }

    @Around("targetShortcut()")
    public Object timer(ProceedingJoinPoint pjp) throws Throwable {
        Long time = System.currentTimeMillis();
        Object o = pjp.proceed();
        time = System.currentTimeMillis() - time;
        log.info("Время выполнения метода "
                + pjp.getSignature().getDeclaringTypeName()
                + "." + pjp.getSignature().getName()
                + ": " + time + " ms");
        return o;
    }
}
