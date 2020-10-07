package com.paladin.account.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.OrderItem;
import com.paladin.account.resp.RespOk;
import com.paladin.account.service.IOrderItemService;
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
 * 订单明细中所包含的商品 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-09-25
 */
@RestController
@RequestMapping("/order/item")
public class OrderItemController {

    public static final Logger LOGGER = LoggerFactory.getLogger(OrderItemController.class);

    @Resource
    private IOrderItemService orderItemService;

    @PostMapping(value = "/", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({@ApiResponse(code = 200, message = "添加成功"), @ApiResponse(code = 400, message = "请求错误"),
            @ApiResponse(code = 403, message = "请求被拒绝"), @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")})
//    @ApiImplicitParams({@ApiImplicitParam})
    @ApiOperation(value = "添加订单明细", notes = "添加订单明细", response = RespOk.class)
    public RespOk register(@RequestBody OrderItem orderItem) {
        boolean result = orderItemService.save(orderItem);
        return result ? new RespOk(200, "添加成功") : new RespOk(200, "添加失败");
    }

    @DeleteMapping(value = "/", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RespOk deleteAccount(@RequestBody OrderItem orderItem) {
        boolean result = orderItemService.removeById(orderItem.getId());
        return result ? new RespOk(200, "删除成功") : new RespOk(200, "删除失败");
    }

    @PutMapping(value = "/", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RespOk modifyAccount(@RequestBody OrderItem orderItem) {
        boolean result = orderItemService.updateById(orderItem);
        return result ? new RespOk(200, "修改成功") : new RespOk(200, "修改失败");
    }

    @GetMapping(value = "/", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RespOk findAccount(@RequestBody OrderItem orderItem) {
        OrderItem result = orderItemService.getById(orderItem);
        return new RespOk(200, "查询成功", result);
    }

    @GetMapping(value = "/list", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "批量查询订单明细", notes = "批量查询订单明细", responseContainer = "List", response = RespOk.class)
    public RespOk findAccountList(@RequestBody OrderItem orderItem) {
        List<OrderItem> orderItemList = orderItemService.list(new QueryWrapper<>(orderItem));
        return new RespOk(200, "查询成功", orderItemList);
    }
}
