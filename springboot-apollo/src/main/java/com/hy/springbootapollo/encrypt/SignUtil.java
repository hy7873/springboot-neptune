package com.hy.springbootapollo.encrypt;

import com.hy.springbootapollo.config.ConfigUtil;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.pkcs.RSAPrivateKeyStructure;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Security;
import java.security.spec.RSAPrivateKeySpec;
import java.util.Map;

public class SignUtil {

    private static final String ALGORITHM = "RSA";

    private static final String SIGN_ALGORITHMS = "SHA1WithRSA";

    private static final String SIGN_SHA256RSA_ALGORITHMS = "SHA256WithRSA";

    private static final String DEFAULT_CHARSET = "UTF-8";

    static{
        try{
            Security.addProvider(new BouncyCastleProvider());
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public static String getSiginature(Map<String, Object> paramMap) throws Exception{
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String,Object> entry : paramMap.entrySet()) {
            if (sb.length() == 0) {
                sb.append(entry.getKey() + "=" + entry.getValue());
            } else {
                sb.append("&").append(entry.getKey() + "=" + entry.getValue());
            }
        }
        PrivateKey rsaPrivateKey = RsaUtil.loadPrivateKeyPKCS1(ConfigUtil.getConfig("privateKey"));
        String signature = RsaUtil.sign(sb.toString(),rsaPrivateKey,true);
        return signature;
    }

    public static String privateKeyDecrypt(String content) throws IOException {
        PrivateKey rsaPrivateKey = RsaUtil.loadPrivateKeyPKCS1(ConfigUtil.getConfig("privateKey"));
        try {
            return RsaUtil.privateKeyDecrypt(content,rsaPrivateKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String getAlgorithms(boolean rsa2) {
        return rsa2 ? SIGN_SHA256RSA_ALGORITHMS : SIGN_ALGORITHMS;
    }

    public static String sign(String content, String privateKey, boolean rsa2) {
        try {
           /* PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(
                    Base64.decode(privateKey));
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM, "BC");
            PrivateKey priKey = keyFactory.generatePrivate(priPKCS8);*/

            byte[] priKeyData = Base64.decodeBase64(content);
            RSAPrivateKeyStructure asn1PrivKey = new RSAPrivateKeyStructure((ASN1Sequence) ASN1Sequence.fromByteArray(priKeyData));
            RSAPrivateKeySpec rsaPrivKeySpec = new RSAPrivateKeySpec(asn1PrivKey.getModulus(), asn1PrivKey.getPrivateExponent());
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
            PrivateKey priKey = keyFactory.generatePrivate(rsaPrivKeySpec);
            java.security.Signature signature = java.security.Signature
                    .getInstance(getAlgorithms(rsa2));
            signature.initSign(priKey);
            signature.update(content.getBytes(DEFAULT_CHARSET));
            byte[] signed = signature.sign();
            return Base64.encodeBase64String(signed);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
