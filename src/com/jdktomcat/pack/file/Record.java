package com.jdktomcat.pack.file;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 记录
 */
public class Record {

    Long id;

    String orderId;

    String merchantOrderId;

    Integer merchantId;

    Integer modificationType;

    BigDecimal preBalance;

    BigDecimal postBalance;

    BigDecimal preAvailableBalance;

    BigDecimal postAvailableBalance;

    BigDecimal preFrozenBalance;

    BigDecimal postFrozenBalance;

    String remark;

    String createAt;

    String updateAt;


    public Record(Long id,
                  String orderId,
                  String merchantOrderId,
                  Integer merchantId,
                  Integer modificationType,
                  BigDecimal preBalance,
                  BigDecimal postBalance,
                  BigDecimal preAvailableBalance,
                  BigDecimal postAvailableBalance,
                  BigDecimal preFrozenBalance,
                  BigDecimal postFrozenBalance,
                  String remark,
                  String createAt,
                  String updateAt)
    {
        this.id = id;
        this.orderId = orderId;
        this.merchantOrderId = merchantOrderId;
        this.merchantId = merchantId;
        this.modificationType = modificationType;
        this.preBalance = preBalance;
        this.postBalance = postBalance;
        this.preAvailableBalance = preAvailableBalance;
        this.postAvailableBalance = postAvailableBalance;
        this.preFrozenBalance = preFrozenBalance;
        this.postFrozenBalance = postFrozenBalance;
        this.remark = remark;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Long getId() {
        return id;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public Integer getModificationType() {
        return modificationType;
    }

    public BigDecimal getPreBalance() {
        return preBalance;
    }

    public BigDecimal getPostBalance() {
        return postBalance;
    }

    public BigDecimal getPreAvailableBalance() {
        return preAvailableBalance;
    }

    public BigDecimal getPostAvailableBalance() {
        return postAvailableBalance;
    }

    public BigDecimal getPreFrozenBalance() {
        return preFrozenBalance;
    }

    public BigDecimal getPostFrozenBalance() {
        return postFrozenBalance;
    }

    public String getRemark() {
        return remark;
    }

    public String getCreateAt() {
        return createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }
}
