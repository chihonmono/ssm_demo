package games.seac.anno;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 注解方式
 * @author Honmono
 * @date 2021/11/27 - 17:19
 */
@Component("myAspect")
@Aspect
public class MyAspect {
    @Before("execution(* games.seac.anno.*.*(..))")
    public void before() {
        System.out.println("前置增强...");
    }

    @AfterReturning("execution(* games.seac.anno.*.*(..))")
    public void afterReturning() {
        System.out.println("后置增强...");

    }
    @Around("execution(* games.seac.anno.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前...");
        Object proceed = pjp.proceed();//切点方法
        System.out.println("环绕后...");
        return proceed;
    }

    @After("execution(* games.seac.anno.*.*(..))")
    public void afterThrowing() {
        System.out.println("异常抛出增强");
    }

    @After("execution(* games.seac.anno.*.*(..))")
    public void after() {
        System.out.println("最终增强...");
    }

}
