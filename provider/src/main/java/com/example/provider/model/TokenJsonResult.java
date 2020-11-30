package com.example.provider.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author yangpengcheng
 * @ClassName JsonResult
 * @Description:
 * @date 2020/11/2017:39
 */
@Data
@AllArgsConstructor
public class TokenJsonResult {
    private Boolean success;
    private String token;
}
