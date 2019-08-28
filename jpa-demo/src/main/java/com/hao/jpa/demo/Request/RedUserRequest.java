package com.hao.jpa.demo.Request;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户实体类
 * </p>
 *
 @Null  被注释的元素必须为null
 @NotNull  被注释的元素不能为null
 @AssertTrue  被注释的元素必须为true
 @AssertFalse  被注释的元素必须为false
 @Min(value)  被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 @Max(value)  被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 @DecimalMin(value)  被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 @DecimalMax(value)  被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 @Size(max,min)  被注释的元素的大小必须在指定的范围内。
 @Digits(integer,fraction)  被注释的元素必须是一个数字，其值必须在可接受的范围内
 @Past  被注释的元素必须是一个过去的日期
 @Future  被注释的元素必须是一个将来的日期
 @Pattern(value) 被注释的元素必须符合指定的正则表达式。
 @Email 被注释的元素必须是电子邮件地址
 @Length 被注释的字符串的大小必须在指定的范围内
 @NotEmpty  被注释的字符串必须非空
 @Range  被注释的元素必须在合适的范围内
 ————————————————
 版权声明：本文为CSDN博主「qq920447939」的原创文章，遵循CC 4.0 by-sa版权协议，转载请附上原文出处链接及本声明。
 原文链接：https://blog.csdn.net/qq920447939/article/details/80198438
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "red_user")
@ToString(callSuper = true)
public class RedUserRequest implements Serializable {
    @NotNull(message = "年龄不能为空")
    @Min(1)
    @Max(100)
    private Integer age;//年龄
    @NotNull(message = "姓名不能为空")
    private String name;//姓名
    @NotNull(message = "性别不能为空")
    @Min(0)
    @Max(1)
    private Integer sex;//性别
    @NumberFormat(pattern = "###.##")
    private Double height;//身高
    @NumberFormat(pattern = "###.##")
    private Double weight;//体重
    @NotNull(message = "手机号不能为空")
    @Length(min = 11,max = 11)
    private String phone;//手机号码
    @Length(min = 6,max = 100)
    private String address;//地址

    private Long id;//id
}
