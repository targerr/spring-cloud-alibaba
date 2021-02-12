package com.wanggs.alibaba.domain.entity.share;

import java.util.Date;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(name = "share")
public class Share {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    private String title;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 是否原创 0:否 1:是
     */
    @Column(name = "is_original")
    private Long isOriginal;

    /**
     * 作者
     */
    private String author;

    /**
     * 封面
     */
    private String cover;

    /**
     * 概要信息
     */
    private String summary;

    private Integer price;

    /**
     * 下载地址
     */
    @Column(name = "download_url")
    private String downloadUrl;

    /**
     * 下载次数
     */
    @Column(name = "buy_count")
    private Integer buyCount;

    /**
     * 是否显示 0:否 1:是
     */
    @Column(name = "show_flag")
    private Long showFlag;

    /**
     * 审核状态 NOT_YET: 待审核 PASSED:审核通过 REJECTED:审核不通过
     */
    @Column(name = "audit_status")
    private String auditStatus;

    /**
     * 原因
     */
    private String reason;
}