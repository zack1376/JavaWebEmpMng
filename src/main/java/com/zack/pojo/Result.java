package com.zack.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Integer code; //0失败，1成功
    private String msg;  //响应信息
    private Object data;  //响应数据

    //成功响应，无数据返回
    public static Result success(){
        return new Result(1, "success", null);
    }

    //成功响应，返回数据
    public static Result success(Object data){
        return new Result(1, "success", data);
    }

    //失败响应，返回信息
    public static Result error(String msg){
        return new Result(0, msg, null);
    }
}
