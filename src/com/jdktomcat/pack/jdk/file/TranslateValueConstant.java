package com.jdktomcat.pack.jdk.file;

import com.alibaba.fastjson.JSONObject;

/**
 * @author ZF-Timmy
 * @version V1.0
 * @description 类描述：
 * @date 2024/1/4
 */
public class TranslateValueConstant {

    public static String WorkType = "{\"\":\"请选择\",\"1\":\"收款\",\"2\":\"出款\",\"3\":\"中转\",\"4\":\"下发\",\"5\":\"手动出款\"," + "\"6\":\"风云出款\",\"7\":\"风云入款\",\"8\":\"结汇\",\"9\":\"第三方\",\"10\":\"第四方\",\"11\":\"技术支持\",\"12\":\"U盾\"," + "\"13\":\"三方下发\",\"100\":\"收出款\" }";
    public static String WorkTypeEnglish = "{\"\":\"please select\",\"1\":\"collection\",\"2\":\"payment\",\"3\":\"transit\",\"4\":\"settlement\",\"5\":\"manual payment\"," + "\"6\":\"fengyun payment\",\"7\":\"fengyun collection\",\"8\":\"settlement\",\"9\":\"third party\",\"10\":\"fourth party\",\"11\":\"technical support\",\"12\":\"U shield\"," + "\"13\":\"third settlement\",\"100\":\"collection and payment\" }";

    public static String DeviceType = "{\"UKey\":\"U盾\", \"Press\":\"按盾器\"}";

    public static String AmountStatus = "{\"0\":\"失败\", \"1\":\"成功\"}";

    public static String DeviceStatus = "{\"0\":\"未关联\", \"1\":\"已关联\",\"2\":\"使用中\"}";

    public static String BankWorkType = "{\"\":\"请选择\",\"1\":\"收款\",\"2\":\"出款\",\"3\":\"中转\",\"4\":\"下发\",\"5\":\"手动出款\"," + "\"8\":\"结汇\",\"9\":\"第三方\",\"10\":\"第四方\",\"12\":\"U盾\"," + "\"13\":\"三方下发\",\"100\":\"收出款\" }";
    public static String WorkTypemonitor = "{\"\":\"请选择\",\"1\":\"收款\",\"2\":\"出款\",\"3\":\"中转\",\"4\":\"下发\",\"5\":\"手动出款\",\"100\":\"收出款\"}";
    public static String WorkTypemonitorEnglish = "{\"\":\"please select\",\"1\":\"collection\",\"2\":\"payment\",\"3\":\"transit\",\"4\":\"settlement\",\"5\":\"manual payment\",\"100\":\"collect and payment\"}";

    public static String WorkTypecreate = "{\"1\":\"收款\",\"2\":\"出款\",\"3\":\"中转\",\"4\":\"下发\",\"5\":\"手动出款\"," + "\"6\":\"风云出款\",\"7\":\"风云入款\",\"8\":\"结汇\",\"9\":\"第三方\",\"10\":\"第四方\",\"11\":\"技术支持\",\"12\":\"U盾\", \"13\":\"三方下发\",\"100\":\"收出款\"}";
    public static String cardWorkType = "{\"\":\"请选择\",\"0\":\"支付卡池\",\"1\":\"缓冲卡池\",\"2\":\"储蓄卡池\",\"3\":\"测试卡池\"}";
    public static String Status = "{\"0\":\"停用\",\"1\":\"启用\",\"100\":\"在线\",\"-1\":\"软删除\",\"-2\":\"预启用\",\"-3\":\"交易限额停用\",\"-4\":\"余额超额停用\",\"-5\":\"交易笔数超额停用\",\"-6\":\"未设置转出卡\",\"-7\":\"异常\",\"-8\":\"临时停用\",\"-9\":\"已提走\",\"-10\":\"连接中\",\"-11\":\"待审核\"}";
    public static String StatusEnglish = "{\"0\":\"disable\",\"1\":\"enable\",\"100\":\"on line\",\"-1\":\"fake delete\",\"-2\":\"pre-enble\",\"-3\":\"reach to the total daily limit\",\"-4\":\"reach to the maximun reserved amount\",\"-5\":\"reach to the order limit\",\"-6\":\"unset transfer assined card\",\"-7\":\"abnormal\",\"-8\":\"temporarily disable\",\"-9\":\"taken away\",\"-10\":\"connecting\"}";
    public static String clientMonitorBankStatus = "{\"\":\"请选择\",\"0\":\"停用\",\"1\":\"启用\",\"100\":\"在线\",\"-2\":\"预启用\",\"-3\":\"交易限额停用\",\"-7\":\"异常\",\"-8\":\"临时停用\",\"-9\":\"已提走\"}";
    public static String clientMonitorBankStatusEnglish = "{\"\":\"please select\",\"0\":\"disable\",\"1\":\"enable\",\"100\":\"on line\",\"-2\":\"pre-enble\",\"-3\":\"reach to the total daily limit\",\"-7\":\"abnormal\",\"-8\":\"temporarily disable\",\"-9\":\"taken away\"}";
    public static String Statussearch = "{\"0\":\"停用\",\"1\":\"启用\",\"100\":\"在线\",\"\":\"状态\",\"-1\":\"软删除\"," + "\"-2\":\"预启用\",\"-3\":\"交易限额停用\",\"-4\":\"余额超额停用\",\"-5\":\"交易笔数超额停用\",\"-6\":\"未设置转出卡\"," + "\"-8\":\"临时停用\",\"-7\":\"异常\",\"-9\":\"已提走\"}";
    public static String CardpoolStatus = "{\"\":\"请选择\",\"0\":\"停用\",\"1\":\"启用\"}";
    public static String FastDepositUnMatchPayType = "{\"1\":\"银行转账\", \"110\":\"支付宝转卡\", \"112\":\"银行卡大额充值\", \"113\":\"云闪付转卡\", \"2010\":\"三方银行卡转卡\",\"2020\":\"三方支付宝转帐\", \"2030\":\"三方大额充值\"}";

