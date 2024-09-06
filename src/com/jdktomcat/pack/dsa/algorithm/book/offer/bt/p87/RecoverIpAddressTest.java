package com.jdktomcat.pack.dsa.algorithm.book.offer.bt.p87;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RecoverIpAddressTest {

    @Test
    public void recoverIpAddress() {
        String address = "10203040";
        List<String> result = RecoverIpAddress.recoverIpAddress(address);
        System.out.println(Arrays.toString(result.toArray()));
    }
}