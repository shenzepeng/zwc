package com.example.zwc.controller;

import com.example.zwc.common.SzpJsonResult;
import com.example.zwc.dto.SubjectDto;
import com.example.zwc.mapper.TSubjectMapper;
import com.example.zwc.pojo.TSubject;
import com.example.zwc.request.*;
import com.example.zwc.response.GetSubjectResponse;
import com.example.zwc.response.IntegerResponse;
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

/**
 * 要写注释呀
 */

@RestController
@RequestMapping("subject")
public class SubjectController {
    @Autowired
    private TSubjectMapper tSubjectMapper;
    @PostMapping("getSubject")
    public SzpJsonResult<GetSubjectResponse> getSubject(@RequestBody GetSubjecRequest request){
        GetSubjectResponse getSubjectResponse=new GetSubjectResponse();

        Example example=new Example(TSubject.class);
        if (!StringUtils.isEmpty(request.getSchoolName())){
            example.and().andLike("schoolName","%"+request.getSchoolName()+"%");
        }
        if (!StringUtils.isEmpty(request.getSubjectName())){
            example.and().andLike("subjectName","%"+request.getSubjectName()+"%");
        }
        List<TSubject> tSubjects = tSubjectMapper.selectByExample(example);

        List<SubjectDto> subjectDtos = tSubjects.stream().map(new Function<TSubject, SubjectDto>() {
            @Override
            public SubjectDto apply(TSubject tSubject) {
                SubjectDto subjectDto = new SubjectDto();
                BeanUtils.copyProperties(tSubject, subjectDto);
                return subjectDto;
            }
        }).collect(Collectors.toList());
        getSubjectResponse.setSubjectDtos(subjectDtos);
        return SzpJsonResult.ok(getSubjectResponse);
    }

    @PostMapping("getSubjectDto")
    public SzpJsonResult<SubjectDto> getSubjectDto(@RequestBody GetSubjectInfoRequest request){
        TSubject tSubject = tSubjectMapper.selectByPrimaryKey(request.getId());
        SubjectDto subjectDto=new SubjectDto();
        BeanUtils.copyProperties(tSubject,subjectDto);
        return SzpJsonResult.ok(subjectDto);
    }
    @PostMapping("updateSubject")
    public SzpJsonResult<IntegerResponse> updateSubject(@RequestBody UpdateSubjectRequest request){
        TSubject tSubject=new TSubject();
        BeanUtils.copyProperties(request,tSubject);
        int end = tSubjectMapper.updateByPrimaryKeySelective(tSubject);
        return SzpJsonResult.ok(new IntegerResponse(end));
    }
    @PostMapping("delete")
    public SzpJsonResult<IntegerResponse> deleteSubject(@RequestBody DeleteSubjectRequest request){
        int end = tSubjectMapper.deleteByPrimaryKey(request.getId());
        return SzpJsonResult.ok(new IntegerResponse(end));
    }
    @PostMapping("add")
    public SzpJsonResult<IntegerResponse> add(@RequestBody AddSubjectRequest request){
        Example example=new Example(TSubject.class);
        example.createCriteria()
                .andEqualTo("schoolName",request.getSchoolName())
                .andEqualTo("subjectName",request.getSubjectName());
        List<TSubject> tSubjects = tSubjectMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(tSubjects)){
            TSubject tSubject=new TSubject();
            BeanUtils.copyProperties(request,tSubject);
            tSubject.setCreateTime(new Date());
            tSubject.setUpdateTime(new Date());
            int i = tSubjectMapper.insertSelective(tSubject);
        }
        TSubject tSubject = tSubjects.get(0);
        tSubject.setSchoolContent(request.getSchoolContent());
        tSubject.setSubjectContent(request.getSubjectContent());
        tSubjectMapper.updateByPrimaryKeySelective(tSubject);
        return SzpJsonResult.ok(new IntegerResponse(1));
    }
}
