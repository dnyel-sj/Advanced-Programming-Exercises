package com.kiau;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/save")
public class Employees {
    @Path("/emp")
    @GET
    @Produces("text/plain")
    public String emp()
    {
        System.out.println("save executed in server");
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("name","mahdi");
        jsonObject1.put("family","khosravani");

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("name","ali");
        jsonObject2.put("family","bahrami");

        JSONObject jsonObject3 = new JSONObject();
        jsonObject3.put("name","reza");
        jsonObject3.put("family","karimi");

        JSONObject jsonObject4 = new JSONObject();
        jsonObject4.put("name","ahmad");
        jsonObject4.put("family","yavari");

        JSONObject jsonObject5 = new JSONObject();
        jsonObject5.put("name","mohammad");
        jsonObject5.put("family","bagheri");

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject1);
        jsonArray.add(jsonObject2);
        jsonArray.add(jsonObject3);
        jsonArray.add(jsonObject4);
        jsonArray.add(jsonObject5);

        return jsonArray.toJSONString();
    }
}