    public static String TransStatus = "{\"\":\"请选择\",\"0\":\"创建\",\"1\":\"处理中\",\"2\":\"成功处理\",\"3\":\"异常\"}";
    public static String TransType = "{\"\":\"请选择\",\"0\":\"支出\",\"1\":\"收入\",\"2\":\"内转\"}";
    public static String TransOrderType = "{\"\":\"请选择\",\"1\":\"存款交易流水\",\"0\":\"提款交易流水\",\"3\":\"内转交易流水\",\"4\":\"测卡交易流水\"}";
    public static String PayType = "{\"\":\"请选择\",\"0\":\"网银转账\",\"1\":\"银行卡转账\",\"2\":\"银联快捷\",\"3\":\"微信\",\"4\":\"支付宝\",\"5\":\"QQ钱包\",\"6\":\"京东钱包\",\"7\":\"云闪付\",\"110\":\"支付宝转银行卡\",\"112\":\"银行卡大额充值\",\"113\":\"云闪付转银行卡\",\"114\":\"离线支付宝转银行卡\",\"115\":\"微信转银行卡\",\"116\":\"京东金融转卡\",\"999\":\"江西农商码\",\"11\":\"银行卡对公转账\"}";
    public static String BankPayType = "{\"1\":\"银行卡转账\",\"110\":\"支付宝转银行卡\",\"111\":\"支付宝和网银转帐\"}";
    public static String BankType = "{\"\":\"选择银行类型\",\"CMB\":\"招行\",\"ICBC\":\"工行\",\"CCB\":\"建行\",\"BOC\":\"中行\",\"ABC\":\"农行\",\"BCM\":\"交行\",\"SPDB\":\"浦发\",\"CGB\":\"广发\",\"ECITI\":\"中信\",\"CEB\":\"光大\",\"CIB\":\"兴业\",\"PAB\":\"平安\",\"CMBC\":\"民生\",\"HXB\":\"华夏\",\"PSBC\":\"邮政\",\"NBB\":\"宁波\",\"BJB\":\"北京\",\"CZB\":\"浙商\"}";
    public static String UserLevel = "{\"-1\":\"\",\"0\":\"不限\",\"999\":\"VIP0\",\"1\":\"VIP1\",\"2\":\"VIP2\",\"3\":\"VIP3\",\"4\":\"VIP4\",\"5\":\"VIP5\",\"6\":\"VIP6\",\"7\":\"VIP7\",\"8\":\"VIP8\",\"9\":\"VIP9\",\"10\":\"VIP10\",\"11\":\"VIP11\",\"12\":\"VIP12\",\"13\":\"VIP13\",\"14\":\"VIP14\",\"15\":\"VIP15\",\"16\":\"VIP16\",\"17\":\"VIP17\",\"18\":\"VIP18\",\"19\":\"VIP19\",\"20\":\"VIP20\"}";
    public static String BankCardStatus = "{\"0\":\"停用\",\"1\":\"启用\",\"100\":\"在线\",\"\":\"状态\",\"-1\":\"软删除\"," + "\"-2\":\"预启用\",\"-3\":\"交易限额停用\",\"-4\":\"余额超额停用\",\"-5\":\"交易笔数超额停用\",\"-6\":\"未设置转出卡\"," + "\"-8\":\"临时停用\",\"-7\":\"异常\",\"-9\":\"已提走\" }";
    public static String PayChannelStatus = "{\"0\":\"停用\",\"1\":\"启用\",\"-3\":\"交易限额停用\",\"-4\":\"余额超额停用\"}";//"-2":"预启用",
    public static String ClientType = "{\"1\":\"PC端\",\"2\":\"WAP端\",\"4\":\"APP端\",\"6\":\"iOS端\",\"8\":\"Android端\"}";
    public static String type = "{\"1\":\"添加\",\"2\":\"修改\",\"3\":\"删除\"}";
    public static String CategoryType = "{\"Bank_Commit_In\":\"客户端-上报流水\",\"Bank_Login\":\"客户端-登录\",\"Bank_Logout\":\"客户端-登出\",\"Bank_Notify\":\"客户端-出款确认\",\"Bank_Pulse\":\"客户端-客户端心跳\",\"Bank_Register\":\"客户端-银行卡注册\",\"Bank_Withdraw\":\"客户端-抓取订单\",\"Deposit_Create\":\"服务中心-创建充值订单\",\"Deposit_Order_Paid_Success\":\"服务-充值订单完成支付\",\"DepositOrderBankCheckJob\":\"服务-充值银行卡检测任务\",\"DepositOrderNotifyJob_In\":\"服务-充值订单通知任务\",\"DepositOrderPayBankJob\":\"服务-充值银行卡核算任务\",\"DepositOrderPayChannelJob\":\"服务-充值渠道核算任务\",\"DepositOrderVoucherJob\":\"服务-充值凭证任务\",\"filterChannelWithBankCard\":\"服务-银行卡渠道查找\",\"InternalWithdrawOrderPayBankJob\":\"服务-创建内部订单\",\"MerchantDepositChannel\":\"服务-商户充值渠道查找\",\"MerchantDepositOrderJob\":\"服务-充值商户核算任务\",\"MerchantWithdrawOrderJob\":\"服务-提款商户核算任务\",\"payservice-closeorder\":\"服务-手工关闭订单任务\",\"payservice-notifyjob\":\"服务-手工推送订单任务\",\"WithdrawChannelFromBank\":\"服务-银行卡充值渠道查找\",\"WithdrawOrder_Create\":\"服务中心-创建提款订单\",\"WithDrawOrder_Paid_Success\":\"服务-提款订单完成支付\",\"WithdrawOrder_ViewC\":\"服务-提款订单查看\",\"WithdrawOrderPayBankJob\":\"服务-提款银行卡核算任务\",\"WithdrawOrderPayChannelJob\":\"服务-提款渠道核算任务\",\"WithdrawOrderVoucherJobT\":\"服务-提款凭证任务\"}";
    public static String monitorStatus = "{\"\":\"请选择\",\"0\":\"不可用\",\"1\":\"可用\"}";
    public static String transObject = "{\"-99\":\"请选择\",\"0\":\"对内\",\"1\":\"对外\"}";
    public static String orderBy = "{\"LastUpDateTime\":\"LastUpDateTime\",\"Balance\":\"Balance\"}";
    public static String CardWorkTypeCardPoolTypeRelations = "{\"1\":0,\"2\":1,\"3\":4,\"4\":2,\"5\":5,\"6\":3,\"7\":3,\"8\":3,\"9\":3,\"10\":3,\"11\":3,\"12\":3}";
    public static String SourceTypes = "{\"0\":\"会员直充\",\"1\":\"代客充值\",\"2\":\"商户充值\",\"3\":\"额度提现\",\"4\":\"虚拟币注单出款\"}";
    public static String Protocol = "{\"0\":\"trc20\",\"1\":\"erc20\",\"2\":\"omni\"}";
    public static String betType = "{\"0\":\"否\",\"1\":\"是\"}";
    public static String GMTyoe = "{\"\":\"请选择\",\"1\":\"微信\",\"2\":\"支付宝\",\"3\":\"云闪付\"}";
    public static String OperatorType = "{\"\":\"请选择\",\"0\":\"中国移动\",\"1\":\"中国联通\",\"2\":\"中国电信\"}";
    public static String PhoneType = "{\"\":\"请选择\",\"1\":\"个人\",\"2\":\"企业\"}";
    public static String Gender = "{\"\":\"请选择\",\"0\":\"男\",\"1\":\"女\"}";
    //    public static String Archive = "{\"请选择\",\"是\",\"否\"}";
    public static String StautsType = "{\"\":\"请选择\",\"0\":\"正常\",\"1\":\"异常\",\"2\":\"已提走\",\"3\":\"补卡换卡\",\"4\":\"外借\",\"6\":\"删除\"}";
    public static String RoleType = "{\"\":\"请选择\",\"0\":\"收款\",\"1\":\"出款\",\"2\":\"下发\",\"4\":\"中转\",\"5\":\"手动出款\"," + "\"6\":\"第四方\",\"13\":\"三方下发\",\"100\":\"收出款\"}";
    public static String RoleTypeEnglish = "{\"\":\"please select\",\"0\":\"collection\",\"1\":\"payment\",\"2\":\"settlement\",\"4\":\"transit\",\"5\":\"manual payment\"," + "\"6\":\"fourth party\",\"13\":\"third party settlement\",\"100\":\"collection and payment\"}";
    public static String DepositStatus = "{\"\":\"请选择\",\"0\":\"手工充值\",\"1\":\"自动充值\",\"-1\":\"系统外充值\", \"2\":\"人工代充\"}";
    public static String WithdrawStatus = "{\"\":\"请选择\",\"0\":\"手工下发\",\"1\":\"自动下发\",\"-1\":\"系统外下发\"}";
    public static String IpStatus = "{\"\":\"请选择\",\"0\":\"停用\",\"1\":\"启用\",\"2\":\"删除\"}";
    public static String MerchantStatus = "{\"0\":\"停用\",\"1\":\"启用\",\"-1\":\"软删除\"}";
    public static String OrderType = "{\"0\":\"商户订单\",\"1\":\"超额内转订单\",\"2\":\"低额内转订单\",\"3\":\"充值测试转账订单\",\"4\":\"提款测试转账订单\",\"5\":\"卡异常转出金额\",\"6\":\"下发测试转账订单\",\"10\":\"三方测试订单\",\"100\":\"父订单\",\"888\":\"内转代付\",\"-1\":\"代理订单\"}";
    public static String NeizhuanStatus = "{\"\":\"请选择\",\"0\":\"创建\",\"1\":\"处理中\",\"3\":\"成功\",\"5\":\"超时\",\"7\":\"失败\"}";
    public static String XiafaStatus = "{\"\":\"请选择\",\"0\":\"创建\",\"1\":\"处理中\",\"3\":\"成功\",\"6\":\"超时失败\",\"7\":\"失败\",\"8\":\"下发审核中\"}";
    public static String IsUkey = "{\"\":\"请选择\",\"0\":\"是\",\"1\":\"否\"}";
    public static String IsCard = "{\"\":\"请选择\",\"0\":\"是\",\"1\":\"否\"}";
    public static String IsReportBad = "{\"\":\"请选择\",\"0\":\"否\",\"1\":\"是\"}";
    public static String BankTypeU = "{\"0\":\"个人\",\"1\":\"企业\",\"\":\"未设置\"}";
    public static String FinishTypes = "{\"A\":\"自动\",\"M\":\"手动\"}";

