package com.ecut.design.Model;



import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 会员积分表
 */
@Entity
@Table(name = "member_integral")
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
    private String  memberGrade;
    /**
     * 金额（满这么么多金额可以的额外积分）
     */
    private BigDecimal money;
    /**
     * 积分
     */
    private int  integral;

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getMemberGrade () {
        return memberGrade;
    }

    public void setMemberGrade (String memberGrade) {
        this.memberGrade = memberGrade;
    }

    public BigDecimal getMoney () {
        return money;
    }

    public void setMoney (BigDecimal money) {
        this.money = money;
    }

    public int getIntegral () {
        return integral;
    }

    public void setIntegral (int integral) {
        this.integral = integral;
    }
}
