package gson;

import bean.Diaosi;
import bean.DiaosiWithDate;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 * Created by ZH on 2016/11/3.
 */
public class ImoocGson {
    public static void main(String args[]){
        System.out.println("-------------Gson create json start------------");
        gsonCreateJson();
        System.out.println("-------------Gson create json end------------");
        System.out.println("-------------Gson parse json start------------");
        gsonPraseJson();
        System.out.println("-------------Gson parse json end------------");
        System.out.println("-------------Gson parse json width date start------------");
        gsonParseJsonWithDate();
        System.out.println("-------------Gson parse json width date end------------");
    }

    private static void gsonCreateJson(){
        Diaosi wangxiaoer = new Diaosi("郑豪",23,"男",false,new String[]{"iphone6 plus","ipad air","hp-302"},null,"saasaasa","1993-01-01");
        //使打印出的json数据格式化
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        //将bean中的属性转换为用户需要的
        gsonBuilder.setFieldNamingStrategy(new FieldNamingStrategy() {
            @Override
            public String translateName(Field field) {
                if(field.getName().equals("name")){
                    return "NAME";
                }
                return field.getName();
            }
        });
        Gson gson = gsonBuilder.create();
        System.out.println(gson.toJson(wangxiaoer));
    }

    //反解析json数据
    private static void gsonPraseJson(){
        File file = new File(Diaosi.class.getResource("/json/wangxiaoer.json").getFile());
        try {
            String content = FileUtils.readFileToString(file,"UTF-8");
            JSONArray jsonArray = new JSONArray(content);
            for(int i=0;i<jsonArray.length();i++){
                Gson gson = new Gson();
                Diaosi wangxiaoer = gson.fromJson(jsonArray.get(i).toString(),Diaosi.class);
                System.out.println(wangxiaoer.toString());
            }

        }catch(IOException e){
            e.printStackTrace();
        }catch (JSONException e1){
            e1.printStackTrace();
        }
    }
    //反解析json
    private static void gsonParseJsonWithDate(){
        File file = new File(Diaosi.class.getResource("/json/wangxiaoer1.json").getFile());
        try {
            String content = FileUtils.readFileToString(file,"UTF-8");
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.setPrettyPrinting();
            Gson gson = gsonBuilder.setDateFormat("yyyy-MM-dd").create();
            DiaosiWithDate wangxiaoer = gson.fromJson(content,DiaosiWithDate.class);
            System.out.println(wangxiaoer.toString());

            System.out.println(wangxiaoer.getIphone().getClass());
            System.out.println(wangxiaoer.getIphone());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
