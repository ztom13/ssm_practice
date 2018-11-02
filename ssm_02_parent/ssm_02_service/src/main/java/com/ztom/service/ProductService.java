package com.ztom.service;

import com.github.pagehelper.PageInfo;
import com.ztom.domain.PageBean;
import com.ztom.domain.Product;

import java.util.List;

/**
 * author:ztom
 * date:2018/10/30 21:39
 */
public interface ProductService {

    /**
     * 手动分页查询全部产品数据
     * @return
     */
    PageInfo<Product> findAll(Integer pageNum, Integer pageSize);

    /**
     * 手动分页查询全部产品数据
     * @return
     */
    PageBean<Product> findAll1(Integer pageNum, Integer pageSize);

    /**
     * 查询全部商品
     * @return
     */
    List<Product> findAll2();

    /**
     * 添加商品
     * @param product
     */
    void add(Product product);

    /**
     * 根据id查询商品
     * @param id
     * @return
     */
    Product findById(Integer id);

    /**
     * 修改商品数据
     * @param product
     */
    void update(Product product);

    /**
     * 根据id删除单个商品
     * @param id
     */
    void delById(Integer id);

    /**
     * 删除选中的多个商品
     * @param ids
     */
    void delSelected(Integer[] ids);
}
