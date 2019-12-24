package com.example.demo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
@Data
@Slf4j
@ApiModel(value = "响应数据",description = "响应信息")
public class Response<T> {

    private Integer code;

    private String msg;
  
    private  T data;
    
}
