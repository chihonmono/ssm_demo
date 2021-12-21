package games.seac.anno;

import org.springframework.stereotype.Component;

/**
 * @author Honmono
 * @date 2021/11/26 - 17:32
 */
@Component("target")
public class Target implements TargetInterface {
    public void save() {
        System.out.println("save running...");
    }
}
