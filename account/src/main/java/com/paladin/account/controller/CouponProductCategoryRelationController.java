package com.paladin.account.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.CouponProductCategoryRelation;
import com.paladin.account.resp.RespOk;
import com.paladin.account.service.ICouponProductCategoryRelationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 优惠券和产品分类关系表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/coupon/product/category/relation")
public class CouponProductCategoryRelationController {

	public static final Logger LOGGER = LoggerFactory.getLogger(CouponProductCategoryRelationController.class);

	@Resource
	private ICouponProductCategoryRelationService couponProductCategoryRelationService;

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({@ApiResponse(code = 200, message = "添加成功"), @ApiResponse(code = 400, message = "请求错误"),
			@ApiResponse(code = 403, message = "请求被拒绝"), @ApiResponse(code = 404, message = "请求路径不存在"),
			@ApiResponse(code = 500, message = "服务器内部错误")})
//    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加优惠券产品分类关系", notes = "添加优惠券产品分类关系", response = RespOk.class)
	public RespOk addCarItem(@RequestBody CouponProductCategoryRelation couponProductCategoryRelation) {
		boolean result = couponProductCategoryRelationService.save(couponProductCategoryRelation);
		return result ? new RespOk(200, "添加成功") : new RespOk(200, "添加失败");
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
			MediaType.APPLICATION_JSON_VALUE)
	public RespOk deleteAccount(@RequestBody CouponProductCategoryRelation couponProductCategoryRelation) {
		boolean result = couponProductCategoryRelationService.removeById(couponProductCategoryRelation.getId());
		return result ? new RespOk(200, "删除成功") : new RespOk(200, "删除失败");
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RespOk modifyAccount(@RequestBody CouponProductCategoryRelation couponProductCategoryRelation) {
		boolean result = couponProductCategoryRelationService.updateById(couponProductCategoryRelation);
		return result ? new RespOk(200, "修改成功") : new RespOk(200, "修改失败");
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RespOk findAccount(@RequestBody CouponProductCategoryRelation couponProductCategoryRelation) {
		CouponProductCategoryRelation result =
				couponProductCategoryRelationService.getById(couponProductCategoryRelation);
		return new RespOk(200, "查询成功", result);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
			MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询优惠券产品分类关系", notes = "批量查询优惠券产品分类关系", responseContainer = "List", response =
			RespOk.class)
	public RespOk findAccountList(@RequestBody CouponProductCategoryRelation couponProductCategoryRelation) {
		List<CouponProductCategoryRelation> couponProductCategoryRelationList =
				couponProductCategoryRelationService.list(new QueryWrapper<>(couponProductCategoryRelation));
		return new RespOk(200, "查询成功", couponProductCategoryRelationList);
	}

}
