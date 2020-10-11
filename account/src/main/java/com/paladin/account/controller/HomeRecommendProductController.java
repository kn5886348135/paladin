package com.paladin.account.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.HomeRecommendProduct;
import com.paladin.account.resp.RespOk;
import com.paladin.account.service.IHomeRecommendProductService;
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
 * 人气推荐商品表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/home/recommend/product")
public class HomeRecommendProductController {

    public static final Logger LOGGER = LoggerFactory.getLogger(HomeRecommendProductController.class);

    @Resource
    private IHomeRecommendProductService homeRecommendProductService;

    @PostMapping(value = "/", MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({@ApiResponse(code = 200, message = "添加成功"), @ApiResponse(code = 400, message = "请求错误"),
            @ApiResponse(code = 403, message = "请求被拒绝"), @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")})
//    @ApiImplicitParams({@ApiImplicitParam})
    @ApiOperation(value = "添加首页推荐产品", notes = "添加首页推荐产品", response = RespOk.class)
    public RespOk addCarItem(@RequestBody HomeRecommendProduct homeRecommendProduct) {
        boolean result = homeRecommendProductService.save(homeRecommendProduct);
        return result ? new RespOk(200, "添加成功") : new RespOk(200, "添加失败");
    }

    @DeleteMapping(value = "/", MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public RespOk deleteAccount(@RequestBody HomeRecommendProduct homeRecommendProduct) {
        boolean result = homeRecommendProductService.removeById(homeRecommendProduct.getId());
        return result ? new RespOk(200, "删除成功") : new RespOk(200, "删除失败");
    }

    @PutMapping(value = "/", MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public RespOk modifyAccount(@RequestBody HomeRecommendProduct homeRecommendProduct) {
        boolean result = homeRecommendProductService.updateById(homeRecommendProduct);
        return result ? new RespOk(200, "修改成功") : new RespOk(200, "修改失败");
    }

    @GetMapping(value = "/", MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public RespOk findAccount(@RequestBody HomeRecommendProduct homeRecommendProduct) {
        HomeRecommendProduct result = homeRecommendProductService.getById(homeRecommendProduct);
        return new RespOk(200, "查询成功", result);
    }

    @GetMapping(value = "/list", MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "批量查询首页推荐产品", notes = "批量查询首页推荐产品", responseContainer = "List", response = RespOk.class)
    public RespOk findAccountList(@RequestBody HomeRecommendProduct homeRecommendProduct) {
        List<HomeRecommendProduct> homeRecommendProductList = homeRecommendProductService.list(new QueryWrapper<>(homeRecommendProduct));
        return new RespOk(200, "查询成功", homeRecommendProductList);
    }

}
