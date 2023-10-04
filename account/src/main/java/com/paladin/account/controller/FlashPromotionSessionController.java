package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.FlashPromotionSession;
import com.paladin.account.service.IFlashPromotionSessionService;
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
 * 限时购场次表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/flash/promotion/session")
public class FlashPromotionSessionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FlashPromotionSessionController.class);

	private IFlashPromotionSessionService flashPromotionSessionService;

	public FlashPromotionSessionController(IFlashPromotionSessionService flashPromotionSessionService) {
		this.flashPromotionSessionService = flashPromotionSessionService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加限时购场次", notes = "添加限时购场次")
	public void addCarItem(@RequestBody FlashPromotionSession flashPromotionSession) {
		flashPromotionSessionService.save(flashPromotionSession);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody FlashPromotionSession flashPromotionSession) {
		flashPromotionSessionService.removeById(flashPromotionSession.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody FlashPromotionSession flashPromotionSession) {
		flashPromotionSessionService.updateById(flashPromotionSession);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public FlashPromotionSession findAccount(@RequestBody FlashPromotionSession flashPromotionSession) {
		return flashPromotionSessionService.getById(flashPromotionSession);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询限时购场次", notes = "批量查询限时购场次", responseContainer = "List", response = FlashPromotionSession.class)
	public List<FlashPromotionSession> findAccountList(@RequestBody FlashPromotionSession flashPromotionSession) {
		return flashPromotionSessionService.list(new QueryWrapper<>(flashPromotionSession));
	}

}
