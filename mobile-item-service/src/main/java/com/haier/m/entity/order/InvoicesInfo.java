package com.haier.m.entity.order;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 发票信息表。
 * <p>Table: <strong>Invoices</strong>
 * <p><table class="er-mapping" cellspacing=0 cellpadding=0 style="border:solid 1 #666;padding:3px;">
 *   <tr style="background-color:#ddd;Text-align:Left;">
 *     <th nowrap>属性名</th><th nowrap>属性类型</th><th nowrap>字段名</th><th nowrap>字段类型</th><th nowrap>说明</th>
 *   </tr>
 *   <tr><td>id</td><td>{@link Integer}</td><td>id</td><td>int</td><td>&nbsp;</td></tr>
 *   <tr><td>isOld</td><td>{@link Integer}</td><td>isOld</td><td>tinyint</td><td>是否是从原开票中间表导过来的数据，如果是导过来的此值为1，但不可再传金税开票</td></tr>
 *   <tr><td>isReInvoice</td><td>{@link Integer}</td><td>isReInvoice</td><td>tinyint</td><td>是否是重新开票</td></tr>
 *   <tr><td>orderProductId</td><td>{@link Integer}</td><td>orderProductId</td><td>int</td><td>网单ID</td></tr>
 *   <tr><td>cOrderType</td><td>{@link Integer}</td><td>cOrderType</td><td>tinyint</td><td>网单类型,1-普通网单,2-差异网单</td></tr>
 *   <tr><td>diffId</td><td>{@link Integer}</td><td>diffId</td><td>int</td><td>差异网单ID</td></tr>
 *   <tr><td>cOrderSn</td><td>{@link String}</td><td>cOrderSn</td><td>varchar</td><td>网单编号(对应WDH)</td></tr>
 *   <tr><td>memberInvoiceId</td><td>{@link Integer}</td><td>memberInvoiceId</td><td>int</td><td>会员发票信息ID,MemberInvoices表的主键</td></tr>
 *   <tr><td>customerCode</td><td>{@link String}</td><td>customerCode</td><td>varchar</td><td>客户编码(对应KHBM)目前不管是普票还是增票都默认传00002001</td></tr>
 *   <tr><td>invoiceTitle</td><td>{@link String}</td><td>invoiceTitle</td><td>varchar</td><td>发票抬头(KHMC)</td></tr>
 *   <tr><td>taxPayerNumber</td><td>{@link String}</td><td>taxPayerNumber</td><td>varchar</td><td>纳税人识别号(KHSH)</td></tr>
 *   <tr><td>registerAddressAndPhone</td><td>{@link String}</td><td>registerAddressAndPhone</td><td>varchar</td><td>注册地址和电话(KHDZ)</td></tr>
 *   <tr><td>bankNameAndAccount</td><td>{@link String}</td><td>bankNameAndAccount</td><td>varchar</td><td>开户银行(KHKHYHZH)</td></tr>
 *   <tr><td>remark</td><td>{@link String}</td><td>remark</td><td>varchar</td><td>备注(BZ)</td></tr>
 *   <tr><td>cOrderAddTime</td><td>{@link String}</td><td>cOrderAddTime</td><td>varchar</td><td>网单生成时间(WDRQ)</td></tr>
 *   <tr><td>sku</td><td>{@link String}</td><td>sku</td><td>varchar</td><td>物料编码(CPDM)</td></tr>
 *   <tr><td>productName</td><td>{@link String}</td><td>productName</td><td>varchar</td><td>商品名称(CPMC)</td></tr>
 *   <tr><td>productCateName</td><td>{@link String}</td><td>productCateName</td><td>varchar</td><td>商品分类(CPXH)</td></tr>
 *   <tr><td>unit</td><td>{@link String}</td><td>unit</td><td>varchar</td><td>计量单位(CPDW)</td></tr>
 *   <tr><td>number</td><td>{@link Integer}</td><td>number</td><td>int</td><td>数量(CPSL)取自网单表中的number</td></tr>
 *   <tr><td>price</td><td>{@link BigDecimal}</td><td>price</td><td>decimal</td><td>含税价(HSDJ)取自网单表中的price</td></tr>
 *   <tr><td>amount</td><td>{@link BigDecimal}</td><td>amount</td><td>decimal</td><td>含税金额(HSJE)取自网单表中的productAmount</td></tr>
 *   <tr><td>nonTaxPrice</td><td>{@link BigDecimal}</td><td>nonTaxPrice</td><td>decimal</td><td>不含税单价(BHSDJ)</td></tr>
 *   <tr><td>nonTaxAmount</td><td>{@link BigDecimal}</td><td>nonTaxAmount</td><td>decimal</td><td>不含税金额(BHSJE)</td></tr>
 *   <tr><td>taxAmount</td><td>{@link BigDecimal}</td><td>taxAmount</td><td>decimal</td><td>税额(JSJE)</td></tr>
 *   <tr><td>taxRate</td><td>{@link BigDecimal}</td><td>taxRate</td><td>decimal</td><td>税率(JSSL)</td></tr>
 *   <tr><td>type</td><td>{@link Integer}</td><td>type</td><td>tinyint</td><td>发票类型,1-增票,2-普票(FPLX)</td></tr>
 *   <tr><td>isTogether</td><td>{@link Integer}</td><td>isTogether</td><td>tinyint</td><td>是否货票同行(HPTX)1-是,2-否</td></tr>
 *   <tr><td>state</td><td>{@link Integer}</td><td>state</td><td>tinyint</td><td>发票状态(FPZT)</td></tr>
 *   <tr><td>lessOrderSn</td><td>{@link String}</td><td>lessOrderSn</td><td>varchar</td><td>less订单号(WLNO)LES返回的以10和79开票的单号</td></tr>
 *   <tr><td>paymentName</td><td>{@link String}</td><td>paymentName</td><td>varchar</td><td>付款方式(SKFS)</td></tr>
 *   <tr><td>sCode</td><td>{@link String}</td><td>sCode</td><td>varchar</td><td>库位编码(KWBM)</td></tr>
 *   <tr><td>orderType</td><td>{@link String}</td><td>orderType</td><td>varchar</td><td>订单类型(DDLX)目前不管普票还是增票暂都默认ZBCC</td></tr>
 *   <tr><td>invoiceNumber</td><td>{@link String}</td><td>invoiceNumber</td><td>text</td><td>税控号码(FPHM)</td></tr>
 *   <tr><td>billingTime</td><td>{@link Integer}</td><td>billingTime</td><td>int</td><td>开票时间(KPRQ)</td></tr>
 *   <tr><td>eaiWriteTime</td><td>{@link Integer}</td><td>eaiWriteTime</td><td>int</td><td>eai回写商城时间(SKRQ)</td></tr>
 *   <tr><td>drawer</td><td>{@link String}</td><td>drawer</td><td>varchar</td><td>开票人(KPMAN)</td></tr>
 *   <tr><td>eaiWriteState</td><td>{@link String}</td><td>eaiWriteState</td><td>varchar</td><td>开票状态(KPZT)</td></tr>
 *   <tr><td>invalidTime</td><td>{@link Integer}</td><td>invalidTime</td><td>int</td><td>发票作废时间(ZFRQ)</td></tr>
 *   <tr><td>firstPushTime</td><td>{@link Integer}</td><td>firstPushTime</td><td>int</td><td>首次推送开票时间(RRRQ)</td></tr>
 *   <tr><td>lastModifyTime</td><td>{@link Integer}</td><td>lastModifyTime</td><td>int</td><td>电商最后更新开票信息时间(GXRQ)</td></tr>
 *   <tr><td>internalSettlement</td><td>{@link String}</td><td>internalSettlement</td><td>varchar</td><td>内部结算单号(LBJSDH)</td></tr>
 *   <tr><td>branchOfficeCode</td><td>{@link String}</td><td>branchOfficeCode</td><td>varchar</td><td>分公司代码(FGSNO)默认为空</td></tr>
 *   <tr><td>orderLineNumber</td><td>{@link String}</td><td>orderLineNumber</td><td>varchar</td><td>订单行号(DDHNO)默认为空</td></tr>
 *   <tr><td>backupFieldA</td><td>{@link String}</td><td>backupFieldA</td><td>varchar</td><td>备用字段1(ADD1)默认为空</td></tr>
 *   <tr><td>backupFieldB</td><td>{@link String}</td><td>backupFieldB</td><td>varchar</td><td>备用字段1(ADD2)默认为空</td></tr>
 *   <tr><td>integralAmount</td><td>{@link BigDecimal}</td><td>integralAmount</td><td>decimal</td><td>积分金额(JFJE)</td></tr>
 *   <tr><td>energySavingAmount</td><td>{@link BigDecimal}</td><td>energySavingAmount</td><td>decimal</td><td>节能补贴金额(JLJE)</td></tr>
 *   <tr><td>energySavingRemark</td><td>{@link String}</td><td>energySavingRemark</td><td>varchar</td><td>节能补贴备注(JLBZ)</td></tr>
 *   <tr><td>statusType</td><td>{@link Integer}</td><td>statusType</td><td>tinyint</td><td>状态类型</td></tr>
 *   <tr><td>success</td><td>{@link Integer}</td><td>success</td><td>tinyint</td><td>此状态类型下是否推送成功</td></tr>
 *   <tr><td>addTime</td><td>{@link Integer}</td><td>addTime</td><td>int</td><td>写入时间</td></tr>
 *   <tr><td>tryNum</td><td>{@link Integer}</td><td>tryNum</td><td>int</td><td>尝试传递的次数</td></tr>
 *   <tr><td>electricFlag</td><td>{@link Integer}</td><td>electricFlag</td><td>int</td><td>电子发票标志，1：电子发票；0：纸质发票</td></tr>
 * </table>
 * @author jixiang
 */
