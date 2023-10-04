package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.Account;
import com.paladin.account.service.IAccountService;
import com.paladin.account.util.message.MessageEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
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

import java.security.NoSuchAlgorithmException;
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

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

	private IAccountService accountService;

	private MessageSource messageSource;

	public AccountController(IAccountService accountService, MessageSource messageSource) {
		this.accountService = accountService;
		this.messageSource = messageSource;
	}

	@PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({@ApiImplicitParam(name = "accountName", defaultValue = "", required = true),
			@ApiImplicitParam(name = "passwd", defaultValue = "", required = true)})
	@ApiOperation(value = "用户注册", notes = "用户注册", response = String.class)
	public String register(@Validated @RequestBody Account account) throws NoSuchAlgorithmException {
		return accountService.register(account);
	}

	@DeleteMapping(value = "/unRegist", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({@ApiImplicitParam(name = "accountId", defaultValue = "", required = true),
			@ApiImplicitParam(name = "phone", defaultValue = "", required = true)})
	@ApiOperation(value = "用户注销", notes = "用户注销", response = String.class)
	public String unRegist(@RequestBody Account account) {
		boolean result = accountService.removeById(account.getId());
		return result ? messageSource.getMessage(MessageEnum.UNREGISTER_SUCCESS.getKey(), null,
				LocaleContextHolder.getLocale()) : messageSource.getMessage(MessageEnum.UNREGISTER_FAILED.getKey(),
				null, LocaleContextHolder.getLocale());
	}

	@PutMapping(value = "/password", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({@ApiImplicitParam(name = "accountId", defaultValue = "", required = true),
			@ApiImplicitParam(name = "passwd", defaultValue = "", required = true)})
	@ApiOperation(value = "修改密码", notes = "修改密码", response = String.class)
	public String modifyAccount(@RequestBody Account account) {
		boolean result = accountService.updateById(account);
		return result ? messageSource.getMessage(MessageEnum.PASSWORD_MODIFY_SUCCESS.getKey(), null,
				LocaleContextHolder.getLocale()) :
				messageSource.getMessage(MessageEnum.PASSWORD_MODIFY_FAILED.getKey(), null,
						LocaleContextHolder.getLocale());
	}

	@PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({@ApiImplicitParam(name = "accountName", defaultValue = "", required = true),
			@ApiImplicitParam(name = "passwd", defaultValue = "", required = true)})
	@ApiOperation(value = "用户登录", notes = "用户登录", response = String.class)
	public String login(@RequestBody Account account) {
		String accountName = account.getAccountName();
		String passwd = account.getPasswd();
		return accountService.login(accountName, passwd);
	}

	@GetMapping(value = "/logout", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiImplicitParams({@ApiImplicitParam(name = "accountId", defaultValue = "", required = true)})
	@ApiOperation(value = "用户登出", notes = "用户登出", response = String.class)
	public String logout(@RequestParam String accountName, @RequestParam String passwd) {
		return accountService.logout(accountName, passwd);

	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
            MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询用户", notes = "批量查询用户", responseContainer = "List", response = Account.class)
	public List<Account> findAccountList(@RequestBody Account account) {
		return accountService.list(new QueryWrapper<>(account));
	}

	@ApiOperation("返回验证码")
	@ApiImplicitParams(@ApiImplicitParam(name = "username"))
	@GetMapping(value = "/code", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getVerifyCode(String username) {
		return accountService.getVerifyCode(username);
	}
}