    // 银行卡客户端
    public static String ClientStatus = "{\"\":\"请选择\",\"1\":\"启用\",\"0\":\"停用\",\"-1\":\"软删除\",\"100\":\"在线\",\"-100\":\"异常\"}";
    public static String ClientStatusEnglish = "{\"\":\"please select\",\"1\":\"enble\",\"0\":\"disable\",\"-1\":\"fake delete\",\"100\":\"on line\",\"-100\":\"abnormal\"}";
    public static String ClientStatusTwo = "{\"\":\"请选择\",\"1\":\"启用\",\"0\":\"停用\",\"100\":\"在线\"}";
    public static String ClientStatusTwoEnglish = "{\"\":\"please select\",\"1\":\"enble\",\"0\":\"disable\",\"100\":\"on line\"}";
    public static String ClientWorkType = "{\"\":\"请选择\",\"1\":\"收款\",\"2\":\"出款\",\"3\":\"中转\",\"4\":\"下发\",\"100\":\"收出款\"}";


    //订单状态
    public static String OrderStatus = "{\"0\":\"创建\",\"1\":\"处理中\",\"2\":\"清算中\",\"3\":\"成功\",\"4\":\"手工补单\",\"5\":\"超时\",\"6\":\"超时失败\",\"7\":\"失败\",\"8\":\"下发审核中\",\"11\":\"手动处理中\",\"-1\":\"挂起\", \"-2\":\"未支付订单\", \"19\":\"冲正\"}";
    public static String OrderStatusEnglish = "{\"0\":\"created\",\"1\":\"processing\",\"2\":\"in liquidation\",\"3\":\"auto success\",\"4\":\"manual success\",\"5\":\"overdue\",\"6\":\"timeout failed\",\"7\":\"failed\",\"8\":\"issuing review\",\"11\":\"manual processing\",\"-1\":\"hang\", \"-2\":\"unpaid order\"}";

    public static String OrderStatusW = "{\"0\":\"创建\",\"1\":\"处理中\",\"3\":\"成功\",\"4\":\"手工补单\",\"5\":\"超时\",\"6\":\"超时失败\",\"7\":\"失败\",\"11\":\"手动处理中\"}";
    public static String OrderStatusWEnglish = "{\"0\":\"created\",\"1\":\"processing\",\"3\":\"auto success\",\"4\":\"manual success\",\"5\":\"overdue\",\"6\":\"timeout failed\",\"7\":\"failed\",\"11\":\"manual processing\"}";

    public static String OrderStatusD = "{\"0\":\"创建\",\"1\":\"处理中\",\"3\":\"成功\", \"5\":\"超时\",\"6\":\"超时失败\",\"7\":\"失败\"}";
    public static String OrderStatusDEnglish = "{\"0\":\"created\",\"1\":\"processing\",\"3\":\"auto success\", \"5\":\"overdue\",\"6\":\"timeout failed\",\"7\":\"failed\"}";

    public static String OrderStatusDT = "{\"0\":\"创建\",\"1\":\"处理中\",\"3\":\"成功\",\"4\":\"手工补单\",\"5\":\"超时\",\"6\":\"超时失败\",\"7\":\"失败\",\"-2\":\"待审核\"}";
    public static String MerchantDepositOrderStatus = "{\"1\":\"待审核\",\"4\":\"成功\",\"5\":\"失败\"}";
    public static String OrderStatusDTEnglish = "{\"0\":\"created\",\"1\":\"processing\",\"3\":\"auto success\",\"4\":\"manual success\",\"5\":\"overdue\",\"6\":\"timeout failed\",\"7\":\"failed\",\"-2\":\"wait review\"}";

    public static String OrderStatusDTOut = "{\"0\":\"创建\",\"1\":\"处理中\",\"3\":\"成功\",\"4\":\"手工补单\",\"5\":\"超时\",\"6\":\"超时失败\",\"7\":\"失败\",\"-2\":\"待审核\",\"19\":\"冲正\"}";
    public static String OrderStatusAudit = "{\"1\":\"黑名单拦截\",\"2\":\"规则拦截\",\"3\":\"待审核订单\",\"4\":\"审核通过\",\"5\":\"审核不通过\"}";
    public static String OrderStatusDTOutEnglish = "{\"1\":\"processing\",\"3\":\"auto success\",\"4\":\"manual success\",\"5\":\"overdue\",\"6\":\"timeout failed\",\"7\":\"failed\",\"-2\":\"wait review\",\"19\":\"justify\"}";

    public static String OrderStatusThird = "{\"0\":\"创建\",\"1\":\"处理中\",\"3\":\"成功\",\"4\":\"手工补单\",\"5\":\"超时\",\"6\":\"超时失败\",\"7\":\"失败\",\"-2\":\"待审核\"}";
    public static String OrderStatusThirdEnglish = "{\"0\":\"created\",\"1\":\"processing\",\"3\":\"auto success\",\"4\":\"manual success\",\"5\":\"overdue\",\"6\":\"timeout failed\",\"7\":\"failed\",\"-2\":\"wait review\"}";

    public static String ApiOrderApproveStatus = "{\"0\":\"待审核\",\"1\":\"通过\",\"2\":\"拒绝\"}";


    //提款待处理订单状态-搜索
    public static String PaymentPendingOrderStatusSearch = "{\"0\":\"创建\",\"1\":\"处理中\",\"11\":\"手动处理中\"}";
    public static String PaymentPendingOrderStatusSearchEnglish = "{\"0\":\"created\",\"1\":\"processing\",\"11\":\"manual processing\"}";

