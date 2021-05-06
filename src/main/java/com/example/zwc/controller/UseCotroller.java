package com.example.zwc.controller;

import com.example.zwc.common.SzpJsonResult;
import com.example.zwc.mapper.TUseMapper;
import com.example.zwc.mapper.UserMapper;
import com.example.zwc.pojo.TUse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 要写注释呀
 */
@RestController("use")
public class UseCotroller {

    @Autowired
    private TUseMapper useMapper;
    @PostMapping("getCanUser")
    public SzpJsonResult<String> getCanUser(@RequestParam String app){
        Example example=new Example(TUse.class);
        example.createCriteria()
                .andEqualTo("app",app);
        List<TUse> tUses = useMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(tUses)){
            return SzpJsonResult.errorMsg("app can not be null");
        }
        return SzpJsonResult.ok(tUses.get(0).getCanUse());
    }
}
