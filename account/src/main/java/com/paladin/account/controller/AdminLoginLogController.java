package com.paladin.account.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.AdminLoginLog;
import com.paladin.account.resp.RespOk;
import com.paladin.account.service.IAdminLoginLogService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 后台用户登录日志表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/admin/login/log")
public class AdminLoginLogController {

    public static final Logger LOGGER = LoggerFactory.getLogger(AdminLoginLogController.class);

    @Resource
    private IAdminLoginLogService adminLoginLogService;

    @PostMapping(value = "/", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({@ApiResponse(code = 200, message = "添加成功"), @ApiResponse(code = 400, message = "请求错误"),
            @ApiResponse(code = 403, message = "请求被拒绝"), @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")})
//    @ApiImplicitParams({@ApiImplicitParam})
    @ApiOperation(value = "添加管理员登录日志", notes = "添加管理员登录日志", response = RespOk.class)
    public RespOk registerAdminLoginLog(@RequestBody AdminLoginLog adminLoginLog) {

        boolean result = adminLoginLogService.save(adminLoginLog);
        return result ? new RespOk(200, "注册成功") : new RespOk(200, "注册失败");
    }

    @DeleteMapping(value = "/", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RespOk deleteAccount(@RequestBody AdminLoginLog adminLoginLog) {
        boolean result = adminLoginLogService.removeById(adminLoginLog.getId());
        return result ? new RespOk(200, "删除成功") : new RespOk(200, "删除失败");
    }

    @PutMapping(value = "/", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RespOk modifyAccount(@RequestBody AdminLoginLog adminLoginLog) {
        boolean result = adminLoginLogService.updateById(adminLoginLog);
        return result ? new RespOk(200, "修改成功") : new RespOk(200, "修改失败");
    }

    @GetMapping(value = "/", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RespOk findAccount(@RequestBody AdminLoginLog adminLoginLog) {
        AdminLoginLog result = adminLoginLogService.getById(adminLoginLog);
        return new RespOk(200, "查询成功", result);
    }

    @GetMapping(value = "/list", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "批量查询管理员登录日志", notes = "批量查询管理员登录日志", responseContainer = "List", response = RespOk.class)
    public RespOk findAccountList(@RequestBody AdminLoginLog adminLoginLog) {
        List<AdminLoginLog> accountList = adminLoginLogService.list(new QueryWrapper<>(adminLoginLog));
        return new RespOk(200, "查询成功", accountList);
    }

}
