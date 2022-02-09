package com.paladin.account.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.AdminRoleRelation;
import com.paladin.account.resp.RespOk;
import com.paladin.account.service.IAdminRoleRelationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 后台用户和角色关系表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/admin/role/relation")
public class AdminRoleRelationController {

	public static final Logger LOGGER = LoggerFactory.getLogger(AdminRoleRelationController.class);

	@Resource
	private IAdminRoleRelationService adminRoleRelationService;

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({@ApiResponse(code = 200, message = "添加成功"), @ApiResponse(code = 400, message = "请求错误"),
			@ApiResponse(code = 403, message = "请求被拒绝"), @ApiResponse(code = 404, message = "请求路径不存在"),
			@ApiResponse(code = 500, message = "服务器内部错误")})
//    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加管理员角色关系", notes = "添加管理员角色关系", response = RespOk.class)
	public RespOk registerAdminRoleRelation(@RequestBody AdminRoleRelation adminRoleRelation) {

		boolean result = adminRoleRelationService.save(adminRoleRelation);
		return result ? new RespOk(200, "注册成功") : new RespOk(200, "注册失败");
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
			MediaType.APPLICATION_JSON_VALUE)
	public RespOk deleteAccount(@RequestBody AdminRoleRelation adminRoleRelation) {
		boolean result = adminRoleRelationService.removeById(adminRoleRelation.getId());
		return result ? new RespOk(200, "删除成功") : new RespOk(200, "删除失败");
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RespOk modifyAccount(@RequestBody AdminRoleRelation adminRoleRelation) {
		boolean result = adminRoleRelationService.updateById(adminRoleRelation);
		return result ? new RespOk(200, "修改成功") : new RespOk(200, "修改失败");
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RespOk findAccount(@RequestBody AdminRoleRelation adminRoleRelation) {
		AdminRoleRelation result = adminRoleRelationService.getById(adminRoleRelation);
		return new RespOk(200, "查询成功", result);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
			MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询管理员角色关系", notes = "批量查询管理员角色关系", responseContainer = "List", response = RespOk.class)
	public RespOk findAccountList(@RequestBody AdminRoleRelation adminRoleRelation) {
		List<AdminRoleRelation> accountList = adminRoleRelationService.list(new QueryWrapper<>(adminRoleRelation));
		return new RespOk(200, "查询成功", accountList);
	}
}