    //极速充值订单状态
    public static String OrderStatusFastDeposit = "{\"\":\"请选择\"," + OrderConstant.D_O_STATUS_CREATE + ":\"创建\"," + OrderConstant.D_O_STATUS_MATCHED + ":\"处理中\"," + OrderConstant.D_O_STATUS_CONFIRM + ":\"已确认\"," + OrderConstant.D_O_STATUS_MATCHED_EXPIED + ":\"超时未确认\"," + OrderConstant.D_O_STATUS_CANCEL + ":\"已取消\"," + OrderConstant.D_O_STATUS_MATCHED_EXPIED_CONFIRM + ":\"超时已确认\"," + OrderConstant.D_O_STATUS_MATCHED_EXPIED_CANCEL + ":\"超时已取消\"," + OrderConstant.D_STATUS_WAIT_CONFIRM + ":\"提款待确认\"," + OrderConstant.FAIL + ":\"失败\"}";

    //极速提款订单状态
    public static String OrderStatusFastWithdraw = "{\"\":\"请选择\"," + OrderConstant.W_O_STATUS_CREATE + ":\"创建\"," + OrderConstant.W_O_STATUS_MATCHED + ":\"处理中\"," + OrderConstant.W_O_STATUS_CONFIRM + ":\"已确认\"," + OrderConstant.W_O_STATUS_EXPIED_AUTO + ":\"超时转自出\"," + OrderConstant.W_O_STATUS_MATCHED_EXPIED + ":\"超时未确认\"," + OrderConstant.W_O_STATUS_CANCEL + ":\"已取消\"," + OrderConstant.W_O_STATUS_MATCHED_EXPIED_CONFIRM + ":\"超时已确认\"," + OrderConstant.W_O_STATUS_MATCHED_EXPIED_CANCEL + ":\"超时已取消\"," + OrderConstant.W_O_STATUS_MATCHED_EXPIED_MANUAL + ":\"超时转手动\"," + OrderConstant.W_O_STATUS_CANCEL_AUTO + ":\"取消转自出\"," + OrderConstant.O_STATUS_WAIT_CONFIRM + ":\"待确认\"," + OrderConstant.O_STATUS_TWO_MATCHED + ":\"二次匹配中\"}";

    //极速提款订单状态
    public static String OrderStatusFastWithdrawOut = "{" + OrderConstant.W_O_STATUS_CREATE + ":\"创建\"," + OrderConstant.W_O_STATUS_MATCHED + ":\"处理中\"," + OrderConstant.W_O_STATUS_CONFIRM + ":\"已确认\"," + OrderConstant.W_O_STATUS_EXPIED_AUTO + ":\"超时转自出\"," + OrderConstant.W_O_STATUS_MATCHED_EXPIED + ":\"超时未确认\"," + OrderConstant.W_O_STATUS_CANCEL + ":\"已取消\"," + OrderConstant.W_O_STATUS_EXPIRED_UNMATCHED + ":\"超时未匹配\"," + OrderConstant.W_O_STATUS_MATCHED_EXPIED_CONFIRM + ":\"超时已确认\"," + OrderConstant.W_O_STATUS_MATCHED_EXPIED_CANCEL + ":\"超时已取消\"," + OrderConstant.W_O_STATUS_MATCHED_EXPIED_MANUAL + ":\"超时转手动\"," + OrderConstant.W_O_STATUS_CANCEL_AUTO + ":\"取消转自出\"," + OrderConstant.O_STATUS_WAIT_CONFIRM + ":\"待确认\"," + OrderConstant.O_STATUS_TWO_MATCHED + ":\"二次匹配中\"," + OrderConstant.O_STATUS_REMATCH + ":\"重推匹配中\"," + OrderConstant.O_STATUS_REMATCH_SECOND + ":\"重推二次匹配中\"," + OrderConstant.O_STATUS_JUSTIFY + ":\"冲正\"," + OrderConstant.O_STATUS_CONFIRM_PRIOR + ":\"已优先确认\"}";

    public static String HankWithdrawType = "{\"-1\":\"系统异常出款订单\",\"0\":\"正常出款\",\"1\":\"无渠道\",\"2\":\"商户余额不足\",\"3\":\"多次提款失败\",\"4\":\"同名提款\",\"5\":\"直接手动\",\"8\":\"超过转手动金额设置值\",\"7\":\"不支持银行转手动\",\"6\":\"超过最大金额限制\", \"9\":\"银行维护\", \"10\":\"自动转手动\", \"11\":\"代付转手动\",\"12\":\"风控审核失败订单\",\"13\":\"超过最大提款次数\",\"14\":\"提款姓名长度超限\",\"15\":\"非法提款信息\",\"16\":\"订单金额不在商户进单金额区间\",\"17\":\"申请卡不支持提款\",\"20\":\"站点结算\",\"30\":\"黑名单用户提现\"}";//手动出款类型
    public static String HankWithdrawTypeEnglish = "{\"-1\":\"system abnormal withdrawal order\",\"0\":\"normal withdrawal\",\"1\":\"no channel\",\"2\":\"merchant balance not enough\",\"3\":\"multiple withdrawals failed\",\"4\":\"same name withdrawal\",\"5\":\"direct to manual\",\"6\":\"exceeded the manual transfer amount setting value\",\"7\":\"does not support bank transfer\",\"8\":\"exceed the maximum amount limit\", \"9\":\"bank maintenance\", \"10\":\"automatic to manual\", \"11\":\"transfer payment to manual\",\"12\":\"risk control review failed orders\",\"13\":\"maximum number of withdrawals\",\"14\":\"withdrawals length limit\",\"20\":\"Site settlement\",\"30\":\"Black User\"}";//手动出款类型
    public static String AllowTransHankWithdrawType = "{\"-1\":\"系统异常出款订单\",\"0\":\"正常出款\",\"1\":\"无渠道\",\"2\":\"商户余额不足\",\"3\":\"多次提款失败\",\"4\":\"风控转手动\",\"5\":\"直接手动\",\"8\":\"超过转手动金额设置值\",\"7\":\"不支持银行转手动\",\"6\":\"超过最大金额限制\", \"9\":\"银行维护\", \"10\":\"银行转手动\",\"12\":\"风控审核失败订单\",\"20\":\"站点结算\",\"30\":\"黑名单用户提现\"}";//手动出款类型


    public static String OrderStatusSFXF = "{\"\":\"请选择\",\"0\":\"创建\",\"1\":\"处理中\",\"3\":\"成功\",\"101\":\"通知成功\",\"102\":\"通知失败\",\"6\":\"超时失败\",\"7\":\"失败\"}";
    public static String OrderStatusSFXFEnglish = "{\"\":\"please select\",\"0\":\"created\",\"1\":\"processing\",\"3\":\"auto success\",\"101\":\"notify success\",\"102\":\"notify failed\",\"6\":\"timeout failed\",\"7\":\"failed\"}";

    public static String handOrderStatus = "{\"\":\"请选择\",\"0\":\"创建\",\"1\":\"处理中\",\"3\":\"成功\",\"5\":\"超时\",\"6\":\"超时失败\",\"7\":\"失败\"}";
    public static String handOrderStatusEnglish = "{\"\":\"please select\",\"0\":\"created\",\"1\":\"processing\",\"3\":\"auto success\",\"5\":\"overdue\",\"6\":\"timeout failed\",\"7\":\"failed\"}";

    public static String historyHandOrderStatus = "{\"4\":\"手工补单\",\"7\":\"失败\"}";
    public static String historyHandOrderStatusEnglish = "{\"4\":\"manual success\",\"7\":\"failed\"}";

    public static String historyHandOrderOutStatus = "{\"4\":\"手工补单\",\"7\":\"失败\",\"19\":\"冲正\"}";
    public static String historyHandOrderStatusOutEnglish = "{\"4\":\"manual success\",\"7\":\"failed\",\"19\":\"justify\"}";

