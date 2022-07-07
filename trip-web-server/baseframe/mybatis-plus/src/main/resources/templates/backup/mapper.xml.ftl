<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${package.Mapper}.${table.mapperName}">

    <insert id="add"
            useGeneratedKeys="true"
            keyProperty="${package.ModuleName}_id"
            parameterType="${package.Entity}.${entity}">
        insert into ${table.name}(
        <#list table.fields as field>
            <#if field.propertyName == "${package.ModuleName}_id">
            <#else>
                ${field.propertyName}<#if field_has_next>,</#if>
            </#if>
        </#list>
        )values(
        <#list table.fields as field>
            <#if field.propertyName == "${package.ModuleName}_id">
            <#else>
                <#noparse>#{</#noparse>${field.propertyName}<#noparse>}</#noparse><#if field_has_next>,</#if>
            </#if>
        </#list>
        )
    </insert>

    <select id="get"
            parameterType="${package.Entity}.${entity}"
            resultType="${package.Entity}.${entity}">
        select
        <#list table.fields as field>
            v.${field.propertyName}<#if field_has_next>,</#if>
        </#list>
        from
        ${table.name} v
        where
        1 = 1
        <#list table.fields as field>
            <if test="${field.propertyName} != null and ${field.propertyName} != ''"> and v.${field.propertyName}
                = <#noparse>#{</#noparse>${field.propertyName}<#noparse>}</#noparse></if>
        </#list>
    </select>

    <select id="getById"
            parameterType="${package.Entity}.${entity}"
            resultType="${package.Entity}.${entity}">
        select
        <#list table.fields as field>
            v.${field.propertyName}<#if field_has_next>,</#if>
        </#list>
        from
        ${table.name} v
        where
        1 = 1
        and v.${package.ModuleName}_id = <#noparse>#{</#noparse>${package.ModuleName}_id<#noparse>}</#noparse>
        limit 1
    </select>

    <update id="update"
            parameterType="${package.Entity}.${entity}">
        update ${table.name} v
        set v.${package.ModuleName}_id = <#noparse>#{</#noparse>${package.ModuleName}_id<#noparse>}</#noparse>
        <#list table.fields as field>
            <#if field.propertyName == "${package.ModuleName}_id">
            <#else>
                <if test="${field.propertyName} != null and ${field.propertyName} != ''"> , v.${field.propertyName}
                    = <#noparse>#{</#noparse>${field.propertyName}<#noparse>}</#noparse></if>
            </#if>
        </#list>
        where v.${package.ModuleName}_id = <#noparse>#{</#noparse>${package.ModuleName}_id<#noparse>}</#noparse>
    </update>

    <delete id="del"
            parameterType="java.lang.String">
        delete from ${table.name}
        where ${package.ModuleName}_id = <#noparse>#{</#noparse>${package.ModuleName}_id<#noparse>}</#noparse>
    </delete>
</mapper>
