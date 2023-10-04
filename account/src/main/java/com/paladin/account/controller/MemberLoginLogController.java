package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.MemberLoginLog;
import com.paladin.account.service.IMemberLoginLogService;
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
 * 会员登录记录 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/member/login/log")
public class MemberLoginLogController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MemberLoginLogController.class);

	private IMemberLoginLogService memberLoginLogService;

	public MemberLoginLogController(IMemberLoginLogService memberLoginLogService) {
		this.memberLoginLogService = memberLoginLogService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加会员登录日志", notes = "添加会员登录日志")
	public void addCarItem(@RequestBody MemberLoginLog memberLoginLog) {
		memberLoginLogService.save(memberLoginLog);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody MemberLoginLog memberLoginLog) {
		memberLoginLogService.removeById(memberLoginLog.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody MemberLoginLog memberLoginLog) {
		memberLoginLogService.updateById(memberLoginLog);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public MemberLoginLog findAccount(@RequestBody MemberLoginLog memberLoginLog) {
		return memberLoginLogService.getById(memberLoginLog);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询会员登录日志", notes = "批量查询会员登录日志", responseContainer = "List", response = MemberLoginLog.class)
	public List<MemberLoginLog> findAccountList(@RequestBody MemberLoginLog memberLoginLog) {
		return memberLoginLogService.list(new QueryWrapper<>(memberLoginLog));
	}

}
