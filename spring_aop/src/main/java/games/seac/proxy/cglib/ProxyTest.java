package games.seac.proxy.cglib;

import games.seac.proxy.jdk.TargetInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Honmono
 * @date 2021/11/26 - 17:33
 */
public class ProxyTest {
    public static void main(String[] args) {
        //目标对象
        final Target target = new Target();

        //增强对象
        final Advice advice = new Advice();


        //返回值 动态生成的代理对象
        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
                //目标对象类加载器
                target.getClass().getClassLoader(),
                //目标对象相同的接口字节码对象数组
                target.getClass().getInterfaces(),
                //接口
                new InvocationHandler() {
                    //调用代理对象的任何方法，实质执行的都是invoke()方法
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //前置增强
                        advice.before();
                        //执行目标方法 该invoke不是当前的invoke方法
                        Object invoke = method.invoke(target, args);
                        //后置增强
                        advice.after();
                        return invoke;
                    }
                }
        );
        //调用代理对象的方法
        proxy.save();

    }
}
