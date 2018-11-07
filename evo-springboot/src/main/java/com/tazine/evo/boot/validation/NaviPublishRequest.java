package com.tazine.evo.boot.validation;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 导航调度请求对象
 *
 * @author jiaer.ly
 * @date 2018/11/06
 */
@Data
public class NaviPublishRequest {

    private String id;

    @NotNull(message = "name 不能为空")
    private String name;

    @Min(message = "不能低于18", value = 18)
    @Max(message = "不能高于30", value = 30)
    private Integer age;
}
