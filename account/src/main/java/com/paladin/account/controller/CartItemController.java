package com.paladin.account.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.CartItem;
import com.paladin.account.service.ICartItemService;
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
 * 购物车表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-08-31
 */
@RestController
@RequestMapping("/cartitem")
public class CartItemController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CartItemController.class);

	private ICartItemService cartItemService;

	public CartItemController(ICartItemService cartItemService) {
		this.cartItemService = cartItemService;
	}

	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam})
	@ApiOperation(value = "添加购物车", notes = "添加购物车")
	public void addCarItem(@RequestBody CartItem cartItem) {
		cartItemService.save(cartItem);
	}

	@DeleteMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void deleteAccount(@RequestBody CartItem cartItem) {
		cartItemService.removeById(cartItem.getId());
	}

	@PutMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void modifyAccount(@RequestBody CartItem cartItem) {
		cartItemService.updateById(cartItem);
	}

	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public CartItem findAccount(@RequestBody CartItem cartItem) {
		return cartItemService.getById(cartItem);
	}

	@GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "批量查询购物车", notes = "批量查询购物车", responseContainer = "List", response = CartItem.class)
	public List<CartItem> findAccountList(@RequestBody CartItem cartItem) {
		return cartItemService.list(new QueryWrapper<>(cartItem));
	}
}
