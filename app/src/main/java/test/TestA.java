package test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static java.net.Proxy.Type.HTTP;

/**
 * Created by cxu on 18-1-20.
 */

public class TestA {
    public static void main(String[]argv) throws UnsupportedEncodingException {
        String json = "{'test':2, 'name':'jon'}";
        String encoderJson = URLEncoder.encode(json, "UTF-8");
        System.out.println(encoderJson);

        StringEntity se = new StringEntity(encoderJson);

    }
}
