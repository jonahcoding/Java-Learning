package com.shinrin.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Bill {
    private Integer id;                 // ID
    private String billCode;            // 账单编码
    private String productName;         // 商品名称
    private String productDesc;         // 商品描述
    private String productUnit;         // 商品单位
    private BigDecimal productCount;    // 商品数量
    private BigDecimal totalPrice;      // 总金额
    private Integer isPayment;          // 是否支付
    private Integer createdBy;          // 创建者
    private Date creationDate;          // 创建时间
    private Integer modifyBy;           // 修改者
    private Date modifyDate;            // 修改时间
    private Integer providerId;         // 供应商ID

    private String providerName;        // 供应商名称

    public void setId(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return this.id;
    }
    public void setBillCode(String billCode){
        this.billCode = billCode;
    }
    public String getBillCode(){
        return this.billCode;
    }
    public void setProductName(String productName){
        this.productName = productName;
    }
    public String getProductName(){
        return this.productName;
    }
    public void setProductDesc(String productDesc){
        this.productDesc = productDesc;
    }
    public String getProductDesc(){
        return this.productDesc;
    }
    public void setProductUnit(String productUnit){
        this.productUnit = productUnit;
    }
    public String getProductUnit(){
        return this.productUnit;
    }
    public void setProductCount(BigDecimal productCount){
        this.productCount = productCount;
    }
    public BigDecimal getProductCount(){
        return this.productCount;
    }
    public void setTotalPrice(BigDecimal totalPrice){
        this.totalPrice = totalPrice;
    }
    public BigDecimal getTotalPrice(){
        return this.totalPrice;
    }
    public void setIsPayment(Integer isPayment){
        this.isPayment = isPayment;
    }
    public Integer getIsPayment(){
        return this.isPayment;
    }
    public void setCreatedBy(Integer createdBy){
        this.createdBy = createdBy;
    }
    public Integer getCreatedBy(){
        return this.createdBy;
    }
    public void setCreationDate(Date creationDate){
        this.creationDate = creationDate;
    }
    public Date getCreationDate(){
        return this.creationDate;
    }
    public void setModifyBy(Integer modifyBy){
        this.modifyBy = modifyBy;
    }
    public Integer getModifyBy(){
        return this.modifyBy;
    }
    public void setModifyDate(Date modifyDate){
        this.modifyDate = modifyDate;
    }
    public Date getModifyDate(){
        return this.modifyDate;
    }
    public void setProviderId(Integer providerId){
        this.providerId = providerId;
    }
    public Integer getProviderId(){
        return this.providerId;
    }
    public void setProviderName(String providerName){
        this.providerName = providerName;
    }
    public String getProviderName(){
        return this.providerName;
    }
}