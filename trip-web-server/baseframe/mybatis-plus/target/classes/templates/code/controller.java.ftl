package ${package.Controller};

import ${package.Service}.${table.serviceName};
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>
import com.baomidou.mybatisplus.core.metadata.IPage;
import ResResult;
import ${package.Entity}.dto.<#if entity?ends_with("DTO")>${entity? cap_first? substring(0, entity? index_of("DTO"))}<#else>${entity? cap_first}</#if>DTO;
import ${package.Entity}.vo.<#if entity?ends_with("VO")>${entity? cap_first? substring(0, entity? index_of("VO"))}<#else>${entity? cap_first}</#if>VO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.Objects;
import java.util.List;

/**
 * ${table.comment!}
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RequestMapping("<#if entity?ends_with("DTO")>${entity? substring(0, entity? uncap_first? index_of("DTO"))}<#else>${entity? uncap_first}</#if>")
@RestController
@Api(tags = "${table.comment}")
<#else>
@Controller
</#if>
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
    <#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
    <#else>
public class ${table.controllerName} {
    </#if>

    @Resource
    private ${table.serviceName} <#if entity?ends_with("DTO")>${entity? substring(0, entity? uncap_first? index_of("DTO"))}<#else>${entity? uncap_first}</#if>Service;

    @GetMapping
    @ApiOperation("${table.comment!}page查询")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "当前页数", defaultValue = "1"),
        @ApiImplicitParam(name = "size", value = "每页个数", defaultValue = "10"),
        @ApiImplicitParam(name = "orderByColumn", value = "排序字段"),
        @ApiImplicitParam(name = "isDesc", value = "是否降序")
    })
    public ResResult<IPage<<#if entity?ends_with("DTO")>${entity? cap_first? substring(0, entity? index_of("DTO"))}<#else>${entity? cap_first}</#if>VO>> getByPage(@Validated <#if entity?ends_with("DTO")>${entity? cap_first? substring(0, entity? index_of("DTO"))}<#else>${entity}</#if>DTO <#if entity?ends_with("DTO")>${entity? substring(0, entity? uncap_first? index_of("DTO"))}<#else>${entity? uncap_first}</#if>) {
        // TODO 分页查询
        IPage<<#if entity?ends_with("DTO")>${entity? cap_first? substring(0, entity? index_of("DTO"))}<#else>${entity? cap_first}</#if>VO> page = <#if entity?ends_with("DTO")>${entity? substring(0, entity? uncap_first? index_of("DTO"))}<#else>${entity? uncap_first}</#if>Service.selectByPage(getPage(), ${entity? uncap_first});
        return ResResult.succ(page);
    }

    @PostMapping("list")
    @ApiOperation("${table.comment!}list查询")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "orderByColumn", value = "排序字段"),
        @ApiImplicitParam(name = "isDesc", value = "是否降序")
    })
    public ResResult<List<<#if entity?ends_with("DTO")>${entity? cap_first? substring(0, entity? index_of("DTO"))}<#else>${entity? cap_first}</#if>VO>> list(@Validated @RequestBody <#if entity?ends_with("DTO")>${entity? cap_first? substring(0, entity? index_of("DTO"))}<#else>${entity}</#if>DTO <#if entity?ends_with("DTO")>${entity? substring(0, entity? uncap_first? index_of("DTO"))}<#else>${entity? uncap_first}</#if>) {
        // TODO 分页查询
        IPage<<#if entity?ends_with("DTO")>${entity? cap_first? substring(0, entity? index_of("DTO"))}<#else>${entity? cap_first}</#if>VO> page = <#if entity?ends_with("DTO")>${entity? substring(0, entity? uncap_first? index_of("DTO"))}<#else>${entity? uncap_first}</#if>Service.list(getPage(), ${entity? uncap_first});
        return ResResult.succ(page);
    }

    @GetMapping("{id}")
    @ApiOperation("${table.comment!}查询(id)")
    public ResResult<<#if entity?ends_with("DTO")>${entity? cap_first? substring(0, entity? index_of("DTO"))}<#else>${entity? cap_first}</#if>VO> get(@PathVariable String id) {
        // TODO 查询
        boolean aNull = Objects.isNull(<#if entity?ends_with("DTO")>${entity? substring(0, entity? uncap_first? index_of("DTO"))}<#else>${entity? uncap_first}</#if>Service.getById(id));
        return ResResult.succ(aNull ? null : <#if entity?ends_with("DTO")>${entity? substring(0, entity? uncap_first? index_of("DTO"))}<#else>${entity? uncap_first}</#if>Service.getById(id).convert());
    }

    @PostMapping
    @ApiOperation("${table.comment!}新增")
    public ResResult add(@RequestBody @Validated <#if entity?ends_with("DTO")>${entity? cap_first? substring(0, entity? index_of("DTO"))}<#else>${entity}</#if>DTO <#if entity?ends_with("DTO")>${entity? substring(0, entity? uncap_first? index_of("DTO"))}<#else>${entity? uncap_first}</#if>) {
        // TODO 新增
        <#if entity?ends_with("DTO")>${entity? substring(0, entity? uncap_first? index_of("DTO"))}<#else>${entity? uncap_first}</#if>Service.save(${entity? uncap_first}.convert());
        return ResResult.succ("新增成功");
    }

    @DeleteMapping("{id}")
    @ApiOperation("${table.comment!}删除")
    public ResResult del(@PathVariable String id) {
        // TODO 删除
        <#if entity?ends_with("DTO")>${entity? substring(0, entity? uncap_first? index_of("DTO"))}<#else>${entity? uncap_first}</#if>Service.removeById(id);
        return ResResult.succ("删除成功");
    }

    @PutMapping
    @ApiOperation("${table.comment!}修改")
    public ResResult update(@RequestBody @Validated <#if entity?ends_with("DTO")>${entity? cap_first? substring(0, entity? index_of("DTO"))}<#else>${entity}</#if>DTO <#if entity?ends_with("DTO")>${entity? substring(0, entity? uncap_first? index_of("DTO"))}<#else>${entity? uncap_first}</#if>) {
        // TODO 修改
        <#if entity?ends_with("DTO")>${entity? substring(0, entity? uncap_first? index_of("DTO"))}<#else>${entity? uncap_first}</#if>Service.updateById(${entity? uncap_first}.convert());
        return ResResult.succ("修改成功");
    }
}
</#if>
