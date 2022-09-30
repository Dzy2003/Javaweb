package com.duan.service.impl;

import com.duan.mapper.BrandMapper;
import com.duan.pojo.Brand;
import com.duan.pojo.PageBean;
import com.duan.service.BrandService;
import com.duan.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    SqlSessionFactory sessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public List<Brand> SelectAll(){
        SqlSession session = sessionFactory.openSession();
        BrandMapper mapper = session.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.SelectAll();
        session.close();
        return brands;
    }
    @Override
    public void Add(Brand brand) {
        SqlSession session = sessionFactory.openSession();
        BrandMapper mapper = session.getMapper(BrandMapper.class);
        mapper.Add(brand);
        session.commit();
        session.close();
    }

    @Override
    public void deleteById(int id) {
        SqlSession sqlSession = sessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateBrand(Brand brand) {
        SqlSession sqlSession = sessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.updateBrand(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void DeleteByIDs(int[] ids) {
        SqlSession sqlSession = sessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
         mapper.deleteByIds(ids);
         sqlSession.commit();
         sqlSession.close();
    }

    @Override
    public PageBean<Brand> selectByPage(int currentPage,int PageSize) {
        SqlSession sqlSession = sessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //计算limit语句中的起始索引和长度
        int begin = (currentPage - 1) * PageSize;
        int end=PageSize;
        //查询每页数据和总条数
        List<Brand> rows = mapper.SelectByPage(begin, end);
        int totalCount = mapper.SelectTotalCount();
        //封装PageBean对象
        PageBean<Brand> brandPageBean = new PageBean<>();
        brandPageBean.setRows(rows);
        brandPageBean.setTotalCount(totalCount);
        sqlSession.close();
        return brandPageBean;

    }

    @Override
    public PageBean<Brand> selectByPageByCondition(int currentPage, int PageSize, Brand brand) {
        SqlSession sqlSession = sessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //计算limit语句中的起始索引和长度
        int begin = (currentPage - 1) * PageSize;
        int end=PageSize;
        //查询每页数据和总条数
        String brandName = brand.getBrandName();
        if (brandName!=null&&brandName.length()>0){
            brand.setBrandName("%"+brandName+"%");
        }
        String companyName = brand.getCompanyName();
        if (companyName!=null&&companyName.length()>0){
            brand.setCompanyName("%"+companyName+"%");
        }
        List<Brand> rows = mapper.selectByPageAndCondition(begin, end,brand);
        int totalCount = mapper.SelectTotalCountByCondition(brand);
        //封装PageBean对象
        PageBean<Brand> brandPageBean = new PageBean<>();
        brandPageBean.setRows(rows);
        brandPageBean.setTotalCount(totalCount);
        sqlSession.close();
        return brandPageBean;
    }
}