    public static String OrderStatusM = "{\"\":\"请选择\",\"0\":\"创建\",\"3\":\"成功\",\"6\":\"超时失败\",\"7\":\"失败\"}";

    public static String CloseType = "{\"\":\"请选择\",\"0\":\"自动\",\"1\":\"手动\"}";
    public static String CloseTypeEnglish = "{\"\":\"please select\",\"0\":\"auto\",\"1\":\"manual\"}";


    public static String PayPoolType = "{\"\":\"未设置\",\"1\":\"三方支付池\",\"2\":\"银行卡支付池\",\"3\":\"极速支付池\"}";
    //报表模块
    public static String MerchantTransType = "{\"0\":\"充值\",\"1\":\"提款\",\"2\":\"准备金\",\"3\":\"商户下发\"}";
    public static String MerchantTransTypeEnglish = "{\"0\":\"deposit\",\"1\":\"withdrawal\",\"2\":\"ready amount\",\"3\":\"merchant place an internal\"}";


    public static String OrderNotifyStatus = "{\"0\":\"未成功通知\",\"1\":\"已成功通知\",\"2\":\"通知超时异常\"}";
    public static String OrderNotifyStatusEnglish = "{\"0\":\"failed notification\",\"1\":\"successful notification\",\"2\":\"abnormal notification\"}";
    public static String APPROVE_STATUS = "{\"1\":\"待财务审核\",\"4\":\"审核通过\", \"5\":\"财务拒绝\"}";
    public static String MerchantOrderStatus = "{\"0\":\"未审核\",\"1\":\"审核通过\",\"2\":\"审核不通过\"}";
    public static String PaymentPool_PayChannelStatus = "{\"1\":\"启用\",\"0\":\"停用\"}";
    public static String PaymentChannelWorkType = "{\"1\":\"收款\",\"2\":\"出款\"}";

    //用户状态
    public static String userStatus = "{\"0\":\"启用\",\"1\":\"禁用\"}";
    public static String userStatusEnglish = "{\"0\":\"enable\",\"1\":\"disable\"}";
    //角色状态
    public static String roleStatus = "{\"0\":\"启用\",\"1\":\"禁用\"}";
    public static String roleStatusEnglish = "{\"0\":\"enable\",\"1\":\"disable\"}";


    //订单角色
    public static String orderRole = "{\"1\":\"订单管理员\",\"2\":\"订单操作员\"}";

    //订单类型
    public static String HandPayType = "{\"\":\"请选择\",\"11\":\"银行卡转账\",\"21\":\"虚拟币交易\"}";
    public static String HandPayTypeEnglish = "{\"\":\"please select\",\"11\":\"bank card transfer\",\"21\":\"virtual currency transaction\"}";


    //订单分配状态
    public static String orderAllotStatus = "{\"0\":\"未分配\",\"1\":\"已分配\"}";

    //客户端版本号状态
    public static String ClientVersionStatus = "{\"1\":\"启用\",\"0\":\"停用\"}";
    public static String ClientVersionStatusEnglish = "{\"1\":\"enable\",\"0\":\"disable\"}";


    public static String bankCard_upDown_status = "{\"1\":\"上卡\",\"2\":\"下卡\"}";
    public static String bankCard_upDown_statusEnglish = "{\"1\":\"on card\",\"2\":\"off card\"}";

    //卡池优先级排序配置key
    public static String cardPriority_config_key = "{\"withdraw\":\"出款\",\"tranit\":\"中转\",\"issue\":\"下发\"}";

    //卡池优先级排序配置key
    public static String cardPriority_config_value = "{\"0\":\"低级\",\"1\":\"中级\",\"2\":\"高级\"}";

    public static String clientType = "{\"0\":\"PC客户端\",\"1\":\"手机银行\"}";

    public static String walletType = "{\"0\":\"冷钱包\",\"1\":\"热钱包\"}";


    public static String LEVELS = "{\"0\":\"不限\",\"999\":\"VIP0\",\"1\":\"VIP1\",\"2\":\"VIP2\",\"3\":\"VIP3\",\"4\":\"VIP4\",\"5\":\"VIP5\",\"6\":\"VIP6\",\"7\":\"VIP7\",\"8\":\"VIP8\",\"9\":\"VIP9\",\"10\":\"VIP10\",\"11\":\"VIP11\",\"12\":\"VIP12\",\"13\":\"VIP13\",\"14\":\"VIP14\",\"15\":\"VIP15\",\"16\":\"VIP16\",\"17\":\"VIP17\",\"18\":\"VIP18\",\"19\":\"VIP19\",\"20\":\"VIP20\"}";

    /**
     * 手动出款订单锁定类型
     */
    public static String orderLockType = "{\"1\":\"启用\",\"0\":\"停用\"}";

    public static String merchantType = "{\"0\":\"内部商户\",\"1\":\"外部商户\",\"2\":\"外部极速\"}";

    public static String MerchantDepositStatus = "{\"0\":\"创建\",\"1\":\"处理中\",\"2\":\"成功\",\"3\":\"失败\"}";

    public static String deviceType = "{\"0\":\"短信\", \"1\":\"手机银行\"}";

    public static String serviceName = "{\"bankServer\":\"bankServer\",\"thirdPay\":\"三方聚合\",\"bankServer-uat\":\"bankServer-预发\",\"thirdPay-uat\":\"三方聚合-预发\", \"api\":\"api网关\"}";

    public static String UserStatus = "{\"0\":\"启用\",\"1\":\"停用\"}";

    public static String DelFlag = "{\"1\":\"删除\"}";

    public static String matchType = "{\"0\":\"PC自动机\",\"1\":\"短信\",\"2\":\"手机银行\"}";


    //极速提款日志操作类型
    public static String OrderStatusFastWithdrawLogOperateType = "{\"\":\"请选择\"," + LogTypeConstant.W_O_STATUS_CREATE + ":\"订单创建\"," + LogTypeConstant.W_O_STATUS_MATCHED + ":\"极速匹配\"," + LogTypeConstant.W_O_STATUS_CONFIRM + ":\"确认订单\"," + LogTypeConstant.W_O_STATUS_EXPIED_AUTO + ":\"超时转自出\"," + LogTypeConstant.W_O_STATUS_MATCHED_EXPIED + ":\"匹配超时\"," + LogTypeConstant.W_O_STATUS_CANCEL + ":\"取消订单\"," + LogTypeConstant.W_O_STATUS_EXPIRED_UNMATCHED + ":\"超时转自出自动进入超时未匹配\"," + LogTypeConstant.W_O_STATUS_MATCHED_EXPIED_CONFIRM + ":\"超时已确认\"," + LogTypeConstant.W_O_STATUS_MATCHED_EXPIED_CANCEL + ":\"超时已取消\"," + LogTypeConstant.W_O_STATUS_MATCHED_EXPIED_MANUAL + ":\"超时转手动\"," + LogTypeConstant.W_O_STATUS_CANCEL_AUTO + ":\"手动转自出\"," + LogTypeConstant.O_STATUS_WAIT_CONFIRM + ":\"提款待确认\"," + LogTypeConstant.O_STATUS_TWO_MATCHED + ":\"二次匹配中\"," + LogTypeConstant.PRIORITY_CONFIRM + ":\"优先匹配\"," + LogTypeConstant.JOIN_MOST_PRIORITY + ":\"加入最优先匹配池\"," + LogTypeConstant.SUB_HAND_OUT + ":\"子单转手出\"," + LogTypeConstant.SYSTEM + ":\"/\"," + LogTypeConstant.ORDER_MATCH_UPDATE + ":\"订单匹配顺序更新\"," + LogTypeConstant.HAND_OUT_ORDER_MATCHED + ":\"手动出款订单列表-处理中\"," + LogTypeConstant.CHANGE_THIRD_OUT + ":\"转三方出款\"," + LogTypeConstant.O_STATUS_CONFIRM_WITHDRAW + ":\"确认提款\"," + LogTypeConstant.W_O_CHANGE_HAND_OUT + ":\"转手动出款\"," + LogTypeConstant.CANCEL_JOIN_MOST_PRIORITY + ":\"取消加入最优先匹配池\"," + LogTypeConstant.O_STATUS_REMATCH + ":\"重推匹配\"," + LogTypeConstant.O_STATUS_REMATCH_SECOND + ":\"重推二次匹配中\"," + LogTypeConstant.O_STATUS_JUSTIFY + ":\"冲正\","
            // 新增分配至极速
            + LogTypeConstant.DISTRIBUTION_MATCHUP + ":\"分配至极速\"," + LogTypeConstant.O_STATUS_CONFIRM_PRIOR + ":\"优先确认\"}";

