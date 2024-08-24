package com.jdktomcat.pack.pattern.book.head_first.chapter11;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

    protected MyRemoteImpl() throws RemoteException {

    }

    @Override
    public String sayHello() throws RemoteException {
        return "Server says hello!!";
    }

    public static void main(String[] args) {
        try {
            MyRemote remote = new MyRemoteImpl();
            Naming.rebind("remote", remote);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
