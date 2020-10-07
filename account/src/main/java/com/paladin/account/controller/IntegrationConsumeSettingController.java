package com.paladin.account.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.IntegrationChangeHistory;
import com.paladin.account.resp.RespOk;
import com.paladin.account.service.IIntegrationChangeHistoryService;
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
 * 积分消费设置 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/account/integration-consume-setting")
public class IntegrationConsumeSettingController {

    public static final Logger LOGGER = LoggerFactory.getLogger(IntegrationChangeHistoryController.class);

    @Resource
    private IIntegrationChangeHistoryService integrationChangeHistoryService;

    @PostMapping(value = "/", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({@ApiResponse(code = 200, message = "添加成功"), @ApiResponse(code = 400, message = "请求错误"),
            @ApiResponse(code = 403, message = "请求被拒绝"), @ApiResponse(code = 404, message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")})
//    @ApiImplicitParams({@ApiImplicitParam})
    @ApiOperation(value = "添加积分变化历史记录", notes = "添加积分变化历史记录", response = RespOk.class)
    public RespOk addCarItem(@RequestBody IntegrationChangeHistory integrationChangeHistory) {
        boolean result = integrationChangeHistoryService.save(integrationChangeHistory);
        return result ? new RespOk(200, "添加成功") : new RespOk(200, "添加失败");
    }

    @DeleteMapping(value = "/", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RespOk deleteAccount(@RequestBody IntegrationChangeHistory integrationChangeHistory) {
        boolean result = integrationChangeHistoryService.removeById(integrationChangeHistory.getId());
        return result ? new RespOk(200, "删除成功") : new RespOk(200, "删除失败");
    }

    @PutMapping(value = "/", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RespOk modifyAccount(@RequestBody IntegrationChangeHistory integrationChangeHistory) {
        boolean result = integrationChangeHistoryService.updateById(integrationChangeHistory);
        return result ? new RespOk(200, "修改成功") : new RespOk(200, "修改失败");
    }

    @GetMapping(value = "/", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RespOk findAccount(@RequestBody IntegrationChangeHistory integrationChangeHistory) {
        IntegrationChangeHistory result = integrationChangeHistoryService.getById(integrationChangeHistory);
        return new RespOk(200, "查询成功", result);
    }

    @GetMapping(value = "/list", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "批量查询积分变化历史记录", notes = "批量查询积分变化历史记录", responseContainer = "List", response = RespOk.class)
    public RespOk findAccountList(@RequestBody IntegrationChangeHistory integrationChangeHistory) {
        List<IntegrationChangeHistory> integrationChangeHistoryList = integrationChangeHistoryService.list(new QueryWrapper<>(integrationChangeHistory));
        return new RespOk(200, "查询成功", integrationChangeHistoryList);
    }

}
