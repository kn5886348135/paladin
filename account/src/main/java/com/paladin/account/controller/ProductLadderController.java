package com.paladin.account.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.ProductLadder;
import com.paladin.account.resp.RespOk;
import com.paladin.account.service.IProductLadderService;
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
 * 产品阶梯价格表(只针对同商品) 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/product/ladder")
public class ProductLadderController {

	public static final Logger LOGGER = LoggerFactory.getLogger(ProductLadderController.class);

	@Resource
	private IProductLadderService productLadderService;

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({@ApiResponse(code = 200, message = "添加成功"), @ApiResponse(code = 400, message = "请求错误"),
			@ApiResponse(code = 403, message = "请求被拒绝"), @ApiResponse(code = 404, message = "请求路径不存在"),
			@ApiResponse(code = 500, message = "服务器内部错误")})
//    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加产品阶梯价格", notes = "添加产品阶梯价格", response = RespOk.class)
	public RespOk addProductLadder(@RequestBody ProductLadder productLadder) {
		boolean result = productLadderService.save(productLadder);
		return result ? new RespOk(200, "添加成功") : new RespOk(200, "添加失败");
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
			MediaType.APPLICATION_JSON_VALUE)
	public RespOk deleteAccount(@RequestBody ProductLadder productLadder) {
		boolean result = productLadderService.removeById(productLadder.getId());
		return result ? new RespOk(200, "删除成功") : new RespOk(200, "删除失败");
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RespOk modifyAccount(@RequestBody ProductLadder productLadder) {
		boolean result = productLadderService.updateById(productLadder);
		return result ? new RespOk(200, "修改成功") : new RespOk(200, "修改失败");
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RespOk findAccount(@RequestBody ProductLadder productLadder) {
		ProductLadder result = productLadderService.getById(productLadder);
		return new RespOk(200, "查询成功", result);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
			MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询产品阶梯价格", notes = "批量查询产品阶梯价格", responseContainer = "List", response = RespOk.class)
	public RespOk findAccountList(@RequestBody ProductLadder productLadder) {
		List<ProductLadder> productLadderList = productLadderService.list(new QueryWrapper<>(productLadder));
		return new RespOk(200, "查询成功", productLadderList);
	}
}
