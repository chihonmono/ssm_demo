package games.seac.proxy.cglib;

/**
 * @author Honmono
 * @date 2021/11/26 - 17:32
 */
public class Advice {
    public void before(){
        System.out.println("前置增强...");
    }
    public void after(){
        System.out.println("后置增强...");
    }

}
