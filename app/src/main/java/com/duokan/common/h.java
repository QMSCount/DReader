package com.duokan.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Deprecated
public class h {
    private static String a(byte b) {
        int i = (b & 127) + (b < (byte) 0 ? 128 : 0);
        return (i < 16 ? "0" : "") + Integer.toHexString(i).toLowerCase();
    }

    public static String a(String str) {
        int i = 0;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            StringBuffer stringBuffer = new StringBuffer();
            instance.update(str.getBytes(), 0, str.length());
            byte[] digest = instance.digest();
            while (i < digest.length) {
                stringBuffer.append(a(digest[i]));
                i++;
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}