package com.example.zwc.controller;

import com.example.zwc.common.SzpJsonResult;
import com.example.zwc.dto.SupportDto;
import com.example.zwc.mapper.TSubjectSupportMapper;
import com.example.zwc.pojo.TSubjectSupport;
import com.example.zwc.request.DeleteSupportRequest;
import com.example.zwc.request.GetSupoortInfoRequest;
import com.example.zwc.request.GetSupportRequest;
import com.example.zwc.request.SaveSupportRequest;
import com.example.zwc.response.GetSubjectResponse;
import com.example.zwc.response.GetSupportByIdResponse;
import com.example.zwc.response.GetSupportResponse;
import com.example.zwc.response.IntegerResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 要写注释呀
 */
@Slf4j
@RestController
@RequestMapping("subject")
public class SupportController {
    @Autowired
    private TSubjectSupportMapper tSubjectSupportMapper;

    @PostMapping("saveAndUpdate")
    public SzpJsonResult<IntegerResponse> saveAndUpdate(@RequestBody SaveSupportRequest request){
        log.info("SaveSupportRequest {}",request);
        if (StringUtils.isEmpty(request.getSubject())||StringUtils.isEmpty(request.getContent())){
            return SzpJsonResult.errorMsg("error paramters");
        }
        Example example=new Example(TSubjectSupport.class);
        synchronized (request.getSubject().intern()){
            example.and().andLike("subejct",request.getSubject());
            List<TSubjectSupport> tSubjectSupports = tSubjectSupportMapper.selectByExample(example);
            TSubjectSupport tSubjectSupport=new TSubjectSupport();
            tSubjectSupport.setContent(request.getContent());
            tSubjectSupport.setSubejct(request.getSubject());
            tSubjectSupport.setCreateTime(new Date());
            tSubjectSupport.setUpdateTime(new Date());
            if (CollectionUtils.isEmpty(tSubjectSupports)){
                tSubjectSupportMapper.insertSelective(tSubjectSupport);
            }
            Long id = tSubjectSupports.get(0).getId();
            tSubjectSupport.setId(id);
            tSubjectSupportMapper.updateByPrimaryKeySelective(tSubjectSupport);

        }
        return SzpJsonResult.ok(new IntegerResponse(1));
    }

    @PostMapping("deleteSupport")
    public SzpJsonResult<IntegerResponse> deleteSupport(@RequestBody DeleteSupportRequest request){
        int i = tSubjectSupportMapper.deleteByPrimaryKey(request.getId());
        return SzpJsonResult.ok(new IntegerResponse(i));
    }


    @PostMapping("find")
    public SzpJsonResult<GetSupportResponse> getSupport(@RequestBody GetSupportRequest request){
        if (StringUtils.isEmpty(request.getSubject())){
            return SzpJsonResult.errorMsg("error paramters");
        }

        Example example=new Example(TSubjectSupport.class);
        example.createCriteria()
                .andLike("subejct","%"+request.getSubject()+"%");
        List<TSubjectSupport> tSubjectSupports = tSubjectSupportMapper.selectByExample(example);
        List<SupportDto> collect = tSubjectSupports.stream().map(new Function<TSubjectSupport, SupportDto>() {
            @Override
            public SupportDto apply(TSubjectSupport tSubjectSupport) {
                SupportDto supportDto = new SupportDto();
                BeanUtils.copyProperties(tSubjectSupport, supportDto);
                return supportDto;
            }
        }).collect(Collectors.toList());
        GetSupportResponse getSupportResponse=new GetSupportResponse();
        getSupportResponse.setList(collect);
        return SzpJsonResult.ok(getSupportResponse);
    }

    @PostMapping("info")
    public SzpJsonResult<GetSupportByIdResponse> getInfoById(@RequestBody GetSupoortInfoRequest request){
        Example example=new Example(TSubjectSupport.class);
        example.createCriteria().andEqualTo("id",request.getId());
        List<TSubjectSupport> tSubjectSupports = tSubjectSupportMapper.selectByExample(example);
        log.info("tSubjectSupport {}",tSubjectSupports);
        GetSupportByIdResponse response=new GetSupportByIdResponse();
        BeanUtils.copyProperties(tSubjectSupports.get(0),response);
        response.setSubject(tSubjectSupports.get(0).getSubejct());
        return SzpJsonResult.ok(response);
    }
}
