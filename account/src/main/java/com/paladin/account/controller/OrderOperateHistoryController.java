package com.paladin.account.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.OrderOperateHistory;
import com.paladin.account.resp.RespOk;
import com.paladin.account.service.IOrderOperateHistoryService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 订单操作历史记录 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/order-operate-history")
public class OrderOperateHistoryController {

    public static final Logger LOGGER = LoggerFactory.getLogger(OrderOperateHistoryController.class);

    @Resource
    private IOrderOperateHistoryService orderOperateHistoryService;

    @DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public RespOk deleteAccount(@RequestBody OrderOperateHistory orderOperateHistory) {
        boolean result = orderOperateHistoryService.removeById(orderOperateHistory.getId());
        return result ? new RespOk(200, "删除成功") : new RespOk(200, "删除失败");
    }

    @PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public RespOk modifyAccount(@RequestBody OrderOperateHistory orderOperateHistory) {
        boolean result = orderOperateHistoryService.updateById(orderOperateHistory);
        return result ? new RespOk(200, "修改成功") : new RespOk(200, "修改失败");
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public RespOk findAccount(@RequestBody OrderOperateHistory orderOperateHistory) {
        OrderOperateHistory result = orderOperateHistoryService.getById(orderOperateHistory);
        return new RespOk(200, "查询成功", result);
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "批量查询订单操作历史记录", notes = "批量查询订单操作历史记录", responseContainer = "List", response = RespOk.class)
    public RespOk findAccountList(@RequestBody OrderOperateHistory orderOperateHistory) {
        List<OrderOperateHistory> orderOperateHistoryList = orderOperateHistoryService.list(new QueryWrapper<>(orderOperateHistory));
        return new RespOk(200, "查询成功", orderOperateHistoryList);
    }
}
