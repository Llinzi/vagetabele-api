package com.vegetable.common;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @ClassName : SubMailUtils
 * @Description : 短信工具类(赛邮)
 * @Author : 袁田婷
 * @Date: 2020-03-02 14:39
 */
public class SubMailUtils {

    /**
     * 短信应用 ID
     */
    private static final String APP_ID = "46716";

    /**
     *应用密匙
     */
    private static final String SIGNATURE = "30c48fbe83573a5b8537681b13b0169f";

    /**
     * url
     */
    private static final String X_SEND = "https://api.mysubmail.com/message/xsend";


    /**
     * 发送一天短信
     * @param to 发送人电话
     * @param project 发送的模板
     * @param vars 模板内的变量(code:验证码; time:过期时间)
     * @return 成功返回 true ，失败返回 false
     */
    public static boolean sendMessage(String to, String project, JSONObject vars){
        //获取httpclient
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //发出post请求
        HttpPost httpPost = new HttpPost(X_SEND);
        //创建参数
        JSONObject json = new JSONObject();
        json.put("appid",APP_ID);
        json.put("to",to);
        json.put("project",project);
        json.put("signature",SIGNATURE);
        json.put("vars",vars);
        StringEntity stringEntity = new StringEntity(json.toJSONString(),"UTF-8");
        stringEntity.setContentEncoding("UTF-8");
        stringEntity.setContentType("application/json");
        httpPost.setEntity(stringEntity);
        try {
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            //打印参数
            System.out.println(EntityUtils.toString(httpEntity,"UTF-8"));
            //判断状态码是否为 200
            return response.getStatusLine().getStatusCode() == 200;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
