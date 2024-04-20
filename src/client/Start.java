package client;

import client.main.Main;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author: Skider!!!
 * @create: 2023/8/22
 * @Description:
 * @FileName: start
 * @History:
 */
public class Start {
    public static void main(String[] args) {
        PropertyConfigurator.configure("src/log4j.properties");
        new Main();
    }
}
