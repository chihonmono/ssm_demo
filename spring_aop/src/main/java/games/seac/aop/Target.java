package games.seac.aop;

/**
 * @author Honmono
 * @date 2021/11/26 - 17:32
 */
public class Target implements TargetInterface {
    public void save() {
        System.out.println("save running...");
    }
}
