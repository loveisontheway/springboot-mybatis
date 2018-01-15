package ${basePackage}.web;

import ${basePackage}.core.Result;
import ${basePackage}.core.ResultGenerator;
import ${basePackage}.domain.${domainNameUpperCamel};
import ${basePackage}.service.${domainNameUpperCamel}Service;
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
import java.lang.${pkDataType};

/**
 * ${description}-Controller类
 * @author ${author} on ${date}
 * @version 3.0.0
 */
@Api(description = "${description}")
@RestController
@RequestMapping("${baseRequestMapping}")
public class ${domainNameUpperCamel}Controller {

    @Resource
    private ${domainNameUpperCamel}Service ${domainNameLowerCamel}Service;

    @ApiOperation(value = "新增", notes = "单表新增")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "${domainNameUpperCamel}", value = "${domainNameUpperCamel}对象", required = true, dataType = "Object")
    })
    @PostMapping("/add")
    public Result add(${domainNameUpperCamel} ${domainNameLowerCamel}) {
        ${domainNameLowerCamel}Service.save(${domainNameLowerCamel});
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "删除", notes = "单表删除")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "主键", required = true, dataType = "${pkDataType}")
    })
    @PostMapping("/delete")
    public Result delete(@RequestParam ${pkDataType} id) {
        ${domainNameLowerCamel}Service.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "更新", notes = "单表更新")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "${domainNameUpperCamel}", value = "${domainNameUpperCamel}对象", required = true, dataType = "Object")
    })
    @PostMapping("/update")
    public Result update(${domainNameUpperCamel} ${domainNameLowerCamel}) {
        ${domainNameLowerCamel}Service.update(${domainNameLowerCamel});
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "详情", notes = "单表详情")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "主键", required = true, dataType = "${pkDataType}")
    })
    @PostMapping("/detail")
    public Result detail(@RequestParam ${pkDataType} id) {
        ${domainNameUpperCamel} ${domainNameLowerCamel} = ${domainNameLowerCamel}Service.findById(id);
        return ResultGenerator.genSuccessResult(${domainNameLowerCamel});
    }

    @ApiOperation(value = "分页", notes = "单表分页")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "page", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "size", value = "页数", required = true, dataType = "Integer")
    })
    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<${domainNameUpperCamel}> list = ${domainNameLowerCamel}Service.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
