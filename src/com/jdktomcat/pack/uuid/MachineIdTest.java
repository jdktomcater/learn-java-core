package com.jdktomcat.pack.uuid;

import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class MachineIdTest {

    public static String digest(String input) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digestBytes = md.digest(input.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : digestBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }


    public static void main(String[] args) throws Exception {
        InetAddress addr = InetAddress.getLocalHost();
        String address = addr.getHostAddress();
        String hostname = addr.getHostName();
        String pText = address + hostname;
        System.out.println("MD5:" + digest(pText));
    }
}