    //极速提款日志订单类型
    public static String OrderStatusFastWithdrawLogOrderType =
            "{\"\":\"请选择\"," + LogTypeWithdrawOrderConstant.W_O_STATUS_CREATE + ":\"创建\"," + LogTypeWithdrawOrderConstant.W_O_STATUS_MATCHED + ":\"处理中\"," + LogTypeWithdrawOrderConstant.W_O_STATUS_CONFIRM + ":\"已确认\"," + LogTypeWithdrawOrderConstant.W_O_STATUS_EXPIED_AUTO + ":\"超时转自出\"," + LogTypeWithdrawOrderConstant.W_O_STATUS_MATCHED_EXPIED + ":\"超时未确认\"," + LogTypeWithdrawOrderConstant.W_O_STATUS_CANCEL + ":\"已取消\"," + LogTypeWithdrawOrderConstant.W_O_STATUS_EXPIRED_UNMATCHED + ":\"超时未匹配\"," + LogTypeWithdrawOrderConstant.W_O_STATUS_MATCHED_EXPIED_CONFIRM + ":\"超时已确认\"," + LogTypeWithdrawOrderConstant.W_O_STATUS_MATCHED_EXPIED_CANCEL + ":\"超时已取消\"," + LogTypeWithdrawOrderConstant.W_O_STATUS_MATCHED_EXPIED_MANUAL + ":\"超时转手动\"," + LogTypeWithdrawOrderConstant.W_O_STATUS_CANCEL_AUTO + ":\"取消转自出\"," + LogTypeWithdrawOrderConstant.O_STATUS_WAIT_CONFIRM + ":\"提款待确认\"," + LogTypeWithdrawOrderConstant.O_STATUS_TWO_MATCHED + ":\"二次匹配中\"," + LogTypeWithdrawOrderConstant.PRIORITY_CONFIRM + ":\"优先匹配\"," + LogTypeWithdrawOrderConstant.JOIN_MOST_PRIORITY + ":\"加入最优先匹配池\"," + LogTypeWithdrawOrderConstant.SUB_HAND_OUT + ":\"子单转手出\"," + LogTypeWithdrawOrderConstant.SYSTEM + ":\"/\"," + LogTypeWithdrawOrderConstant.ORDER_MATCH_UPDATE + ":\"订单匹配顺序更新\"," + LogTypeWithdrawOrderConstant.HAND_OUT_ORDER_MATCHED + ":\"手动出款订单列表-处理中\"," + LogTypeConstant.CHANGE_THIRD_OUT + ":\"三方提款订单列表-创建\"," + LogTypeWithdrawOrderConstant.O_STATUS_MATCHED_SUCCESS + ":\"匹配成功\"," + LogTypeWithdrawOrderConstant.W_O_OUT_HAND_ORDER_LIST_HANDING + ":\"外部手动出款订单列表-手动处理中\"," + LogTypeWithdrawOrderConstant.O_STATUS_REMATCH + ":\"重推匹配中\"," + LogTypeWithdrawOrderConstant.O_STATUS_REMATCH_SECOND + ":\"重推二次匹配中\"," + LogTypeWithdrawOrderConstant.O_STATUS_JUSTIFY + ":\"冲正\","
            // 新增状态极速提款订单-创建
            + LogTypeConstant.W_O_STATUS_MATCHUP_CREATE + ":\"极速提款订单-创建\"," + LogTypeWithdrawOrderConstant.O_STATUS_CONFIRM_PRIOR + ":\"已优先确认\"}";


    //极速充值日志操作类型
    public static String OrderStatusFastDepositLogOperateType = "{\"\":\"请选择\"," + LogOperateDepositConstant.W_O_STATUS_CREATE + ":\"订单创建\"," + LogOperateDepositConstant.W_O_STATUS_MATCHED + ":\"极速匹配\"," + LogOperateDepositConstant.W_O_STATUS_CONFIRM + ":\"确认订单\"," + LogOperateDepositConstant.W_O_STATUS_EXPIED_AUTO + ":\"超时转自出\"," + LogOperateDepositConstant.W_O_STATUS_MATCHED_EXPIED + ":\"超时未确认\"," + LogOperateDepositConstant.W_O_STATUS_CANCEL + ":\"取消订单\"," + LogOperateDepositConstant.W_O_STATUS_EXPIRED_UNMATCHED + ":\"超时未匹配\"," + LogOperateDepositConstant.W_O_STATUS_MATCHED_EXPIED_CONFIRM + ":\"超时已确认\"," + LogOperateDepositConstant.W_O_STATUS_MATCHED_EXPIED_CANCEL + ":\"超时已取消\"," + LogOperateDepositConstant.W_O_STATUS_MATCHED_EXPIED_MANUAL + ":\"超时转手动\"," + LogOperateDepositConstant.W_O_STATUS_CANCEL_AUTO + ":\"手动转自出\"," + LogOperateDepositConstant.O_STATUS_WAIT_CONFIRM + ":\"提款待确认\"," + LogOperateDepositConstant.O_STATUS_TWO_MATCHED + ":\"二次匹配中\"," + LogOperateDepositConstant.PRIORITY_CONFIRM + ":\"优先匹配\"," + LogOperateDepositConstant.JOIN_MOST_PRIORITY + ":\"加入最优先匹配池\"," + LogOperateDepositConstant.SUB_HAND_OUT + ":\"子单转手出\"," + LogOperateDepositConstant.SYSTEM + ":\"/\"," + LogOperateDepositConstant.ORDER_MATCH_UPDATE + ":\"订单匹配顺序更新\"," + LogOperateDepositConstant.HAND_OUT_ORDER_MATCHED + ":\"手动出款订单列表-处理中\"," + LogOperateDepositConstant.O_STATUS_REMATCH + ":\"重推匹配中\"," + LogOperateDepositConstant.O_STATUS_REMATCH_SECOND + ":\"重推二次匹配中\"," + LogOperateDepositConstant.O_STATUS_JUSTIFY + ":\"冲正\"," + LogOperateDepositConstant.O_STATUS_CONFIRM_PRIOR + ":\"优先确认\"}";

