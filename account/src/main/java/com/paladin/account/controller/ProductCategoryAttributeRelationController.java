package com.paladin.account.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.ProductCategoryAttributeRelation;
import com.paladin.account.resp.RespOk;
import com.paladin.account.service.IProductCategoryAttributeRelationService;
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
 * 产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类） 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/product/category/attribute/relation")
public class ProductCategoryAttributeRelationController {

    public static final Logger LOGGER = LoggerFactory.getLogger(ProductCategoryAttributeRelationController.class);

    @Resource
    private IProductCategoryAttributeRelationService productCategoryAttributeRelationService;

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({@ApiResponse(code = 200, message = "添加成功"), @ApiResponse(code = 400, message = "请求错误"),
            @ApiResponse(code = 403, message = "请求被拒绝"), @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")})
//    @ApiImplicitParams({@ApiImplicitParam})
    @ApiOperation(value = "添加产品分类和属性的关系", notes = "添加产品分类和属性的关系", response = RespOk.class)
    public RespOk addProductCategoryAttributeRelation(@RequestBody ProductCategoryAttributeRelation productCategoryAttributeRelation) {
        boolean result = productCategoryAttributeRelationService.save(productCategoryAttributeRelation);
        return result ? new RespOk(200, "添加成功") : new RespOk(200, "添加失败");
    }

    @DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public RespOk deleteAccount(@RequestBody ProductCategoryAttributeRelation productCategoryAttributeRelation) {
        boolean result = productCategoryAttributeRelationService.removeById(productCategoryAttributeRelation.getId());
        return result ? new RespOk(200, "删除成功") : new RespOk(200, "删除失败");
    }

    @PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public RespOk modifyAccount(@RequestBody ProductCategoryAttributeRelation productCategoryAttributeRelation) {
        boolean result = productCategoryAttributeRelationService.updateById(productCategoryAttributeRelation);
        return result ? new RespOk(200, "修改成功") : new RespOk(200, "修改失败");
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public RespOk findAccount(@RequestBody ProductCategoryAttributeRelation productCategoryAttributeRelation) {
        ProductCategoryAttributeRelation result = productCategoryAttributeRelationService.getById(productCategoryAttributeRelation);
        return new RespOk(200, "查询成功", result);
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "批量查询产品分类和属性的关系", notes = "批量查询产品分类和属性的关系", responseContainer = "List", response = RespOk.class)
    public RespOk findAccountList(@RequestBody ProductCategoryAttributeRelation productCategoryAttributeRelation) {
        List<ProductCategoryAttributeRelation> productCategoryAttributeRelationList = productCategoryAttributeRelationService.list(new QueryWrapper<>(productCategoryAttributeRelation));
        return new RespOk(200, "查询成功", productCategoryAttributeRelationList);
    }
}
