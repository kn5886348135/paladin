package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.ProductVertifyRecord;
import com.paladin.account.service.IProductVertifyRecordService;
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
 * 商品审核记录 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/product/vertify/record")
public class ProductVertifyRecordController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductVertifyRecordController.class);

	private IProductVertifyRecordService productVertifyRecordService;

	public ProductVertifyRecordController(IProductVertifyRecordService productVertifyRecordService) {
		this.productVertifyRecordService = productVertifyRecordService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加产品审核记录", notes = "添加产品审核记录")
	public void addProductVertifyRecord(@RequestBody ProductVertifyRecord productVertifyRecord) {
		productVertifyRecordService.save(productVertifyRecord);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody ProductVertifyRecord productVertifyRecord) {
		productVertifyRecordService.removeById(productVertifyRecord.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody ProductVertifyRecord productVertifyRecord) {
		productVertifyRecordService.updateById(productVertifyRecord);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductVertifyRecord findAccount(@RequestBody ProductVertifyRecord productVertifyRecord) {
		return productVertifyRecordService.getById(productVertifyRecord);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询产品审核记录", notes = "批量查询产品审核记录", responseContainer = "List", response = ProductVertifyRecord.class)
	public List<ProductVertifyRecord> findAccountList(@RequestBody ProductVertifyRecord productVertifyRecord) {
		return productVertifyRecordService.list(new QueryWrapper<>(productVertifyRecord));
	}
}