    //极速充值日志订单类型
    public static String OrderStatusFastDepositLogOrderType = "{\"\":\"请选择\"," + LogOrderDepositConstant.W_O_STATUS_CREATE + ":\"创建\"," + LogOrderDepositConstant.W_O_STATUS_MATCHED + ":\"处理中\"," + LogOrderDepositConstant.W_O_STATUS_CONFIRM + ":\"已确认\"," + LogOrderDepositConstant.W_O_STATUS_EXPIED_AUTO + ":\"超时转自出\"," + LogOrderDepositConstant.W_O_STATUS_MATCHED_EXPIED + ":\"超时未确认\"," + LogOrderDepositConstant.W_O_STATUS_CANCEL + ":\"已取消\"," + LogOrderDepositConstant.W_O_STATUS_EXPIRED_UNMATCHED + ":\"超时未匹配\"," + LogOrderDepositConstant.W_O_STATUS_MATCHED_EXPIED_CONFIRM + ":\"超时已确认\"," + LogOrderDepositConstant.W_O_STATUS_MATCHED_EXPIED_CANCEL + ":\"超时已取消\"," + LogOrderDepositConstant.W_O_STATUS_MATCHED_EXPIED_MANUAL + ":\"超时转手动\"," + LogOrderDepositConstant.W_O_STATUS_CANCEL_AUTO + ":\"手动转自出\"," + LogOrderDepositConstant.O_STATUS_WAIT_CONFIRM + ":\"提款待确认\"," + LogOrderDepositConstant.O_STATUS_TWO_MATCHED + ":\"二次匹配中\"," + LogOrderDepositConstant.PRIORITY_CONFIRM + ":\"优先匹配\"," + LogOrderDepositConstant.JOIN_MOST_PRIORITY + ":\"加入最优先匹配池\"," + LogOrderDepositConstant.SUB_HAND_OUT + ":\"子单转手出\"," + LogOrderDepositConstant.SYSTEM + ":\"/\"," + LogOrderDepositConstant.ORDER_MATCH_UPDATE + ":\"订单匹配顺序更新\"," + LogOrderDepositConstant.HAND_OUT_ORDER_MATCHED + ":\"手动出款订单列表-处理中\"," + LogOrderDepositConstant.O_STATUS_REMATCH + ":\"重推匹配中\"," + LogOrderDepositConstant.O_STATUS_REMATCH_SECOND + ":\"重推二次匹配中\"," + LogOrderDepositConstant.O_STATUS_JUSTIFY + ":\"冲正\"," + LogOrderDepositConstant.O_STATUS_CONFIRM_PRIOR + ":\"优先确认\"}";

//    public static  String sysMenuVisible = "{\"0\":\"显示\",\"1\":\"隐藏\"}";
//    public static  String sysMenuType = "{\"M\":\"目录\",\"C\":\"菜单\",\"F\":\"按钮\"}";

    public static String smsStatus = "{\"1\":\"启用\",\"0\":\"禁用\"}";

    public static String template = "INSERT INTO sys_oper_log_translate_dict(business_type,original,translate,create_time) VALUES ('Translate_Value_Constant_%s', '%s', '%s', now());";


