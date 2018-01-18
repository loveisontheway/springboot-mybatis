package com.liotw.springboot.mybatis.web;

import com.liotw.springboot.mybatis.core.Result;
import com.liotw.springboot.mybatis.core.ResultGenerator;
import com.liotw.springboot.mybatis.domain.MdAdministrativeRegion;
import com.liotw.springboot.mybatis.service.MdAdministrativeRegionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.lang.Integer;

/**
 * 行政区划-Controller类
 * @author jiangjialiang on 2018/01/18
 * @version 1.1.0
 */
@Api(description = "行政区划")
@RestController
@RequestMapping("/mdAdministrativeRegion")
public class MdAdministrativeRegionController {

    @Resource
    private MdAdministrativeRegionService mdAdministrativeRegionService;

    @ApiOperation(value = "新增", notes = "单表新增")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "MdAdministrativeRegion", value = "MdAdministrativeRegion对象", required = true, dataType = "Object")
    })
    @PostMapping("/add")
    public Result add(MdAdministrativeRegion mdAdministrativeRegion) {
        mdAdministrativeRegionService.save(mdAdministrativeRegion);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "删除", notes = "单表删除")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "主键", required = true, dataType = "Integer")
    })
    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        mdAdministrativeRegionService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "更新", notes = "单表更新")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "MdAdministrativeRegion", value = "MdAdministrativeRegion对象", required = true, dataType = "Object")
    })
    @PostMapping("/update")
    public Result update(MdAdministrativeRegion mdAdministrativeRegion) {
        mdAdministrativeRegionService.update(mdAdministrativeRegion);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "详情", notes = "单表详情")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "主键", required = true, dataType = "Integer")
    })
    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        MdAdministrativeRegion mdAdministrativeRegion = mdAdministrativeRegionService.findById(id);
        return ResultGenerator.genSuccessResult(mdAdministrativeRegion);
    }

    @ApiOperation(value = "分页", notes = "单表分页")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "size", value = "页数", required = true, dataType = "Integer")
    })
    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<MdAdministrativeRegion> list = mdAdministrativeRegionService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
