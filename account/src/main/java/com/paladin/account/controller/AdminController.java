package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.Admin;
import com.paladin.account.resp.RespOk;
import com.paladin.account.service.IAdminService;
import com.paladin.account.util.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

	public static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

	private IAdminService adminService;

	public AdminController(IAdminService adminService) {
		this.adminService = adminService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({@ApiResponse(code = 200, message = "添加成功"), @ApiResponse(code = 400, message = "请求错误"),
			@ApiResponse(code = 403, message = "请求被拒绝"), @ApiResponse(code = 404, message = "请求路径不存在"),
			@ApiResponse(code = 500, message = "服务器内部错误")})
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加管理员", notes = "添加管理员", response = RespOk.class)
	public RespOk registerAdmin(@RequestBody Admin admin) {
		String passwd = admin.getPasswd();
		passwd = MD5Utils.md5Sign(passwd);
		admin.setPasswd(passwd);
		// 密码加密
		boolean result = adminService.save(admin);
		return result ? new RespOk(200, "注册成功") : new RespOk(200, "注册失败");
	}

	public RespOk adminLogin(@RequestParam("username") String username, @RequestParam("passwd") String passwd) {

		passwd = MD5Utils.md5Sign(passwd);

		// 密码加密
		boolean result = adminService.adminLogin(username, passwd);
		return result ? new RespOk(200, "登录成功") : new RespOk(200, "登录失败");
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
			MediaType.APPLICATION_JSON_VALUE)
	public RespOk deleteAdmin(@RequestBody Admin admin) {
		boolean result = adminService.removeById(admin.getId());
		return result ? new RespOk(200, "删除成功") : new RespOk(200, "删除失败");
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RespOk modifyAdmin(@RequestBody Admin admin) {
		boolean result = adminService.updateById(admin);
		return result ? new RespOk(200, "修改成功") : new RespOk(200, "修改失败");
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RespOk findAdmin(@RequestBody Admin admin) {
		Admin result = adminService.getById(admin);
		return new RespOk(200, "查询成功", result);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
			MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询管理员", notes = "批量查询管理员", responseContainer = "List", response = RespOk.class)
	public RespOk findAdminList(@RequestBody Admin admin) {
		List<Admin> accountList = adminService.list(new QueryWrapper<>(admin));
		return new RespOk(200, "查询成功", accountList);
	}
}
