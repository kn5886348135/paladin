package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.SysPerm;
import com.paladin.account.service.ISysPermService;
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
 * 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/sys/perm")
public class SysPermController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SysPermController.class);

	private ISysPermService sysPermService;

	public SysPermController(ISysPermService sysPermService) {
		this.sysPermService = sysPermService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加系统权限", notes = "添加系统权限")
	public void addSysPerm(@RequestBody SysPerm sysPerm) {
		sysPermService.save(sysPerm);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody SysPerm sysPerm) {
		sysPermService.removeById(sysPerm.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody SysPerm sysPerm) {
		sysPermService.updateById(sysPerm);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SysPerm findAccount(@RequestBody SysPerm sysPerm) {
		return sysPermService.getById(sysPerm);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询系统权限", notes = "批量查询系统权限", responseContainer = "List", response = SysPerm.class)
	public List<SysPerm> findAccountList(@RequestBody SysPerm sysPerm) {
		return sysPermService.list(new QueryWrapper<>(sysPerm));
	}
}
