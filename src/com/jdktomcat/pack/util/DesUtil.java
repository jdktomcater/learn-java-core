package com.jdktomcat.pack.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

public class DesUtil {

    private static String iv = "iv201812";

    private static String  key = "backcardpw@@@@";

    /**
     * 加密
     *
     * @param data 待加密的明文
     * @return 密文
     * @throws Exception
     */
    public static String encrypt(String data) throws Exception {
        byte[] dd = new byte[40];
        byte[] cc = data.getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < cc.length; i++) {
            if (i > 31) {
                dd[i] = 8;
            } else {
                dd[i] = cc[i];
            }
        }
        data = new String(dd);
        DESKeySpec ks = new DESKeySpec(key.getBytes(StandardCharsets.UTF_8));
        SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
        SecretKey sk = skf.generateSecret(ks);
        Cipher cip = Cipher.getInstance("DES/CBC/PKCS5Padding");// Cipher.getInstance("DES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8));
        cip.init(Cipher.ENCRYPT_MODE, sk, ivSpec);// IV的方式
        return new String(new Base64().encode(cip.doFinal(data.getBytes(StandardCharsets.UTF_8))));
    }

    /**
     * 解密
     *
     * @param data 待解密的密文
     * @return 明文
     */
    public static String decrypt(String data)  {
        String decryptStr;
        try {
            if (data == null) {
                return null;
            }
            byte[] buf = new Base64().decode(data.getBytes(StandardCharsets.UTF_8));
            SecureRandom sr = new SecureRandom();
            DESKeySpec dks = new DESKeySpec(key.getBytes(StandardCharsets.UTF_8));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            IvParameterSpec ivSpec = new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8));
            cipher.init(Cipher.DECRYPT_MODE, securekey, ivSpec);
            decryptStr = new String(cipher.doFinal(buf));
            decryptStr = decryptStr.replaceAll("\b|\u0020|\u3000", "");
            decryptStr = decryptStr.replaceAll("\u0001|\u0002|\u0003|\u0004|\u0005|\u0006|\u0007|\b|\t|\n|\u000b|\f" +
                    "|\r|\u000e|\u000f|\u0010|\u0011|\u0012|\u0013|\u0014", "");
            return decryptStr.trim();
        }catch (Throwable e) {
            throw  new RuntimeException("md5解密异常",e);
        }
    }

    public static void main(String[] args) throws Exception {
        String pass = "ENC(jnqcGbmi9Yy49i9SjM7DC1sUE+UaG29LCGT//medtMYPI/bXHPufBv5Ymj5TtSmiCJNp30gN/BkeT7mXSN/a7qlREAh5zjiDiUM7qylX55I=)";
        System.out.println(decrypt(pass));
    }
}
