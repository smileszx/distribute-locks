package com.victor.cache.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;

    private Integer orderNo;

    private BigDecimal payMoney;

    private Integer status;

    private Date createDate;

    private Integer deleteFlag;

}