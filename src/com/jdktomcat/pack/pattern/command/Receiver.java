package com.jdktomcat.pack.pattern.command;

/**
 * 接受者
 */
public class Receiver {
    void action(String command) {
        System.out.println("command received,now execute command:" + command);
    }

}
