package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.SysRole;
import com.paladin.account.service.ISysRoleService;
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
 * 角色表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/sys/role")
public class SysRoleController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SysRoleController.class);

	private ISysRoleService sysRoleService;

	public SysRoleController(ISysRoleService sysRoleService) {
		this.sysRoleService = sysRoleService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加系统角色", notes = "添加系统角色")
	public void addSysRole(@RequestBody SysRole sysRole) {
		sysRoleService.save(sysRole);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody SysRole sysRole) {
		sysRoleService.removeById(sysRole.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody SysRole sysRole) {
		sysRoleService.updateById(sysRole);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SysRole findAccount(@RequestBody SysRole sysRole) {
		return sysRoleService.getById(sysRole);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询系统角色", notes = "批量查询系统角色", responseContainer = "List", response = SysRole.class)
	public List<SysRole> findAccountList(@RequestBody SysRole sysRole) {
		return sysRoleService.list(new QueryWrapper<>(sysRole));
	}
}
