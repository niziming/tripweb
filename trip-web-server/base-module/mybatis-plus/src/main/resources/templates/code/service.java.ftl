package ${package.Service};

import com.baomidou.mybatisplus.core.metadata.IPage;
import ${package.Entity}.${entity};
import ${superServiceClassPackage};
import cn.zm.plus.web.entity.dto.${entity? cap_first}DTO;
import cn.zm.plus.web.entity.vo.${entity? cap_first}VO;
<#--import ${package.Entity}.${};-->

<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {
    /**
    * 分页查询
    *
    * @param page   分页信息
    * @param ${entity} ${table.comment!}入参
    * @return 分页结果
    */
    IPage<${entity? cap_first}VO> selectByPage(IPage<${entity}> page, ${entity? cap_first}DTO ${entity});
}
</#if>
