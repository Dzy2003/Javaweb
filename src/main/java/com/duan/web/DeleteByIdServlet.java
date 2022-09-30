package com.duan.web;

import com.alibaba.fastjson.JSON;
import com.duan.service.BrandService;
import com.duan.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/deleteByIdServlet")
public class DeleteByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = req.getReader();
        String params = br.readLine();
        BrandService brandService=new BrandServiceImpl();
        // 将JSON字符串转为Java对象
        int id = JSON.parseObject(params, int.class);
        brandService.deleteById(id);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write("success");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
