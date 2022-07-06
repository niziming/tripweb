package ${package.Controller};

import ${package.Entity}.${entity};
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.kofan.juanzong.admin.sys.annotation.CurrentUser;
import com.kofan.juanzong.admin.sys.annotation.LoginRequired;
import com.kofan.juanzong.admin.sys.annotation.NoAuth;
import com.kofan.juanzong.admin.sys.annotation.NotNull;
import com.kofan.juanzong.admin.user.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import com.kofan.juanzong.sys.util.ResultUtil;
import ${package.Service}.${table.serviceName};

<#if restControllerStyle>
    import org.springframework.web.bind.annotation.RestController;
<#else>
    import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
    import ${superControllerClassPackage};
</#if>

/**
* <p>
* a${table.comment!}
* </p>
*
* @author ${author}
* @since ${date}
*/
<#if restControllerStyle>
    @RestController
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

    @Autowired
    ${table.serviceName} ${table.entityPath}Service;

    @RequestMapping("/${table.entityPath}GetByPage")
    @LoginRequired
    @NoAuth("${table.comment!}查询(分页)")
    @NotNull(str="pageNum,pageSize")
    public Object getByPage(${entity} ${table.entityPath}, int pageNum, int pageSize, @CurrentUser User currentUser) {
    List<${entity}> ${table.entityPath}List = ${table.entityPath}Service.get(${table.entityPath}, pageNum, pageSize);
    PageInfo<${entity}> pageInfo = new PageInfo<>(${table.entityPath}List);
    return ResultUtil.success(pageInfo);
    }

    @RequestMapping("/${table.entityPath}Get")
    @LoginRequired
    @NoAuth("${table.comment!}查询")
    public Object get(${entity} ${table.entityPath}, @CurrentUser User currentUser) {
    List<${entity}> ${table.entityPath}List = ${table.entityPath}Service.get(${table.entityPath});
    return ResultUtil.success(${table.entityPath}List);
    }

    @RequestMapping("/${table.entityPath}Add")
    @LoginRequired
    @NoAuth("${table.comment!}新增")
    public Object add(${entity} ${table.entityPath}, @CurrentUser User currentUser) {
    ${table.entityPath}.setCreate_user_id(currentUser.getUser_id());
    ${table.entityPath}Service.add(${table.entityPath});
    return ResultUtil.success();
    }

    @RequestMapping("/${table.entityPath}Del")
    @LoginRequired
    @NoAuth("${table.comment!}删除")
    @NotNull(str="${table.name}_id")
    public Object del(${entity} ${table.entityPath}, @CurrentUser User currentUser) {
    ${table.entityPath}.setIs_del("1");
    ${table.entityPath}Service.update(${table.entityPath});
    return ResultUtil.success();
    }

    @RequestMapping("/${table.entityPath}Update")
    @LoginRequired
    @NoAuth("${table.comment!}修改")
    @NotNull(str="${table.name}_id")
    public Object update(${entity} ${table.entityPath}, @CurrentUser User currentUser) {
    ${table.entityPath}Service.update(${table.entityPath});
    return ResultUtil.success();
    }
    }
</#if>
