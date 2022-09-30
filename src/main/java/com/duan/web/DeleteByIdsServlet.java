package com.duan.web;

import com.alibaba.fastjson.JSON;
import com.duan.pojo.Brand;
import com.duan.service.BrandService;
import com.duan.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/deleteByIdsServlet")
public class DeleteByIdsServlet extends HttpServlet {
    BrandService brandService=new BrandServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求体数据
        BufferedReader br = request.getReader();
        String params = br.readLine();
        // 将JSON字符串转为Java对象
        int[] ids = JSON.parseObject(params, int[].class);
        brandService.DeleteByIDs(ids);
        response.getWriter().write("success");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doGet(request,response);
    }
}
