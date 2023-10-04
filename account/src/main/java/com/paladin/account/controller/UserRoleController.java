package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.UserRole;
import com.paladin.account.service.IUserRoleService;
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
 * 用户角色关系表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/user/role")
public class UserRoleController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserRoleController.class);

	private IUserRoleService userRoleService;

	public UserRoleController(IUserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加用户角色", notes = "添加用户角色")
	public void addUserRole(@RequestBody UserRole userRole) {
		userRoleService.save(userRole);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody UserRole userRole) {
		userRoleService.removeById(userRole.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody UserRole userRole) {
		userRoleService.updateById(userRole);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserRole findAccount(@RequestBody UserRole userRole) {
		return userRoleService.getById(userRole);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询用户角色", notes = "批量查询用户角色", responseContainer = "List", response = UserRole.class)
	public List<UserRole> findAccountList(@RequestBody UserRole userRole) {
		return userRoleService.list(new QueryWrapper<>(userRole));
	}
}
