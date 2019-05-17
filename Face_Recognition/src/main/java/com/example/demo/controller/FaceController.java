package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.Face_Detect;
import com.example.demo.Service.Face_Search;
import com.example.demo.Util.GsonUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
@RestController
@RequestMapping("/Face")
public class FaceController {

	@RequestMapping("/FaceSear")
    public String FaceSear(String path){
    Map<String,Object> map=new HashMap<String,Object>();
 
        try {
             
            JsonParser parser=new JsonParser();  //创建JSON解析器
            JsonObject object=(JsonObject) parser.parse(Face_Search.search(path));  //创建JsonObject对象
//            System.out.println("cat="+object.get("error_code").getAsString()); //将json数据转为为String型的数据
//            System.out.println("pop="+object.get("error_msg").getAsString()); //将json数据转为为boolean型的数据
//         
            String error_code=object.get("error_code").getAsString();
            if(!error_code.equals("0")) {
            	return "未匹配到人物,错误信息："+object.get("error_msg").getAsString();
            }
            JsonObject ob2=object.get("result").getAsJsonObject();    //得到为json的数组
            JsonArray user_ob=ob2.get("user_list").getAsJsonArray();
           
            for(int i=0;i<user_ob.size();i++){
//            	JsonObject array2=array.get(i).getAsJsonObject();    //得到为json的数组
////                System.out.println("---------------");
//                JsonObject subObject=array.get(i).getAsJsonObject();
            	JsonObject subOb=user_ob.get(i).getAsJsonObject();
            	map.put("group_id",subOb.get("group_id").getAsString());
            	map.put("user_id",subOb.get("user_id").getAsString());
            	map.put("user_info",subOb.get("user_info").getAsString());
            	Double score=subOb.get("score").getAsDouble();
            	map.put("score",score);
            	if(score<50) {
            		map.put("warn", "Not accuracy");//如果不准确，输出
            	}
            	String param=GsonUtils.toJson(map);
//            	System.out.println(param);
            	return param;
//                System.out.println("group_id="+subOb.get("group_id").getAsString());
//                System.out.println("user_id="+subOb.get("user_id").getAsString());
//                System.out.println("user_info="+subOb.get("user_info").getAsString());
//                System.out.println("score="+subOb.get("score").getAsString());
            }
             
        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
		return "程序bug"; 
    }
	
	
	
	@RequestMapping("/FaceDet")
    public String FaceDet(String path){
//    Map<String,Object> map=new HashMap<String,Object>();
	String json=Face_Detect.detect(path);
	return json;
	
	}
}