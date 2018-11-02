package com.ztom.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ztom.dao.ProductDao;
import com.ztom.domain.PageBean;
import com.ztom.domain.Product;
import com.ztom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author:ztom
 * date:2018/10/30 21:42
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;

    @Override
    public PageInfo<Product> findAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Product> productList = productDao.findAll();
        return new PageInfo<>(productList,5);
    }

    @Override
    public PageBean<Product> findAll1(Integer pageNum, Integer pageSize) {
        PageBean<Product> pageBean = new PageBean<>();

        pageBean.setPageNum(pageNum);

        pageBean.setPageSize(pageSize);

        Long total = productDao.findTotal();
        pageBean.setTotal(total);

        List<Product> productList = productDao.findByPage(
                (pageNum - 1) * pageSize + 1,
                pageSize * pageNum
        );
        pageBean.setList(productList);

        return pageBean;
    }

    @Override
    public List<Product> findAll2() {
        return productDao.findAll();
    }

    @Override
    public void add(Product product) {
        productDao.add(product);
    }

    @Override
    public Product findById(Integer id) {
        return productDao.findById(id);
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    public void delById(Integer id) {
        productDao.delById(id);
    }

    @Override
    public void delSelected(Integer[] ids) {
        if (ids != null) {
            for (Integer id : ids) {
                productDao.delById(id);
            }
        }
    }
}
