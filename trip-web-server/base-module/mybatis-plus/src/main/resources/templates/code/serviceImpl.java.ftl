package ${package.ServiceImpl};

import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${package.Service}.${table.serviceName};
import ${superServiceImplClassPackage};
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.zm.plus.web.entity.dto.${entity? cap_first}DTO;
import cn.zm.plus.web.entity.vo.${entity? cap_first}VO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import ${package.Service?substring(0, package.Service? index_of("web.service"))}utils.ConvertUtil;


@Service
@Transactional(rollbackFor = Exception.class)
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {
    @Override
    public IPage<${entity? cap_first}VO> selectByPage(IPage<${entity}> page, ${entity? cap_first}DTO ${table.name}) {
        IPage<${entity}> ${table.name}Page = baseMapper.selectPage(page, new QueryWrapper<>(${table.name}.convert()));
        return ConvertUtil.buildPage(${table.name}Page);
    }
}
</#if>
