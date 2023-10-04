package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.RolePermissionRelation;
import com.paladin.account.service.IRolePermissionRelationService;
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
 * 后台用户角色和权限关系表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/role/permission/relation")
public class RolePermissionRelationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RolePermissionRelationController.class);

	private IRolePermissionRelationService rolePermissionRelationService;

	public RolePermissionRelationController(IRolePermissionRelationService rolePermissionRelationService) {
		this.rolePermissionRelationService = rolePermissionRelationService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加角色权限关系", notes = "添加角色权限关系")
	public void addCarItem(@RequestBody RolePermissionRelation rolePermissionRelation) {
		rolePermissionRelationService.save(rolePermissionRelation);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody RolePermissionRelation rolePermissionRelation) {
		rolePermissionRelationService.removeById(rolePermissionRelation.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody RolePermissionRelation rolePermissionRelation) {
		rolePermissionRelationService.updateById(rolePermissionRelation);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RolePermissionRelation findAccount(@RequestBody RolePermissionRelation rolePermissionRelation) {
		return rolePermissionRelationService.getById(rolePermissionRelation);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询角色权限关系", notes = "批量查询角色权限关系", responseContainer = "List", response = RolePermissionRelation.class)
	public List<RolePermissionRelation> findAccountList(@RequestBody RolePermissionRelation rolePermissionRelation) {
		return rolePermissionRelationService.list(new QueryWrapper<>(rolePermissionRelation));
	}
}
