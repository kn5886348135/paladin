package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.Admin;
import com.paladin.account.service.IAdminService;
import com.paladin.account.util.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-08-31
 */

@Api(value = "管理员账户接口", tags = "管理员账户接口")
@RestController
@RequestMapping("/admin")
@Validated
public class AdminController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

	private IAdminService adminService;

	public AdminController(IAdminService adminService) {
		this.adminService = adminService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加管理员", notes = "添加管理员")
	public void registerAdmin(@RequestBody Admin admin) {
		String passwd = admin.getPasswd();
		passwd = MD5Utils.md5Sign(passwd);
		admin.setPasswd(passwd);
		// 密码加密
		adminService.save(admin);
	}

	public void adminLogin(@RequestParam("username") String username, @RequestParam("passwd") String passwd) {

		passwd = MD5Utils.md5Sign(passwd);

		// 密码加密
		adminService.adminLogin(username, passwd);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAdmin(@RequestBody Admin admin) {
		adminService.removeById(admin.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAdmin(@RequestBody Admin admin) {
		adminService.updateById(admin);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Admin findAdmin(@RequestBody Admin admin) {
		return adminService.getById(admin);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询管理员", notes = "批量查询管理员", responseContainer = "List", response = void.class)
	public List<Admin> findAdminList(@RequestBody Admin admin) {
		return adminService.list(new QueryWrapper<>(admin));
	}
}
