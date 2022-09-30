package com.duan.mapper;

import com.duan.pojo.Brand;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;

import javax.servlet.annotation.WebServlet;
import java.util.List;

public interface BrandMapper {
    /**
     * 查询所有数据
     * @return
     */
    @Select("SELECT * from db1.tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> SelectAll();

    /**
     * 添加数据
     * @param brand
     */
    @ResultMap("brandResultMap")
    void Add(Brand brand);

    /**
     * 根据id删除单条数据
     * @param id
     */
    @Delete("delete from db1.tb_brand where id=#{id}")
    void deleteById(@Param("id") int id);

    /**
     * 根据id修改数据
     * @param brand
     */
    @Update("update db1.tb_brand set brand_name=#{brandName},company_name=#{companyName}" +
            ",ordered=#{ordered},description=#{description},status=#{status} where id=#{id}")
    void updateBrand(Brand brand);
    /**
     * 根据id批量删除数据
     * @param ids
     */
    void deleteByIds(@Param("ids") int[] ids);
    @Select("select * from db1.tb_brand limit #{begin},#{end}")
    @ResultMap("brandResultMap")
    List<Brand> SelectByPage(@Param("begin") int begin, @Param("end") int end);
    @Select("SELECT count(*) from db1.tb_brand")
    int SelectTotalCount();

    /**
     * 根据多条件查询并将数据按页展示
     * @param begin
     * @param end
     * @param brand
     * @return
     */
    List<Brand> selectByPageAndCondition(@Param("begin") int begin, @Param("end") int end, @Param("brand") Brand brand);
    /**
     * 计算多条件查询的总条数
     * @param brand
     * @return
     */
    int SelectTotalCountByCondition(Brand brand);

}
