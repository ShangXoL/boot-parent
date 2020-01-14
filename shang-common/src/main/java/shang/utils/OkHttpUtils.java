package shang.utils;
import okhttp3.*;
import okhttp3.Response;

import java.io.IOException;

/**
 * @Author xiaoliang.shang
 * @Date 2019/10/22 17:00
 * @DESCRIPTION okHttpUtils
 **/
public class OkHttpUtils {
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static OkHttpClient client = new OkHttpClient();

    public static Response post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response;
    }

    public static Response get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        return response;
    }

    /**
     * @description 封装
     * @param url
     * @param json
     * @param clazz
     * @return T
     * @date 2020/1/3 9:27
     * @author xiaoliang.shang
     */
    public static <T> T postBeautify(String url, String json, Class<T> clazz) {
        T result = null;
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (response != null) {
            String resultStr = null;
            try {
                resultStr = response.body().string();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            if (StringUtils.isNotEmpty(resultStr)) {
                try {
                    result = com.alibaba.fastjson.JSON.parseObject(resultStr, clazz);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }


}
