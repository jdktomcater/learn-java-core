package com.jdktomcat.pack.pattern.book.head_first.chapter11;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemote extends Remote {

    public String sayHello() throws RemoteException;
}
