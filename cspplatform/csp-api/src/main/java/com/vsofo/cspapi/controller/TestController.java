package com.vsofo.cspapi.controller;

import java.rmi.server.ExportException;

import javax.servlet.http.HttpServletRequest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vsofo.cspapi.service.IAppUpdateService;
import com.vsofo.cspmodel.commonmodels.JsonResult;
import com.vsofo.csprepository.entitys.AppUpdate;
import com.vsofo.csprepository.mapper.AppUpdateMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 测试控制器
 */
@Api(tags = "测试控制器")
@RestController
@RequestMapping("/test/app-update")
public class TestController {

    @Autowired
    IAppUpdateService appUpdateService;
    @Autowired
    AppUpdateMapper appUpdateMapper;
    
    @Autowired
    HttpServletRequest request;

    @ApiOperation("123")
    @GetMapping("getstr")
    public JsonResult<AppUpdate> GetStr() throws Exception {
        throw new ExportException("sdgsagasgasg");
        // Object s1 = appUpdateService.list();
        // int s2 = appUpdateService.count();
        // IPage<AppUpdate> pages = appUpdateService.page(new Page<AppUpdate>(1, 2));
        // IPage<AppUpdate> pages2 = appUpdateMapper.selectPage(new Page<AppUpdate>(1, 2), null);
        // AppUpdate asa = appUpdateMapper.selectList(new QueryWrapper<AppUpdate>()).get(0);

        // return JsonResult.success(asa);
    }

    @ApiOperation("222")
    @GetMapping("getstr2")
    public JsonResult<AppUpdate> GetStr2() {
        Object s1 = appUpdateService.list();
        int s2 = appUpdateService.count();
        IPage<AppUpdate> pages = appUpdateService.page(new Page<AppUpdate>(1, 2));
        IPage<AppUpdate> pages2 = appUpdateMapper.selectPage(new Page<AppUpdate>(1, 2), null);
        AppUpdate asa = appUpdateMapper.selectList(new QueryWrapper<AppUpdate>()).get(0);

        return JsonResult.success(asa);
    }
}
