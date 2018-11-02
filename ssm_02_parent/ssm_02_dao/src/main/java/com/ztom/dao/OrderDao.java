package com.ztom.dao;

import com.ztom.domain.Order;
import com.ztom.domain.Product;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * author:ztom
 * date:2018/10/31 16:50
 */
@Mapper
public interface OrderDao {

    /**
     * 查询全部订单
     *
     * @return
     */
    @Results({
            @Result(column = "productId", property = "product", javaType = Product.class,
                    one = @One(select = "com.ztom.dao.ProductDao.findById",fetchType = FetchType.LAZY))
    })
    @Select("select * from orders")
    List<Order> findAll();

    /**
     * 添加订单
     *
     * @param order
     */
    @SelectKey(keyColumn = "id", keyProperty = "id", before = true, resultType = Integer.class,
            statement = "select order_seq.nextval from dual")
    @Insert("insert into orders values(#{id},#{orderNum},#{orderTime}," +
            "#{peopleCount},#{orderDesc},#{payType},#{orderStatus}," +
            "#{product.id})")
    void save(Order order);
}
