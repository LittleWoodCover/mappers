package base;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

public interface BaseMapper<T> {

    @InsertProvider(type = MyProvider.class, method = "dynamicSQL")
    int insertList0(List<T> list);

    @UpdateProvider(type = MyProvider.class, method = "dynamicSQL")
    int updateBatch0(List<T> list);
}
