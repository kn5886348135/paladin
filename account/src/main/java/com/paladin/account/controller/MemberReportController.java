package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.MemberReport;
import com.paladin.account.service.IMemberReportService;
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
 * 用户举报表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/account/member-report")
public class MemberReportController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MemberReportController.class);

	private IMemberReportService memberReportService;

	public MemberReportController(IMemberReportService memberReportService) {
		this.memberReportService = memberReportService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加用户举报", notes = "添加用户举报")
	public void addMemberReport(@RequestBody MemberReport memberReport) {
		memberReportService.save(memberReport);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody MemberReport memberReport) {
		memberReportService.removeById(memberReport.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody MemberReport memberReport) {
		memberReportService.updateById(memberReport);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public MemberReport findAccount(@RequestBody MemberReport memberReport) {
		return memberReportService.getById(memberReport);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询用户举报", notes = "批量查询用户举报", responseContainer = "List", response = MemberReport.class)
	public List<MemberReport> findAccountList(@RequestBody MemberReport memberReport) {
		return memberReportService.list(new QueryWrapper<>(memberReport));
	}
}
