package com.paladin.account.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.AdminPermissionRelation;
import com.paladin.account.resp.RespOk;
import com.paladin.account.service.IAdminPermissionRelationService;
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
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限) 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/admin/permission/relation")
public class AdminPermissionRelationController {

    public static final Logger LOGGER = LoggerFactory.getLogger(AdminPermissionRelationController.class);

    @Resource
    private IAdminPermissionRelationService adminPermissionRelationService;

    @PostMapping(value = "/", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({@ApiResponse(code = 200, message = "添加成功"), @ApiResponse(code = 400, message = "请求错误"),
            @ApiResponse(code = 403, message = "请求被拒绝"), @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")})
//    @ApiImplicitParams({@ApiImplicitParam})
    @ApiOperation(value = "添加管理员权限关系", notes = "添加管理员权限关系", response = RespOk.class)
    public RespOk raddAdminPermissionRelation(@RequestBody AdminPermissionRelation adminPermissionRelation) {

        boolean result = adminPermissionRelationService.save(adminPermissionRelation);
        return result ? new RespOk(200, "注册成功") : new RespOk(200, "注册失败");
    }

    @DeleteMapping(value = "/", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RespOk deleteAccount(@RequestBody AdminPermissionRelation adminPermissionRelation) {
        boolean result = adminPermissionRelationService.removeById(adminPermissionRelation.getId());
        return result ? new RespOk(200, "删除成功") : new RespOk(200, "删除失败");
    }

    @PutMapping(value = "/", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RespOk modifyAccount(@RequestBody AdminPermissionRelation adminPermissionRelation) {
        boolean result = adminPermissionRelationService.updateById(adminPermissionRelation);
        return result ? new RespOk(200, "修改成功") : new RespOk(200, "修改失败");
    }

    @GetMapping(value = "/", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RespOk findAccount(@RequestBody AdminPermissionRelation adminPermissionRelation) {
        AdminPermissionRelation result = adminPermissionRelationService.getById(adminPermissionRelation);
        return new RespOk(200, "查询成功", result);
    }

    @GetMapping(value = "/list", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "批量查询管理员权限关系", notes = "批量查询管理员权限关系", responseContainer = "List", response = RespOk.class)
    public RespOk findAccountList(@RequestBody AdminPermissionRelation adminPermissionRelation) {
        List<AdminPermissionRelation> accountList = adminPermissionRelationService.list(new QueryWrapper<>(adminPermissionRelation));
        return new RespOk(200, "查询成功", accountList);
    }
}