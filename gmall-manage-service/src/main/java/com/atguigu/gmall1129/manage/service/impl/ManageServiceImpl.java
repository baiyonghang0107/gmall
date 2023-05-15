package com.atguigu.gmall1129.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall1129.bean.*;
import com.atguigu.gmall1129.manage.mapper.*;
import com.atguigu.gmall1129.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @param
 * @return
 */


@Service
public class ManageServiceImpl  implements ManageService{
    @Autowired
    BaseCatalog1Mapper baseCatalog1Mapper;
    @Autowired
    BaseCatalog2Mapper baseCatalog2Mapper;
    @Autowired
    BaseCatalog3Mapper baseCatalog3Mapper;
    @Autowired
    BaseAttrInfoMapper baseAttrInfoMapper;
    @Autowired
    BaseAttrValueMapper baseAttrValueMapper;



    public List<BaseCatalog1> getCataLog1List(){
        List<BaseCatalog1> baseCatalog1List = baseCatalog1Mapper.selectAll();
        return  baseCatalog1List;

    }

    public List<BaseCatalog2> getCataLog2List(String catalog1Id){
        BaseCatalog2 baseCatalog2Query=new BaseCatalog2();
        baseCatalog2Query.setCatalog1Id(catalog1Id);

        List<BaseCatalog2> baseCatalog2List = baseCatalog2Mapper.select(baseCatalog2Query);
        return  baseCatalog2List;

    }

    public List<BaseCatalog3> getCataLog3List(String catalog2Id){
        BaseCatalog3 baseCatalog3Query=new BaseCatalog3();
        baseCatalog3Query.setCatalog2Id(catalog2Id);

        List<BaseCatalog3> baseCatalog3List = baseCatalog3Mapper.select(baseCatalog3Query);
        return  baseCatalog3List;

    }


    public List<BaseAttrInfo> getAttrInfoList(String catalog3Id){
        BaseAttrInfo baseAttrInfo=new BaseAttrInfo();

        baseAttrInfo.setCatalog3Id(catalog3Id);

        List<BaseAttrInfo> baseAttrInfoList = baseAttrInfoMapper.select(baseAttrInfo);

        return  baseAttrInfoList;
    }


    public void saveAttrInfo(BaseAttrInfo baseAttrInfo){
        baseAttrInfoMapper.insertSelective(baseAttrInfo);

        List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();
        for (BaseAttrValue baseAttrValue : attrValueList) {
            baseAttrValue.setAttrId(baseAttrInfo.getId());
            baseAttrValueMapper.insertSelective(baseAttrValue);
        }

    }

}
