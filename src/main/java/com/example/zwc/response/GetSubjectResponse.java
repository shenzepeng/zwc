package com.example.zwc.response;

import com.example.zwc.dto.SubjectDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 要写注释呀
 */
@Data
public class GetSubjectResponse {
    private List<SubjectDto> subjectDtos=new ArrayList<>();
}
