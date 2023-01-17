package com.cong.firefly.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * @author cong
 * @date 2023/1/17 17:32
 */
@Data
public class Label {
    private String user_list;

    private Set<String> ip_list;
}
