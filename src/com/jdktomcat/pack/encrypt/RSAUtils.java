package com.jdktomcat.pack.encrypt;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author ZF-Timmy
 * @version V1.0
 * @description 类描述：RSA加解密
 * @date 2023/12/10
 */
public class RSAUtils {
    private static final String src = "1234";
    private static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCk50kY89jhp280PLdFgKKgmIAlW8xpEk3uvaAfrgd0GIjuqT8N4QJi1HLj/zZH/LBavsps/vy9qhSkSvCtHfqhwdba7+sdrbbcV5sbS2Kfd5emXWXgJn4DaIsgYhmnUF4FpL3NLXlQbrrPWOA89z5cBs+HUekcx0OrU5SomKtnVwIDAQAB";
    private static final String PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKTnSRjz2OGnbzQ8t0WAoqCYgCVbzGkSTe69oB+uB3QYiO6pPw3hAmLUcuP/Nkf8sFq+ymz+/L2qFKRK8K0d+qHB1trv6x2tttxXmxtLYp93l6ZdZeAmfgNoiyBiGadQXgWkvc0teVBuus9Y4Dz3PlwGz4dR6RzHQ6tTlKiYq2dXAgMBAAECgYAbZ2AraGKTZWrCiJCAWVctTwqEqtO2ZldTJGoWuan9bhJbbv7OhKUL3XhWUVQo9GIuQmSLZniD4F7byqRicIf00lzxkkPi02F+eIdW58rvNerk/r8Tpxb+kXO53YrcEYDhqY4q+aREvjze8fgAwARTyyis9F1JKb3sZvsAB/o/iQJBAPQ4l8tgBzqcJxXwlKktfiyCtCGmOkhw3PizDraD3U8U8m6hjwITFTvI9fvgDR9I7Hg6vh8p5FEObmxSCuwRbe0CQQCs21rg6CT4R6F825hyosioL2pnF2KXHp90/B6Fgy6HtyXpXk4ETcC5AaoA0BPTC1LwbJavBAJZ4bIIxRJtY2HTAkEAj3YXJS750CIei7LRgTfqIHd/HS0qm5dBFw8IG4sGnAfwCbD58vwGwyHf7d/FlZUe49mOCXxwVHUnxJXFOLtcWQJAElKyQHL7MEJPkO+qKkStJn7YNZNaBRDe8ESla5urPAGjCCjR9kzTqAjQH4PvBgkGQqwQEP9IzIRLHfjd6jCFtwJBAOE1LGPZ2Qn2BAhvvtYSV7/Rlboj6NdcfkL7VId22W0ese/Jew/SictYf1TLDmI6LqKrDzgQg6Zq7SKvIR3zQ6g=";
    public static void main(String[] args) throws Exception {
        System.out.println("\n");
        RSAKeyPair keyPair = new RSAKeyPair(PUBLIC_KEY, PRIVATE_KEY);
        System.out.println("公钥：" + keyPair.getPublicKey());
        System.out.println("私钥：" + keyPair.getPrivateKey());
        System.out.println("\n");
        test1(keyPair);
        System.out.println("\n");
        test2(keyPair);
        System.out.println("\n");
    }

    /**
     * 公钥加密私钥解密
     */
    private static void test1(RSAKeyPair keyPair) throws Exception {
        System.out.println("***************** 公钥加密私钥解密开始 *****************");
        String text1 = encryptByPublicKey(keyPair.getPublicKey(), RSAUtils.src);
        String text2 = decryptByPrivateKey(keyPair.getPrivateKey(), text1);
        System.out.println("加密前：" + RSAUtils.src);
        System.out.println("加密后：" + text1);
        System.out.println("解密后：" + text2);
        if (RSAUtils.src.equals(text2)) {
            System.out.println("解密字符串和原始字符串一致，解密成功");
        } else {
            System.out.println("解密字符串和原始字符串不一致，解密失败");
        }
        System.out.println("***************** 公钥加密私钥解密结束 *****************");
    }

    /**
     * 私钥加密公钥解密
     *
     * @throws Exception
     */
    private static void test2(RSAKeyPair keyPair) throws Exception {
        System.out.println("***************** 私钥加密公钥解密开始 *****************");
        String text1 = encryptByPrivateKey(keyPair.getPrivateKey(), RSAUtils.src);
        String text2 = decryptByPublicKey(keyPair.getPublicKey(), text1);
        System.out.println("加密前：" + RSAUtils.src);
        System.out.println("加密后：" + text1);
        System.out.println("解密后：" + text2);
        if (RSAUtils.src.equals(text2)) {
            System.out.println("解密字符串和原始字符串一致，解密成功");
        } else {
            System.out.println("解密字符串和原始字符串不一致，解密失败");
        }
        System.out.println("***************** 私钥加密公钥解密结束 *****************");
    }

    /**
     * 公钥解密
     *
     * @param publicKeyText
     * @param text
     * @return
     * @throws Exception
     */
    public static String decryptByPublicKey(String publicKeyText, String text) throws Exception {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(Base64.decodeBase64(publicKeyText));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] result = cipher.doFinal(Base64.decodeBase64(text));
        return new String(result);
    }

    /**
     * 私钥加密
     *
     * @param privateKeyText
     * @param text
     * @return
     * @throws Exception
     */
    public static String encryptByPrivateKey(String privateKeyText, String text) throws Exception {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKeyText));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] result = cipher.doFinal(text.getBytes());
        return Base64.encodeBase64String(result);
    }

    /**
     * 私钥解密
     *
     * @param privateKeyText
     * @param text
     * @return
     * @throws Exception
     */
    public static String decryptByPrivateKey(String privateKeyText, String text) throws Exception {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec5 = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKeyText));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec5);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] result = cipher.doFinal(Base64.decodeBase64(text));
        return new String(result);
    }

    /**
     * 公钥加密
     *
     * @param publicKeyText
     * @param text
     * @return
     */
    public static String encryptByPublicKey(String publicKeyText, String text) throws Exception {
        X509EncodedKeySpec x509EncodedKeySpec2 = new X509EncodedKeySpec(Base64.decodeBase64(publicKeyText));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec2);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] result = cipher.doFinal(text.getBytes());
        return Base64.encodeBase64String(result);
    }

    /**
     * RSA密钥对对象
     */
    public static class RSAKeyPair {
        private final String publicKey;
        private final String privateKey;

        public RSAKeyPair(String publicKey, String privateKey) {
            this.publicKey = publicKey;
            this.privateKey = privateKey;
        }

        public String getPublicKey() {
            return publicKey;
        }

        public String getPrivateKey() {
            return privateKey;
        }
    }
}
