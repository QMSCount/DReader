package com.duokan.reader.domain.statistics.dailystats;

import android.annotation.SuppressLint;
import android.util.Base64;

import com.duokan.core.app.ManagedApp;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.a.c;
import com.duokan.reader.common.webservices.duokan.ad;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.domain.account.a;

import org.apache.http.client.methods.HttpPost;

import java.security.Key;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Random;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class d extends ad {
    public d(WebSession webSession) {
        super(webSession, (a) null);
    }

    @SuppressLint({"TrulyRandom"})
    public b e(String str) {
        if (ManagedApp.get().isDebuggable()) {
            com.duokan.core.diagnostic.a.c().c(LogLevel.INFO, "stats", "send: " + str);
        }
        com.duokan.reader.common.webservices.duokan.a.d a = a(new c().a(HttpPost.METHOD_NAME).b(a(false, a() + "/noop")).a(f(str).getBytes()).a());
        if (ManagedApp.get().isDebuggable()) {
            com.duokan.core.diagnostic.a.c().c(LogLevel.INFO, "stats", "response: " + a.a());
        }
        b bVar = new b();
        bVar.b = a.a();
        return bVar;
    }

    private String a() {
        return p.i().n();
    }

    private byte[] a(String str, byte[] bArr, IvParameterSpec ivParameterSpec) {
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        if (length % 16 != 0) {
            length += 16 - (length % 16);
        }
        byte[] copyOf = Arrays.copyOf(bytes, length);
        Key secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/NoPadding");
        instance.init(1, secretKeySpec, ivParameterSpec);
        return instance.doFinal(copyOf);
    }

    @SuppressLint({"TrulyRandom"})
    private byte[] a(byte[] bArr, String str) {
        AlgorithmParameterSpec algorithmParameterSpec = OAEPParameterSpec.DEFAULT;
        SecureRandom secureRandom = new SecureRandom();
        Key generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
        Cipher instance = Cipher.getInstance("RSA/ECB/OAEPWITHSHA1ANDMGF1PADDING");
        instance.init(1, generatePublic, algorithmParameterSpec, secureRandom);
        return instance.doFinal(bArr);
    }

    private String f(String str) {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        instance.init(128, new SecureRandom());
        byte[] encoded = instance.generateKey().getEncoded();
        Object obj = new byte[16];
        new Random().nextBytes(obj);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(obj);
        byte[] bArr = new byte[(encoded.length + obj.length)];
        Object copyOf = Arrays.copyOf(encoded, encoded.length + obj.length);
        System.arraycopy(obj, 0, copyOf, encoded.length, obj.length);
        byte[] a = a(copyOf, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAy1+Tb5ch4blt46afIvJW21WQuGeRITyPWKlrXUrPBJOkSaTRe9rzeN+kWXA/IFLkM9HSqrnfzjO5nU7t3rCZfHtw/xutrarj+sci3eXWnN9d55edIs91DwJh5iWQyU5hRJ5DxpB1iDi6r8qEncqU2gK1JH56G/tdCXcdrgNBo2ge83gl/bm0CjtXcrAwzZ+pFrXkKsP9OmYyTlVdOUP1V6SAzI2nlMArcjTe99g4xdnR0X/YqAFcTIqA8sX7mA2/LcWItDLauRH6x7Mbca2XvPqTLV1boBa4V7rlm8qzgUMoJE+2Pt+0GM8JIqmG3lpe8sd8qK0twhJvFWVu6ixSmwIDAQAB");
        Object a2 = a(str, encoded, ivParameterSpec);
        Object copyOf2 = Arrays.copyOf(a, a.length + a2.length);
        System.arraycopy(a2, 0, copyOf2, a.length, a2.length);
        return Base64.encodeToString(copyOf2, 0);
    }
}