public class InvoicesInfo implements Serializable {

    /** Comment for <code>serialVersionUID</code> */
    private static final long serialVersionUID = 8608579995422574028L;
    private Integer           id;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer value) {
        this.id = value;
    }

    private Integer isOld = 0;

    /**
     * 获取 是否是从原开票中间表导过来的数据，如果是导过来的此值为1，但不可再传金税开票
     */
    public Integer getIsOld() {
        return this.isOld;
    }

    /**
     * 设置 是否是从原开票中间表导过来的数据，如果是导过来的此值为1，但不可再传金税开票
     * @param value 属性值
     */
    public void setIsOld(Integer value) {
        this.isOld = value;
    }

    private Integer isReInvoice = 0;

    /**
     * 获取 是否是重新开票
     */
    public Integer getIsReInvoice() {
        return this.isReInvoice;
    }

    /**
     * 设置 是否是重新开票
     * @param value 属性值
     */
    public void setIsReInvoice(Integer value) {
        this.isReInvoice = value;
    }

    private Integer orderProductId;

    /**
     * 获取 网单ID
     */
    public Integer getOrderProductId() {
        return this.orderProductId;
    }

    /**
     * 设置 网单ID
     * @param value 属性值
     */
    public void setOrderProductId(Integer value) {
        this.orderProductId = value;
    }

    private Integer cOrderType;

    /**
     * 获取 网单类型,1-普通网单,2-差异网单
     */
    public Integer getCOrderType() {
        return this.cOrderType;
    }

    /**
     * 设置 网单类型,1-普通网单,2-差异网单
     * @param value 属性值
     */
    public void setCOrderType(Integer value) {
        this.cOrderType = value;
    }

    private Integer diffId;

    /**
     * 获取 差异网单ID
     */
    public Integer getDiffId() {
        return this.diffId;
    }

    /**
     * 设置 差异网单ID
     * @param value 属性值
     */
    public void setDiffId(Integer value) {
        this.diffId = value;
    }

    private String cOrderSn;

    /**
     * 获取 网单编号(对应WDH)
     */
    public String getCOrderSn() {
        return this.cOrderSn;
    }

    /**
     * 设置 网单编号(对应WDH)
     * @param value 属性值
     */
    public void setCOrderSn(String value) {
        this.cOrderSn = value;
    }

    private Integer memberInvoiceId;

    /**
     * 获取 会员发票信息ID,MemberInvoices表的主键
     */
    public Integer getMemberInvoiceId() {
        return this.memberInvoiceId;
    }

    /**
     * 设置 会员发票信息ID,MemberInvoices表的主键
     * @param value 属性值
     */
    public void setMemberInvoiceId(Integer value) {
        this.memberInvoiceId = value;
    }

    private String customerCode;

    /**
     * 获取 客户编码(对应KHBM)目前不管是普票还是增票都默认传00002001
     */
    public String getCustomerCode() {
        return this.customerCode;
    }

    /**
     * 设置 客户编码(对应KHBM)目前不管是普票还是增票都默认传00002001
     * @param value 属性值
     */
    public void setCustomerCode(String value) {
        this.customerCode = value;
    }

    private String invoiceTitle;

    /**
     * 获取 发票抬头(KHMC)
     */
    public String getInvoiceTitle() {
        return this.invoiceTitle;
    }

    /**
     * 设置 发票抬头(KHMC)
     * @param value 属性值
     */
    public void setInvoiceTitle(String value) {
        this.invoiceTitle = value;
    }

    private String taxPayerNumber;

    /**
     * 获取 纳税人识别号(KHSH)
     */
    public String getTaxPayerNumber() {
        return this.taxPayerNumber;
    }

    /**
     * 设置 纳税人识别号(KHSH)
     * @param value 属性值
     */
    public void setTaxPayerNumber(String value) {
        this.taxPayerNumber = value;
    }

    private String registerAddressAndPhone;

    /**
     * 获取 注册地址和电话(KHDZ)
     */
    public String getRegisterAddressAndPhone() {
        return this.registerAddressAndPhone;
    }

    /**
     * 设置 注册地址和电话(KHDZ)
     * @param value 属性值
     */
    public void setRegisterAddressAndPhone(String value) {
        this.registerAddressAndPhone = value;
    }

    private String bankNameAndAccount;

    /**
     * 获取 开户银行(KHKHYHZH)
     */
    public String getBankNameAndAccount() {
        return this.bankNameAndAccount;
    }

    /**
     * 设置 开户银行(KHKHYHZH)
     * @param value 属性值
     */
    public void setBankNameAndAccount(String value) {
        this.bankNameAndAccount = value;
    }

    private String remark;

    /**
     * 获取 备注(BZ)
     */
    public String getRemark() {
        return this.remark;
    }

    /**
     * 设置 备注(BZ)
     * @param value 属性值
     */
    public void setRemark(String value) {
        this.remark = value;
    }

    private String cOrderAddTime;

    /**
     * 获取 网单生成时间(WDRQ)
     */
    public String getCOrderAddTime() {
        return this.cOrderAddTime;
    }

    /**
     * 设置 网单生成时间(WDRQ)
     * @param value 属性值
     */
    public void setCOrderAddTime(String value) {
        this.cOrderAddTime = value;
    }

    private String sku;

    /**
     * 获取 物料编码(CPDM)
     */
    public String getSku() {
        return this.sku;
    }

    /**
     * 设置 物料编码(CPDM)
     * @param value 属性值
     */
    public void setSku(String value) {
        this.sku = value;
    }

    private String productName;

    /**
     * 获取 商品名称(CPMC)
     */
    public String getProductName() {
        return this.productName;
    }

    /**
     * 设置 商品名称(CPMC)
     * @param value 属性值
     */
    public void setProductName(String value) {
        this.productName = value;
    }

    private String productCateName;

    /**
     * 获取 商品分类(CPXH)
     */
    public String getProductCateName() {
        return this.productCateName;
    }

    /**
     * 设置 商品分类(CPXH)
     * @param value 属性值
     */
    public void setProductCateName(String value) {
        this.productCateName = value;
    }

    private String unit;

    /**
     * 获取 计量单位(CPDW)
     */
    public String getUnit() {
        return this.unit;
    }

    /**
     * 设置 计量单位(CPDW)
     * @param value 属性值
     */
    public void setUnit(String value) {
        this.unit = value;
    }

    private Long number;

    /**
     * 获取 数量(CPSL)取自网单表中的number
     */
    public Long getNumber() {
        return this.number;
    }

    /**
     * 设置 数量(CPSL)取自网单表中的number
     * @param value 属性值
     */
    public void setNumber(Long value) {
        this.number = value;
    }

    private BigDecimal price;

    /**
     * 获取 含税价(HSDJ)取自网单表中的price
     */
    public BigDecimal getPrice() {
        return this.price;
    }

    /**
     * 设置 含税价(HSDJ)取自网单表中的price
     * @param value 属性值
     */
    public void setPrice(BigDecimal value) {
        this.price = value;
    }

    private BigDecimal amount;

    /**
     * 获取 含税金额(HSJE)取自网单表中的productAmount
     */
    public BigDecimal getAmount() {
        return this.amount;
    }

    /**
     * 设置 含税金额(HSJE)取自网单表中的productAmount
     * @param value 属性值
     */
    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

    private BigDecimal nonTaxPrice;

    /**
     * 获取 不含税单价(BHSDJ)
     */
    public BigDecimal getNonTaxPrice() {
        return this.nonTaxPrice;
    }

    /**
     * 设置 不含税单价(BHSDJ)
     * @param value 属性值
     */
    public void setNonTaxPrice(BigDecimal value) {
        this.nonTaxPrice = value;
    }

    private BigDecimal nonTaxAmount;

    /**
     * 获取 不含税金额(BHSJE)
     */
    public BigDecimal getNonTaxAmount() {
        return this.nonTaxAmount;
    }

    /**
     * 设置 不含税金额(BHSJE)
     * @param value 属性值
     */
    public void setNonTaxAmount(BigDecimal value) {
        this.nonTaxAmount = value;
    }

    private BigDecimal taxAmount;

    /**
     * 获取 税额(JSJE)
     */
    public BigDecimal getTaxAmount() {
        return this.taxAmount;
    }

    /**
     * 设置 税额(JSJE)
     * @param value 属性值
     */
    public void setTaxAmount(BigDecimal value) {
        this.taxAmount = value;
    }

    private BigDecimal taxRate;

    /**
     * 获取 税率(JSSL)
     */
    public BigDecimal getTaxRate() {
        return this.taxRate;
    }

    /**
     * 设置 税率(JSSL)
     * @param value 属性值
     */
    public void setTaxRate(BigDecimal value) {
        this.taxRate = value;
    }

    private Integer type;

    /**
     * 获取 发票类型,1-增票,2-普票(FPLX)
     */
    public Integer getType() {
        return this.type;
    }

    /**
     * 设置 发票类型,1-增票,2-普票(FPLX)
     * @param value 属性值
     */
    public void setType(Integer value) {
        this.type = value;
    }

    private Integer isTogether;

    /**
     * 获取 是否货票同行(HPTX)1-是,2-否
     */
    public Integer getIsTogether() {
        return this.isTogether;
    }

    /**
     * 设置 是否货票同行(HPTX)1-是,2-否
     * @param value 属性值
     */
    public void setIsTogether(Integer value) {
        this.isTogether = value;
    }

    private Integer state;

    /**
     * 获取 发票状态(FPZT)
     * WAIT_STATE        = 0; //待开票
     * IN_STATE          = 1; //开票中,商城初次开票推送给EAI的值也为此值
     * COMPLETE_STATE    = 4; //已开票,金税开完税后，回写EAI,EAI回写商城这边的值也为此值
     * CANCEL_STATE      = 5; //已取消开票
     */
    public Integer getState() {
        return this.state;
    }

    /**
     * 设置 发票状态(FPZT)
     * WAIT_STATE        = 0; //待开票
     * IN_STATE          = 1; //开票中,商城初次开票推送给EAI的值也为此值
     * COMPLETE_STATE    = 4; //已开票,金税开完税后，回写EAI,EAI回写商城这边的值也为此值
     * CANCEL_STATE      = 5; //已取消开票
     * @param value 属性值
     */
    public void setState(Integer value) {
        this.state = value;
    }

    private String lessOrderSn;

    /**
     * 获取 less订单号(WLNO)LES返回的以10和79开票的单号
     */
    public String getLessOrderSn() {
        return this.lessOrderSn;
    }

    /**
     * 设置 less订单号(WLNO)LES返回的以10和79开票的单号
     * @param value 属性值
     */
    public void setLessOrderSn(String value) {
        this.lessOrderSn = value;
    }

    private String paymentName;

    /**
     * 获取 付款方式(SKFS)
     */
    public String getPaymentName() {
        return this.paymentName;
    }

    /**
     * 设置 付款方式(SKFS)
     * @param value 属性值
     */
    public void setPaymentName(String value) {
        this.paymentName = value;
    }

    private String sCode;

    /**
     * 获取 库位编码(KWBM)
     */
    public String getSCode() {
        return this.sCode;
    }

    /**
     * 设置 库位编码(KWBM)
     * @param value 属性值
     */
    public void setSCode(String value) {
        this.sCode = value;
    }

    private String orderType;

    /**
     * 获取 订单类型(DDLX)目前不管普票还是增票暂都默认ZBCC
     */
    public String getOrderType() {
        return this.orderType;
    }

    /**
     * 设置 订单类型(DDLX)目前不管普票还是增票暂都默认ZBCC
     * @param value 属性值
     */
    public void setOrderType(String value) {
        this.orderType = value;
    }

    private String invoiceNumber;

    /**
     * 获取 税控号码(FPHM)
     */
    public String getInvoiceNumber() {
        return this.invoiceNumber;
    }

    /**
     * 设置 税控号码(FPHM)
     * @param value 属性值
     */
    public void setInvoiceNumber(String value) {
        this.invoiceNumber = value;
    }

    private Integer billingTime;

    /**
     * 获取 开票时间(KPRQ)
     */
    public Integer getBillingTime() {
        return this.billingTime;
    }

    /**
     * 设置 开票时间(KPRQ)
     * @param value 属性值
     */
    public void setBillingTime(Integer value) {
        this.billingTime = value;
    }

    private Integer eaiWriteTime;

    /**
     * 获取 eai回写商城时间(SKRQ)
     */
    public Integer getEaiWriteTime() {
        return this.eaiWriteTime;
    }

    /**
     * 设置 eai回写商城时间(SKRQ)
     * @param value 属性值
     */
    public void setEaiWriteTime(Integer value) {
        this.eaiWriteTime = value;
    }

    private String drawer;

    /**
     * 获取 开票人(KPMAN)
     */
    public String getDrawer() {
        return this.drawer;
    }

    /**
     * 设置 开票人(KPMAN)
     * @param value 属性值
     */
    public void setDrawer(String value) {
        this.drawer = value;
    }

    private String eaiWriteState;

    /**
     * 获取 开票状态(KPZT)
     */
    public String getEaiWriteState() {
        return this.eaiWriteState;
    }

    /**
     * 设置 开票状态(KPZT)
     * @param value 属性值
     */
    public void setEaiWriteState(String value) {
        this.eaiWriteState = value;
    }

    private Integer invalidTime;

    /**
     * 获取 发票作废时间(ZFRQ)
     */
    public Integer getInvalidTime() {
        return this.invalidTime;
    }

    /**
     * 设置 发票作废时间(ZFRQ)
     * @param value 属性值
     */
    public void setInvalidTime(Integer value) {
        this.invalidTime = value;
    }

    private Integer firstPushTime;

    /**
     * 获取 首次推送开票时间(RRRQ)
     */
    public Integer getFirstPushTime() {
        return this.firstPushTime;
    }

    /**
     * 设置 首次推送开票时间(RRRQ)
     * @param value 属性值
     */
    public void setFirstPushTime(Integer value) {
        this.firstPushTime = value;
    }

    private Integer lastModifyTime;

    /**
     * 获取 电商最后更新开票信息时间(GXRQ)
     */
    public Integer getLastModifyTime() {
        return this.lastModifyTime;
    }

    /**
     * 设置 电商最后更新开票信息时间(GXRQ)
     * @param value 属性值
     */
    public void setLastModifyTime(Integer value) {
        this.lastModifyTime = value;
    }

    private String internalSettlement;

    /**
     * 获取 内部结算单号(LBJSDH)
     */
    public String getInternalSettlement() {
        return this.internalSettlement;
    }

    /**
     * 设置 内部结算单号(LBJSDH)
     * @param value 属性值
     */
    public void setInternalSettlement(String value) {
        this.internalSettlement = value;
    }

    private String branchOfficeCode;

    /**
     * 获取 分公司代码(FGSNO)默认为空
     */
    public String getBranchOfficeCode() {
        return this.branchOfficeCode;
    }

    /**
     * 设置 分公司代码(FGSNO)默认为空
     * @param value 属性值
     */
    public void setBranchOfficeCode(String value) {
        this.branchOfficeCode = value;
    }

    private String orderLineNumber;

    /**
     * 获取 订单行号(DDHNO)默认为空
     */
    public String getOrderLineNumber() {
        return this.orderLineNumber;
    }

    /**
     * 设置 订单行号(DDHNO)默认为空
     * @param value 属性值
     */
    public void setOrderLineNumber(String value) {
        this.orderLineNumber = value;
    }

    private String backupFieldA;

    /**
     * 获取 备用字段1(ADD1)默认为空
     */
    public String getBackupFieldA() {
        return this.backupFieldA;
    }

    /**
     * 设置 备用字段1(ADD1)默认为空
     * @param value 属性值
     */
    public void setBackupFieldA(String value) {
        this.backupFieldA = value;
    }

    private String backupFieldB;

    /**
     * 获取 备用字段1(ADD2)默认为空
     */
    public String getBackupFieldB() {
        return this.backupFieldB;
    }

    /**
     * 设置 备用字段1(ADD2)默认为空
     * @param value 属性值
     */
    public void setBackupFieldB(String value) {
        this.backupFieldB = value;
    }

    private BigDecimal integralAmount;

    /**
     * 获取 积分金额(JFJE)
     */
    public BigDecimal getIntegralAmount() {
        return this.integralAmount;
    }

    /**
     * 设置 积分金额(JFJE)
     * @param value 属性值
     */
    public void setIntegralAmount(BigDecimal value) {
        this.integralAmount = value;
    }

    private BigDecimal energySavingAmount;

    /**
     * 获取 节能补贴金额(JLJE)
     */
    public BigDecimal getEnergySavingAmount() {
        return this.energySavingAmount;
    }

    /**
     * 设置 节能补贴金额(JLJE)
     * @param value 属性值
     */
    public void setEnergySavingAmount(BigDecimal value) {
        this.energySavingAmount = value;
    }

    private String energySavingRemark;

    /**
     * 获取 节能补贴备注(JLBZ)
     */
    public String getEnergySavingRemark() {
        return this.energySavingRemark;
    }

    /**
     * 设置 节能补贴备注(JLBZ)
     * @param value 属性值
     */
    public void setEnergySavingRemark(String value) {
        this.energySavingRemark = value;
    }

    private Integer statusType;

    /**
     * 获取 状态类型
     */
    public Integer getStatusType() {
        return this.statusType;
    }

    /**
     * 设置 状态类型
     * @param value 属性值
     */
    public void setStatusType(Integer value) {
        this.statusType = value;
    }

    private Integer success;

    /**
     * 获取 此状态类型下是否推送成功
     */
    public Integer getSuccess() {
        return this.success;
    }

    /**
     * 设置 此状态类型下是否推送成功
     * @param value 属性值
     */
    public void setSuccess(Integer value) {
        this.success = value;
    }

    private Long addTime;

    /**
     * 获取 写入时间
     */
    public Long getAddTime() {
        return this.addTime;
    }

    /**
     * 设置 写入时间
     * @param value 属性值
     */
    public void setAddTime(Long value) {
        this.addTime = value;
    }

    private Integer tryNum;

    /**
     * 获取 尝试传递的次数
     */
    public Integer getTryNum() {
        return this.tryNum;
    }

    /**
     * 设置 尝试传递的次数
     * @param value 属性值
     */
    public void setTryNum(Integer value) {
        this.tryNum = value;
    }

    /**
     * 电子发票标志
     * 1：电子发票；
     * 0：纸质发票
     */
    private Integer electricFlag = 0;

    public Integer getElectricFlag() {
        return electricFlag;
    }

    public void setElectricFlag(Integer electricFlag) {
        this.electricFlag = electricFlag;
    }

    private String eInvViewUrl;

    public String geteInvViewUrl() {
        return eInvViewUrl;
    }

    public void seteInvViewUrl(String eInvViewUrl) {
        this.eInvViewUrl = eInvViewUrl;
    }

}
