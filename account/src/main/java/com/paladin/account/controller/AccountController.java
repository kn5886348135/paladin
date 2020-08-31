package com.paladin.account.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paladin.account.entity.Account;
import com.paladin.account.resp.RespOk;
import com.paladin.account.service.IAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author paladin
 * @since 2020-08-31
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    public static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

    @Resource
    private IAccountService accountService;

    @PostMapping(value = "/", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RespOk addAccount(@RequestBody Account account) {
        boolean result = accountService.save(account);
        return result ? new RespOk(200, "新增成功") : new RespOk(200, "新增失败");
    }

    @DeleteMapping(value = "/", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RespOk deleteAccount(@RequestBody Account account) {
        boolean result = accountService.removeById(account.getId());
        return result ? new RespOk(200, "删除成功") : new RespOk(200, "删除失败");
    }

    @PutMapping(value = "/", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RespOk modifyAccount(@RequestBody Account account) {
        boolean result = accountService.updateById(account);
        return result ? new RespOk(200, "修改成功") : new RespOk(200, "修改失败");
    }

    @GetMapping(value = "/", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RespOk findAccount(@RequestBody Account account) {
        Account result = accountService.getById(account);
        return new RespOk(200, "查询成功", result);
    }

    @GetMapping(value = "/list", produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE)
    public RespOk findAccountList(@RequestBody Account account) {
        List<Account> accountList = accountService.list(new QueryWrapper<>(account));
        return new RespOk(200, "查询成功", accountList);
    }
}
