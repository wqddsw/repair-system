package com.gzu.repairsystem.common;


import lombok.Data;

@Data
public class Result<T> {
    private Integer code;           //状态码
    private String message;         //响应信息
    private T data;                 //相应数据

    /**
     * 构造一个"成功"的返回结果，并携带数据
     *
     * @param data 要返回给前端的数据（可以是 User、List 等任意类型）
     * @return code=200、message="成功"、data=传入数据的 Result 对象
     */
    public static <T> Result<T> success(T data){
        Result<T> r = new Result<>();
        r.setCode(200);
        r.setMessage("成功");
        r.setData(data);
        return r;
    }

    /**
     * 构造一个"成功"但没有数据的返回结果（用于删除、修改等无需返回数据的操作）
     * <p>内部转调 success(null)，复用上面的逻辑
     *
     * @return code=200、data 为空的 Result 对象
     */
    public static <T> Result<T> success(){
        return success(null);
    }

    /**
     * 构造一个"失败"的返回结果
     *
     * @param message 失败原因，如 "用户名不存在"、"密码错误"，前端会展示给用户
     * @return code=500、message=失败原因、data 为空的 Result 对象
     */
    public static <T> Result<T> error(String message){
        Result<T> r = new Result<>();
        r.setCode(500);
        r.setMessage(message);
        return r;
    }
}
