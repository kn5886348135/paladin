package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.AdminPermissionRelation;
import com.paladin.account.service.IAdminPermissionRelationService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminPermissionRelationController.class);

	private IAdminPermissionRelationService adminPermissionRelationService;

	public AdminPermissionRelationController(IAdminPermissionRelationService adminPermissionRelationService) {
		this.adminPermissionRelationService = adminPermissionRelationService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加管理员权限关系", notes = "添加管理员权限关系")
	public void raddAdminPermissionRelation(@RequestBody AdminPermissionRelation adminPermissionRelation) {
		adminPermissionRelationService.save(adminPermissionRelation);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody AdminPermissionRelation adminPermissionRelation) {
		adminPermissionRelationService.removeById(adminPermissionRelation.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody AdminPermissionRelation adminPermissionRelation) {
		adminPermissionRelationService.updateById(adminPermissionRelation);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AdminPermissionRelation findAccount(@RequestBody AdminPermissionRelation adminPermissionRelation) {
		return adminPermissionRelationService.getById(adminPermissionRelation);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询管理员权限关系", notes = "批量查询管理员权限关系", responseContainer = "List", response = AdminPermissionRelation.class)
	public List<AdminPermissionRelation> findAccountList(@RequestBody AdminPermissionRelation adminPermissionRelation) {
		return adminPermissionRelationService.list(new QueryWrapper<>(adminPermissionRelation));
	}
}
