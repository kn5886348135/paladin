package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.Account;
import com.paladin.account.resp.RespOk;
import com.paladin.account.resp.RespResult;
import com.paladin.account.service.IAccountService;
import com.paladin.account.util.Constants;
import com.paladin.account.util.MD5Utils;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-08-31
 */
@Api(value = "用户账户接口", tags = "用户账户接口")
@RestController
@RequestMapping("/account")
@Validated
public class AccountController {

	public static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

	@Resource
	private IAccountService accountService;

	@PostMapping(value = "/regist", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({@ApiResponse(code = 200, message = "添加成功"), @ApiResponse(code = 400, message = "请求错误"),
			@ApiResponse(code = 403, message = "请求被拒绝"), @ApiResponse(code = 404, message = "请求路径不存在"),
			@ApiResponse(code = 500, message = "服务器内部错误")})
	@ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加用户", notes = "添加用户", response = RespOk.class)
	public RespOk register(@Validated @RequestBody Account account) {
		boolean result = accountService.save(account);
		return result ? new RespOk(200, "注册成功") : new RespOk(200, "注册失败");
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
            MediaType.APPLICATION_JSON_VALUE)
	public RespOk unRegist(@RequestBody Account account) {
		boolean result = accountService.removeById(account.getId());
		return result ? new RespOk(200, "注销成功") : new RespOk(200, "注销失败");
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RespOk modifyAccount(@RequestBody Account account) {
		boolean result = accountService.updateById(account);
		return result ? new RespOk(200, "修改成功") : new RespOk(200, "修改失败");
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public RespOk login(@RequestParam String accountName, @RequestParam String password) {
		boolean result = accountService.login(accountName, password);
		if (result) {
			return new RespOk(200, "查询成功", result);
		}else {
			RespResult res = new RespResult();
			res.buildUnAuthorized(401, "用户名或者密码不存在", "");
			return null;
		}
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
            MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询用户", notes = "批量查询用户", responseContainer = "List", response = RespOk.class)
	public RespOk findAccountList(@RequestBody Account account) {
		List<Account> accountList = accountService.list(new QueryWrapper<>(account));
		return new RespOk(200, "查询成功", accountList);
	}

	public static void main(String[] args) {
		System.out.println(MD5Utils.md5Sign("ashdfs"+ Constants.salt));
	}
}
