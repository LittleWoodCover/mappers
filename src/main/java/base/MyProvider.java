package base;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;
import tk.mybatis.mapper.util.StringUtil;

import java.lang.annotation.AnnotationTypeMismatchException;
import java.util.Set;

public class MyProvider extends MapperTemplate {

    public MyProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }


    public String insertList0(MappedStatement ms) {
        StringBuilder sb = new StringBuilder();

        return sb.toString();
    }

    public String updateBatch0(MappedStatement ms) throws ClassNotFoundException {
        StringBuilder sb = new StringBuilder();
        sb.append("<foreach collection =\"list\" item=\"record\" separator=\";\" >");
        Class<?> entityClass = getEntityClass(ms);
        //传一个实体类对象，和表名,表名用父类的tableName方法获取
        String tableName = SqlHelper.updateTable(entityClass, tableName(entityClass));
        String updateClause = SqlHelper.updateTable(entityClass,tableName);
        sb.append(tableName);

        sb.append("<set>");
        Set<EntityColumn> columns = EntityHelper.getColumns(entityClass);
        String id = null, idHolder = null;
        for (EntityColumn entityColumn : columns) {
            String column = entityColumn.getColumn();
            String columnHolder = entityColumn.getColumnHolder("record");
            if (entityColumn.isId()) {
                id = column;
                idHolder = columnHolder;
            } else {
                sb.append(column).append("=").append(columnHolder).append(",");
            }
        }
        sb.append("</set>");
        if (id == null) {
            throw new ClassNotFoundException(entityClass.getName()+"类需要用@Id注解表明主键");
        }
        sb.append(" where ").append("id").append("=").append(idHolder);
        sb.append("</foreach>");
        System.out.println(sb.toString());
        return sb.toString();
    }

}
