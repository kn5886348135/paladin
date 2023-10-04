package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.IntegrationChangeHistory;
import com.paladin.account.service.IIntegrationChangeHistoryService;
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
 * 积分消费设置 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/account/integration-consume-setting")
public class IntegrationConsumeSettingController {

	private static final Logger LOGGER = LoggerFactory.getLogger(IntegrationChangeHistoryController.class);

	private IIntegrationChangeHistoryService integrationChangeHistoryService;

	public IntegrationConsumeSettingController(IIntegrationChangeHistoryService integrationChangeHistoryService) {
		this.integrationChangeHistoryService = integrationChangeHistoryService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加积分变化历史记录", notes = "添加积分变化历史记录")
	public void addCarItem(@RequestBody IntegrationChangeHistory integrationChangeHistory) {
		integrationChangeHistoryService.save(integrationChangeHistory);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody IntegrationChangeHistory integrationChangeHistory) {
		integrationChangeHistoryService.removeById(integrationChangeHistory.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody IntegrationChangeHistory integrationChangeHistory) {
		integrationChangeHistoryService.updateById(integrationChangeHistory);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public IntegrationChangeHistory findAccount(@RequestBody IntegrationChangeHistory integrationChangeHistory) {
		return integrationChangeHistoryService.getById(integrationChangeHistory);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询积分变化历史记录", notes = "批量查询积分变化历史记录", responseContainer = "List", response = IntegrationChangeHistory.class)
	public List<IntegrationChangeHistory> findAccountList(@RequestBody IntegrationChangeHistory integrationChangeHistory) {
		return integrationChangeHistoryService.list(new QueryWrapper<>(integrationChangeHistory));
	}
}
