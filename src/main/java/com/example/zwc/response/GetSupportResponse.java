package com.example.zwc.response;

import com.example.zwc.dto.SupportDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 要写注释呀
 */
@Data
public class GetSupportResponse {
    private List<SupportDto> list=new ArrayList<>();
}
