package ${package.Mapper};

import java.util.List;
import ${package.Entity}.${entity};
import ${superMapperClassPackage};
<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {
    public void add(${entity} ${package.ModuleName});
    public void update(${entity} ${package.ModuleName});
    public void del(String ${package.ModuleName}_id);
    public ${entity} getById(String ${package.ModuleName}_id);
    public List<${entity}> get(${entity} ${package.ModuleName});
    }
</#if>
