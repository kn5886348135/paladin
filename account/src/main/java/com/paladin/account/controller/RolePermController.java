package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.RolePerm;
import com.paladin.account.service.IRolePermService;
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
 * 角色权限表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/role/perm")
public class RolePermController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RolePermController.class);

	private IRolePermService rolePermService;

	public RolePermController(IRolePermService rolePermService) {
		this.rolePermService = rolePermService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加角色权限", notes = "添加角色权限")
	public void addRolePerm(@RequestBody RolePerm rolePerm) {
		rolePermService.save(rolePerm);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody RolePerm rolePerm) {
		rolePermService.removeById(rolePerm.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody RolePerm rolePerm) {
		rolePermService.updateById(rolePerm);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RolePerm findAccount(@RequestBody RolePerm rolePerm) {
		return rolePermService.getById(rolePerm);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询角色权限", notes = "批量查询角色权限", responseContainer = "List", response = RolePerm.class)
	public List<RolePerm> findAccountList(@RequestBody RolePerm rolePerm) {
		return rolePermService.list(new QueryWrapper<>(rolePerm));
	}
}
