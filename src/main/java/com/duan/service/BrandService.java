package com.duan.service;

import com.duan.pojo.Brand;
import com.duan.pojo.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandService {
    /**
     * 查询所有
     * @return
     */
    List<Brand> SelectAll();

    /**
     * 添加商品
     * @param brand
     */
    void Add(Brand brand);

    /**
     * 根据id删除单挑数据
     * @param id
     */
    void deleteById(int id);

    /**
     * 根据id修改数据
     * @param brand
     */
    void updateBrand(Brand brand);

    /**
     * 根据id批量删除对应商品
     * @param ids
     * @return
     */
    void DeleteByIDs(int[] ids);

    /**
     *查询每页数据和总数据条数
     * @param currentPage 当前言码
     * @param PageSize   每页列数
     * @return
     */
    PageBean<Brand> selectByPage(int currentPage,int PageSize);

    /**
     * 分页条件查询
     * @param currentPage
     * @param PageSize
     * @return
     */
    PageBean<Brand> selectByPageByCondition(int currentPage,int PageSize,Brand brand);


}
