package json;

import bean.Diaosi;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZH on 2016/11/2.
 */
public class ImoocJson {

    public static void main(String args[]){
        CreateAJson();
        createJsonObjToMap();
        createJsonObjToBean();

        try {
            readJsonFromFile();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //创建一个json对象
    private static void CreateAJson(){
        JSONObject jsonObject = new JSONObject();
        Object nullObj = null;
        try{
            jsonObject.put("name","郑豪");
            jsonObject.put("age",23);
            jsonObject.put("gender","male");
            jsonObject.put("iphone",new String[]{"iphone6 plus","ipad air","hp-302"});
            jsonObject.put("car",false);
            jsonObject.put("house",nullObj);
            System.out.println(jsonObject.toString());
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    //将map转换为一个json
    private static void createJsonObjToMap(){
        Map<String,Object> map = new HashMap<>();
        Object nullObj = null;
        map.put("name","郑豪");
        map.put("age",23);
        map.put("gender","male");
        map.put("iphone",new String[]{"iphone6 plus","ipad air","hp-302"});
        map.put("car",false);
        map.put("house",nullObj);
        System.out.println(new JSONObject(map).toString());
    }

    //将javaBean转换为一个json
    private static void createJsonObjToBean(){
        Diaosi wangxiaoer = new Diaosi("郑豪",23,"男",false,new String[]{"iphone6 plus","ipad air","hp-302"},null,"abcderfg","2015-01-01");
        System.out.println(new JSONObject(wangxiaoer).toString());
    }

    private static void readJsonFromFile() throws IOException,JSONException{
        File file = new File(ImoocJson.class.getResource("/json/wangxiaoer.json").getFile());
        String content = FileUtils.readFileToString(file,"UTF-8");
        /** 用JSONArray去接受一个json数组 */
//        JSONArray jsonArray = new JSONArray(content);
//        System.out.println(jsonArray);
//        for(int i=0;i<jsonArray.length();i++){
//            System.out.println(jsonArray.get(i));
//        }
        JSONObject jsonObject = new JSONObject(content);

        //json对象中的数组用JSONArray接受
        JSONArray iphoneArray = jsonObject.getJSONArray("iphone");
        for(int i=0;i<iphoneArray.length();i++){
            System.out.println("iphone-"+(i+1)+"是："+iphoneArray.get(i));
        }

        //增加程序的健壮性
        //isNull("json对象属性名")
        if(!jsonObject.isNull("name")){
            System.out.println("姓名是:"+jsonObject.getString("name"));
        }

        if(!jsonObject.isNull("nickName")){
            System.out.println("绰号是:"+jsonObject.getString("name"));
        }
    }

    /**
     * json的缺陷:
     * 1.json中不允许出现Date类型
     * 2.json对bean不能进行反解析
     */
}
