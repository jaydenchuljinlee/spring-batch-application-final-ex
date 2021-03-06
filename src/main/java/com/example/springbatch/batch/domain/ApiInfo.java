package com.example.springbatch.batch.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ApiInfo {

    private String utl;
    private List<? extends ApiRequestVO> apiRequestList;
}