    public static void generate() {
//        println(JSONObject.parseObject(WorkType), "WorkType");
//        println(JSONObject.parseObject(WorkTypeEnglish), "WorkTypeEnglish");
//        println(JSONObject.parseObject(DeviceType), "DeviceType");
//        println(JSONObject.parseObject(AmountStatus), "AmountStatus");
//        println(JSONObject.parseObject(DeviceStatus), "DeviceStatus");
//        println(JSONObject.parseObject(BankWorkType), "BankWorkType");
//        println(JSONObject.parseObject(WorkTypemonitor), "WorkTypemonitor");
//        println(JSONObject.parseObject(WorkTypemonitorEnglish), "WorkTypemonitorEnglish");
//        println(JSONObject.parseObject(WorkTypecreate), "WorkTypecreate");
//        println(JSONObject.parseObject(cardWorkType), "cardWorkType");
//        println(JSONObject.parseObject(Status), "Status");
//        println(JSONObject.parseObject(StatusEnglish), "StatusEnglish");
//        println(JSONObject.parseObject(clientMonitorBankStatus), "clientMonitorBankStatus");
//        println(JSONObject.parseObject(clientMonitorBankStatusEnglish), "clientMonitorBankStatusEnglish");
//        println(JSONObject.parseObject(Statussearch), "Statussearch");
//        println(JSONObject.parseObject(CardpoolStatus), "CardpoolStatus");
//        println(JSONObject.parseObject(FastDepositUnMatchPayType), "FastDepositUnMatchPayType");
//        println(JSONObject.parseObject(TransStatus), "TransStatus");
//        println(JSONObject.parseObject(TransType), "TransType");
//        println(JSONObject.parseObject(TransOrderType), "TransOrderType");
//        println(JSONObject.parseObject(PayType), "PayType");
//        println(JSONObject.parseObject(BankPayType), "BankPayType");
//        println(JSONObject.parseObject(BankType), "BankType");
//        println(JSONObject.parseObject(UserLevel), "UserLevel");
//        println(JSONObject.parseObject(BankCardStatus), "BankCardStatus");
//        println(JSONObject.parseObject(PayChannelStatus), "PayChannelStatus");
//        println(JSONObject.parseObject(ClientType), "ClientType");
//
//        println(JSONObject.parseObject(type), "type");
//        println(JSONObject.parseObject(CategoryType), "CategoryType");
//        println(JSONObject.parseObject(monitorStatus), "monitorStatus");
//        println(JSONObject.parseObject(transObject), "transObject");
//        println(JSONObject.parseObject(orderBy), "orderBy");
//        println(JSONObject.parseObject(CardWorkTypeCardPoolTypeRelations), "CardWorkTypeCardPoolTypeRelations");
//        println(JSONObject.parseObject(SourceTypes), "SourceTypes");
//        println(JSONObject.parseObject(Protocol), "Protocol");
//        println(JSONObject.parseObject(betType), "betType");
//        println(JSONObject.parseObject(GMTyoe), "GMTyoe");
//        println(JSONObject.parseObject(OperatorType), "OperatorType");
//        println(JSONObject.parseObject(PhoneType), "PhoneType");
//        println(JSONObject.parseObject(Gender), "Gender");
////        println(JSONObject.parseObject(Archive), "Archive");
//        println(JSONObject.parseObject(StautsType), "StautsType");
//        println(JSONObject.parseObject(RoleType), "RoleType");
//        println(JSONObject.parseObject(RoleTypeEnglish), "RoleTypeEnglish");
//        println(JSONObject.parseObject(DepositStatus), "DepositStatus");
//        println(JSONObject.parseObject(WithdrawStatus), "WithdrawStatus");
//        println(JSONObject.parseObject(IpStatus), "IpStatus");
//        println(JSONObject.parseObject(MerchantStatus), "MerchantStatus");
//        println(JSONObject.parseObject(OrderType), "OrderType");
//        println(JSONObject.parseObject(NeizhuanStatus), "NeizhuanStatus");
//        println(JSONObject.parseObject(XiafaStatus), "XiafaStatus");
//        println(JSONObject.parseObject(IsUkey), "IsUkey");
//        println(JSONObject.parseObject(IsCard), "IsCard");
//        println(JSONObject.parseObject(IsReportBad), "IsReportBad");
//        println(JSONObject.parseObject(BankTypeU), "BankTypeU");
//        println(JSONObject.parseObject(FinishTypes), "FinishTypes");
//        println(JSONObject.parseObject(ClientStatus), "ClientStatus");
//        println(JSONObject.parseObject(ClientStatusEnglish), "ClientStatusEnglish");
//        println(JSONObject.parseObject(ClientStatusTwo), "ClientStatusTwo");
//
//        println(JSONObject.parseObject(ClientStatusTwoEnglish), "ClientStatusTwoEnglish");
//        println(JSONObject.parseObject(ClientWorkType), "ClientWorkType");
//        println(JSONObject.parseObject(OrderStatus), "OrderStatus");
//        println(JSONObject.parseObject(OrderStatusEnglish), "OrderStatusEnglish");
//        println(JSONObject.parseObject(OrderStatusW), "OrderStatusW");
//        println(JSONObject.parseObject(OrderStatusWEnglish), "OrderStatusWEnglish");
//        println(JSONObject.parseObject(OrderStatusD), "OrderStatusD");
//        println(JSONObject.parseObject(OrderStatusDEnglish), "OrderStatusDEnglish");
//        println(JSONObject.parseObject(OrderStatusDT), "OrderStatusDT");
//        println(JSONObject.parseObject(MerchantDepositOrderStatus), "MerchantDepositOrderStatus");
//        println(JSONObject.parseObject(OrderStatusDTEnglish), "OrderStatusDTEnglish");
//        println(JSONObject.parseObject(OrderStatusDTOut), "OrderStatusDTOut");
//        println(JSONObject.parseObject(OrderStatusAudit), "OrderStatusAudit");
//        println(JSONObject.parseObject(OrderStatusDTOutEnglish), "OrderStatusDTOutEnglish");
//        println(JSONObject.parseObject(OrderStatusThird), "OrderStatusThird");
//        println(JSONObject.parseObject(OrderStatusThirdEnglish), "OrderStatusThirdEnglish");
//        println(JSONObject.parseObject(ApiOrderApproveStatus), "ApiOrderApproveStatus");
//        println(JSONObject.parseObject(PaymentPendingOrderStatusSearch), "PaymentPendingOrderStatusSearch");
//        println(JSONObject.parseObject(PaymentPendingOrderStatusSearchEnglish), "PaymentPendingOrderStatusSearchEnglish");
//        println(JSONObject.parseObject(OrderStatusFastDeposit), "OrderStatusFastDeposit");
//        println(JSONObject.parseObject(OrderStatusFastWithdraw), "OrderStatusFastWithdraw");
//        println(JSONObject.parseObject(OrderStatusFastWithdrawOut), "OrderStatusFastWithdrawOut");
//        println(JSONObject.parseObject(OrderStatusSFXF), "OrderStatusSFXF");
//        println(JSONObject.parseObject(OrderStatusSFXFEnglish), "OrderStatusSFXFEnglish");
//        println(JSONObject.parseObject(handOrderStatus), "handOrderStatus");
//        println(JSONObject.parseObject(handOrderStatusEnglish), "handOrderStatusEnglish");
//        println(JSONObject.parseObject(historyHandOrderStatus), "historyHandOrderStatus");
//        println(JSONObject.parseObject(historyHandOrderStatusEnglish), "historyHandOrderStatusEnglish");
//
//        println(JSONObject.parseObject(historyHandOrderOutStatus), "historyHandOrderOutStatus");
//        println(JSONObject.parseObject(historyHandOrderStatusOutEnglish), "historyHandOrderStatusOutEnglish");
//        println(JSONObject.parseObject(OrderStatusM), "OrderStatusM");
//        println(JSONObject.parseObject(CloseType), "CloseType");
//        println(JSONObject.parseObject(CloseTypeEnglish), "CloseTypeEnglish");
//        println(JSONObject.parseObject(PayPoolType), "PayPoolType");
//        println(JSONObject.parseObject(MerchantTransType), "MerchantTransType");
//        println(JSONObject.parseObject(MerchantTransTypeEnglish), "MerchantTransTypeEnglish");
//        println(JSONObject.parseObject(OrderNotifyStatus), "OrderNotifyStatus");
//        println(JSONObject.parseObject(OrderNotifyStatusEnglish), "OrderNotifyStatusEnglish");
//        println(JSONObject.parseObject(APPROVE_STATUS), "APPROVE_STATUS");
//        println(JSONObject.parseObject(MerchantOrderStatus), "MerchantOrderStatus");
//        println(JSONObject.parseObject(PaymentPool_PayChannelStatus), "PaymentPool_PayChannelStatus");
//        println(JSONObject.parseObject(PaymentChannelWorkType), "PaymentChannelWorkType");
        println(JSONObject.parseObject(HankWithdrawType), "HankWithdrawType");
        println(JSONObject.parseObject(HankWithdrawTypeEnglish), "HankWithdrawTypeEnglish");
        println(JSONObject.parseObject(AllowTransHankWithdrawType), "AllowTransHankWithdrawType");
//        println(JSONObject.parseObject(userStatus), "userStatus");
//        println(JSONObject.parseObject(userStatusEnglish), "userStatusEnglish");
//        println(JSONObject.parseObject(roleStatus), "roleStatus");
//        println(JSONObject.parseObject(roleStatusEnglish), "roleStatusEnglish");
//        println(JSONObject.parseObject(orderRole), "orderRole");
//        println(JSONObject.parseObject(HandPayType), "HandPayType");
//        println(JSONObject.parseObject(HandPayTypeEnglish), "HandPayTypeEnglish");
//
//        println(JSONObject.parseObject(orderAllotStatus), "orderAllotStatus");
//        println(JSONObject.parseObject(ClientVersionStatus), "ClientVersionStatus");
//        println(JSONObject.parseObject(ClientVersionStatusEnglish), "ClientVersionStatusEnglish");
//        println(JSONObject.parseObject(bankCard_upDown_status), "bankCard_upDown_status");
//        println(JSONObject.parseObject(bankCard_upDown_statusEnglish), "bankCard_upDown_statusEnglish");
//        println(JSONObject.parseObject(cardPriority_config_key), "cardPriority_config_key");
//        println(JSONObject.parseObject(cardPriority_config_value), "cardPriority_config_value");
//        println(JSONObject.parseObject(clientType), "clientType");
//
//        println(JSONObject.parseObject(walletType), "walletType");
//        println(JSONObject.parseObject(LEVELS), "LEVELS");
//        println(JSONObject.parseObject(orderLockType), "orderLockType");
//        println(JSONObject.parseObject(merchantType), "merchantType");
//        println(JSONObject.parseObject(MerchantDepositStatus), "MerchantDepositStatus");
//        println(JSONObject.parseObject(deviceType), "deviceType");
//        println(JSONObject.parseObject(serviceName), "serviceName");
//        println(JSONObject.parseObject(UserStatus), "UserStatus");
//        println(JSONObject.parseObject(DelFlag), "DelFlag");
//        println(JSONObject.parseObject(matchType), "matchType");
//        println(JSONObject.parseObject(OrderStatusFastWithdrawLogOperateType), "OrderStatusFastWithdrawLogOperateType");
//        println(JSONObject.parseObject(OrderStatusFastWithdrawLogOrderType), "OrderStatusFastWithdrawLogOrderType");
//        println(JSONObject.parseObject(smsStatus), "smsStatus");
//        println(JSONObject.parseObject(sysMenuType), "sysMenuType");
    }

    private static void println(JSONObject jsonObject, String type) {
        jsonObject.forEach((key, value) -> {
            System.out.printf((template) + "%n", type, key, value);
        });
    }

}
