package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.MemberTask;
import com.paladin.account.service.IMemberTaskService;
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
 * 会员任务表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/member/task")
public class MemberTaskController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MemberTaskController.class);

	private IMemberTaskService memberTaskService;

	public MemberTaskController(IMemberTaskService memberTaskService) {
		this.memberTaskService = memberTaskService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加会员任务", notes = "添加会员任务")
	public void addCarItem(@RequestBody MemberTask memberTask) {
		memberTaskService.save(memberTask);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody MemberTask memberTask) {
		memberTaskService.removeById(memberTask.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody MemberTask memberTask) {
		memberTaskService.updateById(memberTask);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public MemberTask findAccount(@RequestBody MemberTask memberTask) {
		return memberTaskService.getById(memberTask);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
			MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询会员任务", notes = "批量查询会员任务", responseContainer = "List", response = void.class)
	public List<MemberTask> findAccountList(@RequestBody MemberTask memberTask) {
		return memberTaskService.list(new QueryWrapper<>(memberTask));
	}
}
