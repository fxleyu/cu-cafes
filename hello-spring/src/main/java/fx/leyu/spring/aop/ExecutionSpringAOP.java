package fx.leyu.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class ExecutionSpringAOP implements MethodBeforeAdvice, AfterReturningAdvice, ThrowsAdvice {
    long startTime = 0;
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        String className = target.getClass().getCanonicalName();
        String methodName = method.getName();
        System.out.println("AFTER Execution of " + className + " # " + methodName + " ended");
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("BEFORE method " + method.getName());
        startTime = System.nanoTime();
    }

    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) {
        System.out.println("afterThrowing" + ex.getMessage());
    }

    public void executionAfterFinally(JoinPoint joinPoint) {
        System.out.println("AFTER FINALLY method " + joinPoint.getSignature().getName());
    }

    public void executionAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String className = proceedingJoinPoint.getTarget().getClass().getCanonicalName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        long start = System.currentTimeMillis();
        System.out.println("AROUND START");
        proceedingJoinPoint.proceed();
        System.out.println("AROUND Execution of " + className + " # " + methodName + " ended in "
                + (System.currentTimeMillis() - start));
    }
}
