package games.seac.service;

import com.itheima.exception.MyException;
import games.seac.exception.MyException;

import java.io.FileNotFoundException;

public interface DemoService {
    void show1();

    void show2();

    void show3() throws FileNotFoundException;

    void show4();

    void show5() throws MyException, MyException;
}
