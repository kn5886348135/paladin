package com.paladin.account.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.PayWxRefund;
import com.paladin.account.resp.RespOk;
import com.paladin.account.service.IPayWxRefundService;
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
 * 微信支付退款记录表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/pay/wx/refund")
public class PayWxRefundController {

	public static final Logger LOGGER = LoggerFactory.getLogger(PayWxRefundController.class);

	@Resource
	private IPayWxRefundService payWxRefundService;

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses({@ApiResponse(code = 200, message = "添加成功"), @ApiResponse(code = 400, message = "请求错误"),
			@ApiResponse(code = 403, message = "请求被拒绝"), @ApiResponse(code = 404, message = "请求路径不存在"),
			@ApiResponse(code = 500, message = "服务器内部错误")})
//    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加微信退款记录", notes = "添加微信退款记录", response = RespOk.class)
	public RespOk addPayWxRefund(@RequestBody PayWxRefund payWxRefund) {
		boolean result = payWxRefundService.save(payWxRefund);
		return result ? new RespOk(200, "添加成功") : new RespOk(200, "添加失败");
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
			MediaType.APPLICATION_JSON_VALUE)
	public RespOk deleteAccount(@RequestBody PayWxRefund payWxRefund) {
		boolean result = payWxRefundService.removeById(payWxRefund.getId());
		return result ? new RespOk(200, "删除成功") : new RespOk(200, "删除失败");
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RespOk modifyAccount(@RequestBody PayWxRefund payWxRefund) {
		boolean result = payWxRefundService.updateById(payWxRefund);
		return result ? new RespOk(200, "修改成功") : new RespOk(200, "修改失败");
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public RespOk findAccount(@RequestBody PayWxRefund payWxRefund) {
		PayWxRefund result = payWxRefundService.getById(payWxRefund);
		return new RespOk(200, "查询成功", result);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
			MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询微信退款记录", notes = "批量查询微信退款记录", responseContainer = "List", response = RespOk.class)
	public RespOk findAccountList(@RequestBody PayWxRefund payWxRefund) {
		List<PayWxRefund> payWxRefundList = payWxRefundService.list(new QueryWrapper<>(payWxRefund));
		return new RespOk(200, "查询成功", payWxRefundList);
	}
}
