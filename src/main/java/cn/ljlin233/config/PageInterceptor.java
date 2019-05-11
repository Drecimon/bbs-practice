package cn.ljlin233.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import cn.ljlin233.util.page.Page;

/**
 * PageInterceptor
 */
@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class, Integer.class }), })
public class PageInterceptor implements Interceptor {

    @Override // 插件运行的代码，它将代替原有的方法
    public Object intercept(Invocation invocation) throws Throwable {

        // 获取RoutingStatementHandler对象
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        // 通过MetaObject优雅访问对象的属性，这里是访问statementHandler的属性
        MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY,
                SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY, new DefaultReflectorFactory());

        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");

        String id = mappedStatement.getId();

        if (id.matches(".+ByPage$")) {

            BoundSql boundSql = statementHandler.getBoundSql();
            // 原始sql
            String sql = boundSql.getSql();
            // 获取统计数量sql
            String countSql = "select count(*) " + sql.substring(sql.indexOf("from"));
            // 拦截到的prepare方法参数是一个Connection对象
            Connection connection = (Connection) invocation.getArgs()[0];
            PreparedStatement countStatement = connection.prepareStatement(countSql);
            //// 获取参数信息即where语句的条件信息，注意上面拿到的sql中参数还是用?代替的
            ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
            parameterHandler.setParameters(countStatement);
            // 执行sql, 得到结果集
            ResultSet rs = countStatement.executeQuery();

            Object obj = boundSql.getParameterObject();
            Page<?> page = null;

            if (obj instanceof Map<?, ?>) {
                Map<?, ?> parameter = (Map<?, ?>) obj;
                page = (Page<?>) parameter.get("page");
            } else {
                page = (Page<?>) obj;
            }

            if (rs.next()) {
                page.setTotalRecord(rs.getInt(1));
            }

            int offset = (page.getPageNo() - 1) * page.getPageSize();
            String pageSql = sql + " limit " + offset + ", " + page.getPageSize();
            metaObject.setValue("delegate.boundSql.sql", pageSql);
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }

}
