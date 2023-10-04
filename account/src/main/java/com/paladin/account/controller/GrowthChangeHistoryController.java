package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.GrowthChangeHistory;
import com.paladin.account.service.IGrowthChangeHistoryService;
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
 * 成长值变化历史记录表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/growth/change/history")
public class GrowthChangeHistoryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(GrowthChangeHistoryController.class);

	private IGrowthChangeHistoryService growthChangeHistoryService;

	public GrowthChangeHistoryController(IGrowthChangeHistoryService growthChangeHistoryService) {
		this.growthChangeHistoryService = growthChangeHistoryService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加成长值变化历史记录", notes = "添加成长值变化历史记录")
	public void addCarItem(@RequestBody GrowthChangeHistory growthChangeHistory) {
		boolean result = growthChangeHistoryService.save(growthChangeHistory);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody GrowthChangeHistory growthChangeHistory) {
		growthChangeHistoryService.removeById(growthChangeHistory.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody GrowthChangeHistory growthChangeHistory) {
		growthChangeHistoryService.updateById(growthChangeHistory);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public GrowthChangeHistory findAccount(@RequestBody GrowthChangeHistory growthChangeHistory) {
		return growthChangeHistoryService.getById(growthChangeHistory);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询成长值变化历史记录", notes = "批量查询成长值变化历史记录", responseContainer = "List", response = GrowthChangeHistory.class)
	public List<GrowthChangeHistory> findAccountList(@RequestBody GrowthChangeHistory growthChangeHistory) {
		return growthChangeHistoryService.list(new QueryWrapper<>(growthChangeHistory));
	}

}
