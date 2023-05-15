package com.atguigu.gmall1129.service;

import com.atguigu.gmall1129.bean.BaseAttrInfo;
import com.atguigu.gmall1129.bean.BaseCatalog1;
import com.atguigu.gmall1129.bean.BaseCatalog2;
import com.atguigu.gmall1129.bean.BaseCatalog3;

import java.util.List;

/**
 * @param
 * @return
 */
public interface ManageService {


      public List<BaseCatalog1> getCataLog1List();

     public List<BaseCatalog2> getCataLog2List(String catalog1Id);


       public List<BaseCatalog3> getCataLog3List(String catalog2Id);

    public List<BaseAttrInfo> getAttrInfoList(String catalog3Id);

    public void saveAttrInfo(BaseAttrInfo baseAttrInfo);
}
