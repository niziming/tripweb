package ${package.Mapper};

import ${package.Entity}.${entity};
import ${superMapperClassPackage};

<#if kotlin>
interface ${table.mapperName} : ${superMapperClass}<${entity}>
<#else>
public interface ${table.mapperName} extends ${superMapperClass}<${entity}> {

}
</#if>
