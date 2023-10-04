package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.FlashPromotionLog;
import com.paladin.account.service.IFlashPromotionLogService;
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
 * 限时购通知记录 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/flash/promotion/log")
public class FlashPromotionLogController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FlashPromotionLogController.class);

	private IFlashPromotionLogService flashPromotionLogService;

	public FlashPromotionLogController(IFlashPromotionLogService flashPromotionLogService) {
		this.flashPromotionLogService = flashPromotionLogService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加限时促销日志", notes = "添加限时促销日志")
	public void addCarItem(@RequestBody FlashPromotionLog flashPromotionLog) {
		flashPromotionLogService.save(flashPromotionLog);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody FlashPromotionLog flashPromotionLog) {
		flashPromotionLogService.removeById(flashPromotionLog.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody FlashPromotionLog flashPromotionLog) {
		flashPromotionLogService.updateById(flashPromotionLog);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public FlashPromotionLog findAccount(@RequestBody FlashPromotionLog flashPromotionLog) {
		return flashPromotionLogService.getById(flashPromotionLog);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询限时促销日志", notes = "批量查询限时促销日志", responseContainer = "List", response = FlashPromotionLog.class)
	public List<FlashPromotionLog> findAccountList(@RequestBody FlashPromotionLog flashPromotionLog) {
		return flashPromotionLogService.list(new QueryWrapper<>(flashPromotionLog));
	}

}
