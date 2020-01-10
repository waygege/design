package com.ecut.design.Model;



import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 会员积分表
 */
@Entity
@Table(name = "member_integral")
@Data
public class MemberIntegral {
    public static final String MEMBER_GRADE1="普通会员";
    public static final String MEMBER_GRADE2="黄金会员";
    public static final String MEMBER_GRADE3="白金会员";
    public static final String MEMBER_GRADE4="钻石会员";
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 会员等级
     */
    @ApiModelProperty(value = "memberGrade", required = true, position = 2, example = "普通会员")
    private String  memberGrade;
    /**
     * 金额（满这么么多金额可以的额外积分）
     */
    @ApiModelProperty(value = "money", required = true, position = 2, example = "100.00")
    private BigDecimal money;
    /**
     * 积分
     */
    @ApiModelProperty(value = "integral", required = true, position = 2, example = "10")
    private int  integral;
}
