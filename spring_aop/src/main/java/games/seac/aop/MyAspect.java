package games.seac.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author Honmono
 * @date 2021/11/27 - 17:19
 */
public class MyAspect {

    public void before(){
        System.out.println("前置增强...");
    }

    public void afterReturning() {
        System.out.println("后置增强...");
    }

    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前...");
        Object proceed = pjp.proceed();//切点方法
        System.out.println("环绕后...");
        return proceed;
    }

    public void afterThrowing(){
        System.out.println("异常抛出增强");
    }

    public void after(){
        System.out.println("最终增强...");
    }

}
