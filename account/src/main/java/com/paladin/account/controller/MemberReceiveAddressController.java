package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.MemberReceiveAddress;
import com.paladin.account.service.IMemberReceiveAddressService;
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
 * 会员收货地址表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-10-07
 */
@RestController
@RequestMapping("/member/receive/address")
public class MemberReceiveAddressController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MemberReceiveAddressController.class);

	private IMemberReceiveAddressService memberReceiveAddressService;

	public MemberReceiveAddressController(IMemberReceiveAddressService memberReceiveAddressService) {
		this.memberReceiveAddressService = memberReceiveAddressService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加会员收获地址", notes = "添加会员收获地址")
	public void addCarItem(@RequestBody MemberReceiveAddress memberReceiveAddress) {
		memberReceiveAddressService.save(memberReceiveAddress);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody MemberReceiveAddress memberReceiveAddress) {
		memberReceiveAddressService.removeById(memberReceiveAddress.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody MemberReceiveAddress memberReceiveAddress) {
		memberReceiveAddressService.updateById(memberReceiveAddress);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public MemberReceiveAddress findAccount(@RequestBody MemberReceiveAddress memberReceiveAddress) {
		return memberReceiveAddressService.getById(memberReceiveAddress);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes =
			MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询会员收获地址", notes = "批量查询会员收获地址", responseContainer = "List", response = MemberReceiveAddress.class)
	public List<MemberReceiveAddress> findAccountList(@RequestBody MemberReceiveAddress memberReceiveAddress) {
		return memberReceiveAddressService.list(new QueryWrapper<>(memberReceiveAddress));
	}
}
