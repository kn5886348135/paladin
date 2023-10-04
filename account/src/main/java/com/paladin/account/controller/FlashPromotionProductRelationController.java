package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.FlashPromotionProductRelation;
import com.paladin.account.service.IFlashPromotionProductRelationService;
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
 * 商品限时购与商品关系表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/account/flash-promotion-product-relation")
public class FlashPromotionProductRelationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FlashPromotionProductRelationController.class);

	private IFlashPromotionProductRelationService flashPromotionProductRelationService;

	public FlashPromotionProductRelationController(IFlashPromotionProductRelationService flashPromotionProductRelationService) {
		this.flashPromotionProductRelationService = flashPromotionProductRelationService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加限时促销产品关系", notes = "添加限时促销产品关系")
	public void addCarItem(@RequestBody FlashPromotionProductRelation flashPromotionProductRelation) {
		flashPromotionProductRelationService.save(flashPromotionProductRelation);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
			MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody FlashPromotionProductRelation flashPromotionProductRelation) {
		flashPromotionProductRelationService.removeById(flashPromotionProductRelation.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody FlashPromotionProductRelation flashPromotionProductRelation) {
		flashPromotionProductRelationService.updateById(flashPromotionProductRelation);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public FlashPromotionProductRelation findAccount(@RequestBody FlashPromotionProductRelation flashPromotionProductRelation) {
		return flashPromotionProductRelationService.getById(flashPromotionProductRelation);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
			MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询限时促销产品关系", notes = "批量查询限时促销产品关系", responseContainer = "List")
	public List<FlashPromotionProductRelation> findAccountList(@RequestBody FlashPromotionProductRelation flashPromotionProductRelation) {
		return flashPromotionProductRelationService.list(new QueryWrapper<>(flashPromotionProductRelation));
	}

}
