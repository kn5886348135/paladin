package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.ProductOperateLog;
import com.paladin.account.service.IProductOperateLogService;
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
 * 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/product/operate/log")
public class ProductOperateLogController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductOperateLogController.class);

	private IProductOperateLogService productOperateLogService;

	public ProductOperateLogController(IProductOperateLogService productOperateLogService) {
		this.productOperateLogService = productOperateLogService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加产品操作日志", notes = "添加产品操作日志")
	public void addProductOperateLog(@RequestBody ProductOperateLog productOperateLog) {
		productOperateLogService.save(productOperateLog);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody ProductOperateLog productOperateLog) {
		productOperateLogService.removeById(productOperateLog.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody ProductOperateLog productOperateLog) {
		productOperateLogService.updateById(productOperateLog);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductOperateLog findAccount(@RequestBody ProductOperateLog productOperateLog) {
		return productOperateLogService.getById(productOperateLog);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询产品操作日志", notes = "批量查询产品操作日志", responseContainer = "List", response = ProductOperateLog.class)
	public List<ProductOperateLog> findAccountList(@RequestBody ProductOperateLog productOperateLog) {
		return productOperateLogService.list(new QueryWrapper<>(productOperateLog));
	}
}
