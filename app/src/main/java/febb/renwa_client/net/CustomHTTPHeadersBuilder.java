package febb.renwa_client.net;


import android.util.Base64;

import org.threeten.bp.LocalDateTime;
import org.threeten.bp.format.DateTimeFormatter;

import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import febb.renwa_client.common.Construct;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public class CustomHTTPHeadersBuilder {

    //生成方式：HMAC-SHA256
    private static final String ALGORISM = "hmacSHA256";
    //ハッシュのSALT
//    private static final String clientKey = "@qgm@rq290i92q3fnverjfmwaeisvns[]m@vnersie9@jgf9034j0g@vns@09e34nsgen4390jtgne@4f@nsenf[an@w4nth9048ngna@wnf8na8g2ivierni";

    public static Map<String, String> createHeaders(Class<?> serviceClass, String methodName, String sessionToken) {
        String HTTPMethod = "GET";
//        String apiPath = "http://flask-env.5csymrfgjb.us-east-2.elasticbeanstalk.com/getter?name=renwa";
        String apiPath = "";


        Method[] methods = serviceClass.getMethods();
        for(Method method : methods){
            if (methodName.equals(method.getName())) {
                Annotation[] annotations = method.getAnnotations();
                for(Annotation annotation : annotations){
                    //System.out.println(annotation);
                    //System.out.println(annotation.annotationType().getName());
                    System.out.println(annotation.annotationType().getSimpleName());
//                    HTTPMethod = annotation.annotationType().getSimpleName();

                    apiPath = "";

//                    if (annotation instanceof GET) {
//                        apiPath = ((GET) annotation).value();
//                        //System.out.println(((GET) annotation).value());
//                    } else if (annotation instanceof POST) {
//                        apiPath = ((POST) annotation).value();
//                        //System.out.println(((POST) annotation).value());
//                    } else if (annotation instanceof PUT) {
//                        apiPath = ((PUT) annotation).value();
//                    } else if (annotation instanceof DELETE) {
//                        apiPath = ((DELETE) annotation).value();
//                    }
                }
            }
        }
        System.out.println("HTTPMethod=" + HTTPMethod);
        System.out.println("apiPath=" + apiPath);

        Map<String, String> map = new HashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
//        LocalDateTime localDateTime = LocalDateTime.now();
//        String timestamp = localDateTime.format(formatter);
        String timestamp = "123456789";

        map.put("X-COIN-Signature", createSignature(HTTPMethod, apiPath, timestamp));
        map.put("X-COIN-Timestamp", timestamp);
        map.put("X-COIN-Session-Token", sessionToken);

        return map;
    }

    public static Map<String, String> createHeaders(String HTTPMethod, String apiPath, String sessionToken) {
        Map<String, String> map = new HashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.now();
        String timestamp = localDateTime.format(formatter);

        map.put("X-COIN-Signature", createSignature(HTTPMethod, apiPath, timestamp));
        map.put("X-COIN-Timestamp", timestamp);
        map.put("X-COIN-Session-Token", sessionToken);

        return map;
    }

    private static String createSignature(String HTTPMethod, String apiPath, String timestamp) {
        String signature = HTTPMethod + "\n";
        signature += Construct.FP_FQDN + "\n";
        signature += apiPath + "\n";
//        signature += Construct.APPLICATION_KEY;
//        signature += "&" + Construct.SIGNATURE_METHOD;
        signature += "&" + timestamp;

//        return hmacSHA256(signature);
        return signature;
    }


    private static String hmacSHA256(String str) {
        try {
            Mac mac = Mac.getInstance(ALGORISM);
//            SecretKeySpec secretKeySpec = new SecretKeySpec(Construct.APPLICATION_KEY.getBytes("UTF-8"), ALGORISM);
//            mac.init(secretKeySpec);
//            byte[] digest = mac.doFinal(str.getBytes("UTF-8"));
//            String hashed_hex = bin2hex(digest);
//            return Base64.encodeToString(hashed_hex.getBytes("UTF-8"), Base64.DEFAULT).replace("\n", "");
//            return Base64.encodeToString(digest, Base64.DEFAULT).replace("\n", "");
//        } catch (InvalidKeyException e) {
//            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
        }
        return "";
    }

    /**
     * バイト文字を 16 進数文字列に変換する
     */
    private static String bin2hex(byte[] data) {
        StringBuffer sb = new StringBuffer();
        for(byte b : data){
            String s = Integer.toHexString(0xff & b);
            if (s.length() == 1) {
                sb.append("0");
            }
            sb.append(s);
        }
        return sb.toString();
    }
}
