package com.ztom.dao;

import com.ztom.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * author:ztom
 * date:2018/10/30 21:43
 */
@Mapper
public interface ProductDao {

    /**
     * 查询全部产品数据
     * @return
     */
    @Select("select t.* from (select p.*,rownum rn from product p) t " +
            "where t.rn between #{param1} and #{param2}")
    List<Product> findByPage(Integer begin,Integer end);

    /**
     * 添加商品
     * @param product
     */
    @SelectKey(keyColumn = "id",keyProperty = "id",before = true, resultType = Integer.class,
            statement = "select product_seq.nextval from dual")
    @Insert("insert into product values(#{id},#{productNum},#{productName}," +
            "#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void add(Product product);

    /**
     * 根据id查询商品
     * @param id
     * @return
     */
    @Select("select * from product where id=#{id}")
    Product findById(Integer id);

    /**
     * 修改商品数据
     * @param product
     */
    @Update("update product set productNum=#{productNum},productName=#{productName},cityName=#{cityName}," +
            "departureTime=#{departureTime},productPrice=#{productPrice}," +
            "productDesc=#{productDesc},productStatus=#{productStatus} where id=#{id}")
    void update(Product product);

    /**
     * 根据id删除单个商品
     * @param id
     */
    @Delete("delete from product where id=#{id}")
    void delById(Integer id);

    /**
     * 查询商品总记录数
     * @return
     */
    @Select("select count(0) from product")
    Long findTotal();

    /**
     * 查询全部商品
     * @return
     */
    @Select("select * from product")
    List<Product> findAll();
}
