package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.FlashPromotion;
import com.paladin.account.service.IFlashPromotionService;
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
 * 限时购表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/flash/promotion")
public class FlashPromotionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FlashPromotionController.class);

	private IFlashPromotionService flashPromotionService;

	public FlashPromotionController(IFlashPromotionService flashPromotionService) {
		this.flashPromotionService = flashPromotionService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加限时促销", notes = "添加限时促销")
	public void addCarItem(@RequestBody FlashPromotion flashPromotion) {
		flashPromotionService.save(flashPromotion);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody FlashPromotion flashPromotion) {
		flashPromotionService.removeById(flashPromotion.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody FlashPromotion flashPromotion) {
		flashPromotionService.updateById(flashPromotion);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public FlashPromotion findAccount(@RequestBody FlashPromotion flashPromotion) {
		return flashPromotionService.getById(flashPromotion);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询限时促销", notes = "批量查询限时促销", responseContainer = "List", response = FlashPromotion.class)
	public List<FlashPromotion> findAccountList(@RequestBody FlashPromotion flashPromotion) {
		return flashPromotionService.list(new QueryWrapper<>(flashPromotion));
	}

}
