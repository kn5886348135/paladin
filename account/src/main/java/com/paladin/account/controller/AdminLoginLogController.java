package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.AdminLoginLog;
import com.paladin.account.service.IAdminLoginLogService;
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
 * 后台用户登录日志表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/admin/login/log")
public class AdminLoginLogController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminLoginLogController.class);

	private IAdminLoginLogService adminLoginLogService;

	public AdminLoginLogController(IAdminLoginLogService adminLoginLogService) {
		this.adminLoginLogService = adminLoginLogService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加管理员登录日志", notes = "添加管理员登录日志")
	public void registerAdminLoginLog(@RequestBody AdminLoginLog adminLoginLog) {
		adminLoginLogService.save(adminLoginLog);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody AdminLoginLog adminLoginLog) {
		adminLoginLogService.removeById(adminLoginLog.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody AdminLoginLog adminLoginLog) {
		adminLoginLogService.updateById(adminLoginLog);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AdminLoginLog findAccount(@RequestBody AdminLoginLog adminLoginLog) {
		return adminLoginLogService.getById(adminLoginLog);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询管理员登录日志", notes = "批量查询管理员登录日志", responseContainer = "List", response = AdminLoginLog.class)
	public List<AdminLoginLog> findAccountList(@RequestBody AdminLoginLog adminLoginLog) {
		return adminLoginLogService.list(new QueryWrapper<>(adminLoginLog));
	}
}
