package com.paladin.account.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.Product;
import com.paladin.account.resp.RespOk;
import com.paladin.account.service.IProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 商品信息 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/product")
public class ProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@Resource
	private IProductService productService;

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({@ApiResponse(code = 200, message = "添加成功"), @ApiResponse(code = 400, message = "请求错误"),
			@ApiResponse(code = 403, message = "请求被拒绝"), @ApiResponse(code = 404, message = "请求路径不存在"),
			@ApiResponse(code = 500, message = "服务器内部错误")})
//    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加产品", notes = "添加产品", response = RespOk.class)
	public RespOk addProduct(@RequestBody Product product) {
		boolean result = productService.save(product);
		return result ? new RespOk(200, "添加成功") : new RespOk(200, "添加失败");
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
			MediaType.APPLICATION_JSON_VALUE)
	public RespOk deleteProduct(@RequestBody Product product) {
		boolean result = productService.removeById(product.getId());
		return result ? new RespOk(200, "删除成功") : new RespOk(200, "删除失败");
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RespOk modifyProduct(@RequestBody Product product) {
		boolean result = productService.updateById(product);
		return result ? new RespOk(200, "修改成功") : new RespOk(200, "修改失败");
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public RespOk findProduct(@RequestBody Product product) {
		Product result = productService.getById(product);
		return new RespOk(200, "查询成功", result);
	}

	@GetMapping(value = "/detail", produces = MediaType.APPLICATION_JSON_VALUE)
	public RespOk findProductDetail(@RequestBody Product product) {
		Product result = productService.getById(product);
		return new RespOk(200, "查询成功", result);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询产品列表", notes = "批量查询产品", responseContainer = "List", response = RespOk.class)
	public RespOk findProductList(@RequestBody Product product) {
		List<Product> productList = productService.list(new QueryWrapper<>(product));
		return new RespOk(200, "查询成功", productList);
	}
}
