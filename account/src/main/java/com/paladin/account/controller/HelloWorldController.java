package com.paladin.account.controller;

import com.paladin.account.entity.Student;
import com.paladin.account.resp.MessageCode;
import com.paladin.account.resp.RespOk;
import com.paladin.account.resp.RespResult;
import com.paladin.account.vo.StudentVO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 *  @author: paladin
 *  @Description:
 *  @date: created in 2020/8/25 21:06
 */
@RestController
@RequestMapping("/test")
public class HelloWorldController {

    @GetMapping(value = "/str", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String helloStr(String str) {
        return "hello " + str;
    }

    @GetMapping(value = "/hello", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> helloWorld(String str) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("ContentType", "application/json");

        return new ResponseEntity<>("hello " + str, headers, HttpStatus.FORBIDDEN);
    }

    @GetMapping(value = "/world", produces = {MediaType.APPLICATION_JSON_VALUE})
    public RespOk test() {
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Student student = new Student();
            student.setName("乔峰" + i);
            student.setAge(25 + i);
            student.setAdd("宝能科技园" + i + "号");
            studentList.add(student);
        }
        new RespResult().buildBadRequest(MessageCode.AUTHENCATION_FAILURE.code, MessageCode.AUTHENCATION_FAILURE.msg,
                studentList);
//        return new RespOK("这是一个失败的请求");
        return null;
    }

    @PostMapping("/swagger")
//    @ApiOperation(value = "测试knife4j功能")
//    @DynamicResponseParameters(name = "student", properties = {
//            @DynamicParameter(name = "", value = "名字", example = "张三", required = true, dataTypeClass = String.class),
//            @DynamicParameter(name = "age", value = "年龄"),
//            @DynamicParameter(name = "age", value = "年龄")
//    })
    public RespOk testSwagger(@RequestBody StudentVO studentVO) {

        return new RespOk("请求成功");
    }
}
