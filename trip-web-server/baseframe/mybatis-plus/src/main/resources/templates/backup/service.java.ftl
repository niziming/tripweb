package ${package.Service};

import java.util.List;
import ${package.Entity}.${entity};
import ${superServiceClassPackage};

<#if kotlin>
    interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
    public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {
    public void add(${entity} ${package.ModuleName});
    public void update(${entity} ${package.ModuleName});
    public void del(String ${package.ModuleName}_id);
    public ${entity} getById(String ${package.ModuleName}_id);
    public List<${entity}> get(${entity} ${package.ModuleName});
    public List<${entity}> get(${entity} ${package.ModuleName}, int pageNum, int pageSize);
    }
</#if>
