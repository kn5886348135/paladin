package com.paladin.account.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.RolePerm;
import com.paladin.account.resp.RespOk;
import com.paladin.account.service.IRolePermService;
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
 * 角色权限表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/role/perm")
public class RolePermController {

    public static final Logger LOGGER = LoggerFactory.getLogger(RolePermController.class);

    @Resource
    private IRolePermService rolePermService;

    @PostMapping(value = "/", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({@ApiResponse(code = 200, message = "添加成功"), @ApiResponse(code = 400, message = "请求错误"),
            @ApiResponse(code = 403, message = "请求被拒绝"), @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")})
//    @ApiImplicitParams({@ApiImplicitParam})
    @ApiOperation(value = "添加角色权限", notes = "添加角色权限", response = RespOk.class)
    public RespOk addRolePerm(@RequestBody RolePerm rolePerm) {
        boolean result = rolePermService.save(rolePerm);
        return result ? new RespOk(200, "添加成功") : new RespOk(200, "添加失败");
    }

    @DeleteMapping(value = "/", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RespOk deleteAccount(@RequestBody RolePerm rolePerm) {
        boolean result = rolePermService.removeById(rolePerm.getId());
        return result ? new RespOk(200, "删除成功") : new RespOk(200, "删除失败");
    }

    @PutMapping(value = "/", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RespOk modifyAccount(@RequestBody RolePerm rolePerm) {
        boolean result = rolePermService.updateById(rolePerm);
        return result ? new RespOk(200, "修改成功") : new RespOk(200, "修改失败");
    }

    @GetMapping(value = "/", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RespOk findAccount(@RequestBody RolePerm rolePerm) {
        RolePerm result = rolePermService.getById(rolePerm);
        return new RespOk(200, "查询成功", result);
    }

    @GetMapping(value = "/list", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "批量查询角色权限", notes = "批量查询角色权限", responseContainer = "List", response = RespOk.class)
    public RespOk findAccountList(@RequestBody RolePerm rolePerm) {
        List<RolePerm> rolePermList = rolePermService.list(new QueryWrapper<>(rolePerm));
        return new RespOk(200, "查询成功", rolePermList);
    }
}
