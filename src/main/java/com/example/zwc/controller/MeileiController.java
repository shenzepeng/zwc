package com.example.zwc.controller;

import com.example.zwc.common.SzpJsonResult;
import com.example.zwc.mapper.TMenLeiMapper;
import com.example.zwc.pojo.TMenLei;
import com.example.zwc.request.XueKeMenLeiRequest;
import com.example.zwc.response.XueKeMenLeiResponse;
import com.example.zwc.response.ZhuanYeLeiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 要写注释呀
 */
@RestController
@RequestMapping("meilei")
public class MeileiController {
    @Autowired
    private TMenLeiMapper tMenLeiMapper;
    @PostMapping("findAll")
    public SzpJsonResult<XueKeMenLeiResponse> findAll(){
        XueKeMenLeiResponse response=new XueKeMenLeiResponse();
        List<TMenLei> tMenLeis = tMenLeiMapper.selectAll();
        Set<String> stringSet=new HashSet<>();
        for (TMenLei tMenLei : tMenLeis) {
            stringSet.add(tMenLei.getZhuanyelei());
        }
        response.setList(new ArrayList<String>(stringSet));
        return SzpJsonResult.ok(response);
    }
    @PostMapping("zhuanyelei")
    public SzpJsonResult<ZhuanYeLeiResponse> xuekemenlei(@RequestBody XueKeMenLeiRequest request){
        ZhuanYeLeiResponse response=new ZhuanYeLeiResponse();
        Example example=new Example(TMenLei.class);
        example.createCriteria()
                .andEqualTo("zhuanyelei",request.getZhuanyelei());
        List<TMenLei> tMenLeis = tMenLeiMapper.selectByExample(example);
        Set<String> stringSet=new HashSet<>();
        for (TMenLei tMenLei : tMenLeis) {
            stringSet.add(tMenLei.getZhuanyemingcheng());
        }
        response.setZyl(new ArrayList<>(stringSet));
        return SzpJsonResult.ok(response);
    }
}
