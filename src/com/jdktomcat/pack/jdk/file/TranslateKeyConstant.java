package com.jdktomcat.pack.jdk.file;

/**
 * @author ZF-Timmy
 * @version V1.0
 * @description 类描述：
 * @date 2024/1/4
 */
public class TranslateKeyConstant {

    public static final String Order_Key = "merchantOrderId=商户订单号,orderId=平台订单号,bankAccount=银行卡简码,orderIndex=订单索引," + "orderStatus=订单状态,lockRmark=锁定备注,lockType=锁定类型,closeReason=关闭原因,googleCode=谷歌验证码,paidAmount=实际金额," + "payAmount=订单金额,orderType=订单类型,operator=操作用户,bankOwner=开户姓名,bankCode=银行类型,approveRemark=一审备注," + "approveStatus=一审状态,inputBankAccount=转入银行简码,outputBankAccount=转出银行简码,allotUserId=分配人员ID,allotTime=分配时间," + "allotStatus=分配状态,pickTime=抓单时间,remark=备注";

    public static final String Trans_Key = "id=流水编号,merchantOrderID=商户订单号,Remark=银行备注,transTime=交易时间,balance=余额,bankNum=交易卡号," + "merchantId=商户ID,transType=交易类型,bankAccount=银行简码,name=交易姓名,transAccount=交易账号,transAmount=交易金额,status=流水状态,operator=操作人";

    public static final String Payment_Pool = "payChannelIds=支付渠道ID集合,payChannelNames=支付渠道名称集合,payChannelId=支付渠道编号,remark=备注,payPoolId=支付池编号," + "payPoolName=支付池名称,payPoolType=支付池类型,status=服务状态,payChannelName=支付渠道名称,lastUpdateTime=更新时间,updateBy=操作人,pay_pool_type=支付池类型," + "supplierbranchid=分支编号";

    public static final String Payment_Channel = "payChannelId=支付渠道编号,status=服务状态,payChannelName=支付渠道名称," + "ClientType=客户端类型,riskyBalance=风控余额,workType=工作模式,remark=备注,minAmountPerTrans=每笔交易最小额度," + "version=版本号,balance=渠道盈余,channelLevel=优先等级,maxAmountPerTrans=每笔交易最大额度,payType=支付方式," + "sumAmountPerDayTrans=日总限额,bankIds=银行卡编号集合,withdrawStatus=下发方式,minBalance=最小保留额度,maxBalance=最大保留额度," + "depositStatus=充值方式,googleCode=谷歌验证码,withdrawBankPoolId=下发卡池编号,depositBankPoolId=充值卡池编号," + "testName=测试姓名,testAmount=测试金额,testRemark=测试备注,lastUpdateTime=更新时间,payChannelIds=支付渠道ID集合,testProtocol=支付协议";

    public static final String AsktransDto = "bankId=银行卡编号,bankAccount=银行卡简码,PerMinTrans=单笔最低金额,money=申请资金金额";

    public static final String BankCard_Monitor = "bankId=银行卡编号,bankAccount=银行卡简码,bankCode=银行卡简码,testMoney=测试金额," + "clientName=客户端名称,clientId=客户端编号,status=状态,outCardBankCode=转出银行卡简码,inCardBankCode=转入银行卡简码,money=操作金额";


    public static final String BankCard_Key = "bankId=银行卡编号,bankAccount=银行卡简码,bankCode=银行卡简码,status=服务状态,remark=银行卡备注," + "bankIds=银行卡编号集合,bankCodeList=银行卡简码集合,supplierBranchId=财务分支,bankPoolName=卡池名称,bankPoolNames=卡池名称集合," + "comments=人工备注,maxBalance=最大保留额度,minBalance=最小保留额度,minamountpertrans=每笔最小,balance=余额,poolId=卡池ID,poolIds=卡池ID集合," + "aliMinAmountPerTrans=支付宝每笔最小,aliMaxAmountPerTrans=支付宝每笔最大,aliSumAmountPerDayTrans=支付宝日总限额,bankType=银行类型," + "aliSumTimesPerDayTrans=支付宝日笔数限制,sumAmountPerDayTrans=日总限额,googleCode=谷歌验证码,bankNum=银行卡号," + "lastUpDatetime=最后更新时间,loginPwd=登录密码,workType=工作模式,loginAccount=网银账户,minBalance=最小保留额度,ownerName=开户人," + "maxBalance=最大保留额度,initBalance=保留额度,depositAddress=充值地址,ownerIdentity=开户人身份证,ownerPhone=手机号码,address=开户地址," + "sumTimesPerDayTrans=日笔数限定,payPwd=支付密码,maxAmountPerTrans=每笔最大,uCode=子账号,minAmountPerTrans=每笔最小,auTheStr=查看员组," + "uniqueIds=银行卡ID集合,updateBy=操作人,updateTime=更新时间,multiSwitch=并发开关";

    public static final String BankClient_Key = "bankAccount=银行卡简码,bankCode=银行卡简码,clientId=客户端ID,clientName=客户端名称," + "bankType=银行类型,identity=识别码,workType=工作模式,status=服务状态,updateTime=更新时间,updateBy=操作人";

    public static final String BankCard_Pool = "bankPooId=卡池ID,bankPoolName=卡池名称,workType=工作模式,outputTestPoolId=转出资金测试卡池ID," + "status=服务状态,inputPoolId=转入资金卡池ID,outputPoolIds=转出资金卡池ID集合,bankCardIds=银行卡ID集合,roleType=卡池类型,outPutPoolNames=转出资金卡池名称集合," + "inputPoolName=转入资金卡池名称,outputTestPoolName=转出资金卡池名称,bankCardNameList=银行卡简码集合,LastUpDateTime=最后更新时间,supplierbranchid=卡池所属分支";

    public static final String User_Info_Key = "loginName=登录名,treeName=角色名,roleId=角色ID,roleIds=角色ID,userName=用户昵称,status=用户状态,userId=用户ID,orderallotrule=订单角色," + "supplierbranchidgroup=财务分支组,supplierbranchid=当前财务分支,googleCode=谷歌密钥,verifyCode=验证码,password=登录密码,user_name=用户昵称,update_time=更新时间,user_id=用户ID," + "login_name=登录用户名,update_by=操作人,oldPassword=原密码,newPassword=新密码,pwd_update_time=密码更新时间,del_flag=删除标志（0代表存在 2代表删除）";

    public static final String Role_Key = "roleId=角色ID,status=角色状态,update_time=更新时间,roleName=角色名称,role_name=角色名称,roleKey=角色权限,role_key=角色权限,roleSort=角色排序," + "role_sort=角色排序,update_by=操作人,menuIds=权限ID集合,role_id=角色ID";

    public static final String Menu_key = "menuId=菜单ID,menu_id=菜单ID,visible=菜单状态,menuName=菜单名称,menu_name=菜单名称,parentName=父菜单名称,parentId=父菜单ID,orderNum=显示顺序," + "order_num=显示顺序,url=菜单Url,target=菜单打开方式,perms=权限字符串,icon=菜单图标,menuCode=菜单编码,menu_code=菜单编码,update_by=操作人,menu_type=菜单类型,menuType=菜单类型," + "update_time=更新时间";

    public static final String SysConfig_key = "ServiceAddress=服务地址,ServiceKey=服务关键字,ServiceName=服务名称,Status=服务状态,updateTime=更新时间";

    public static final String Limit_Value = "rmbLimitValue=人民币上限值,virtualLimitValue=虚拟币上限值";

    public static final String BankClient_Version_Key = "version=版本号,id=客户端版本ID," + "bankCode=银行类型,status=服务状态,updateTime=更新时间,updateBy=操作人";

    public static final String Wallet_Key = "ID=钱包编号,currencyType=币种,protocol=支付协议,status=服务状态,walletAddress=钱包地址,walletType=钱包类型";

    public static final String BankType_Key = "bankTypeId=银行卡类型ID,bankTypeName=银行卡类型名称,bankTypeCode=银行卡类型代码";

    public static final String BusinessUser_Info_Key = "loginName=登录名,treeName=角色名,roleId=角色ID,roleIds=角色ID,userName=用户昵称,status=用户状态,userId=用户ID,orderallotrule=订单角色," + "merchantidGroup=关联商户组,merchantid=当前关联商户,googleCode=谷歌密钥,verifyCode=验证码,password=登录密码,user_name=用户昵称,update_time=更新时间,user_id=用户ID," + "login_name=登录用户名,update_by=操作人,oldPassword=原密码,newPassword=新密码,pwd_update_time=密码更新时间,del_flag=删除标志（0代表存在 2代表删除）";

    public static final String SMS_Template_Key = "id=模板id,bankName=银行名称,bankCode=银行编码,smsPhoneNo=短信号码,smsContent=短信内容,createBy=操作人,smsStatus=模板状态";

    public static final String APP_Account_Key = "id=App id,userName=登陆账号,password=登录密码,loginIp=ip,supplierBranchId=财务分支,createBy=操作人,userStatus=用户状态,delFlag=删除,googlecode=google密钥";


    public static final String APP_Account_Delete_Key = "ids=删除id,userName=登陆账号,loginIp=ip,supplierBranchId=财务分支,createBy=操作人,delFlag=删除,userStatus=用户状态";




    public static final String template = "INSERT INTO sys_oper_log_translate_dict(business_type,original,translate,create_time) VALUES ('Translate_Key_Constant_%s', '%s', '%s', now());";

    public static void generate() {
        println(Order_Key.split(","), "Order_Key");
        println(Trans_Key.split(","), "Trans_Key");
        println(Payment_Pool.split(","), "Payment_Pool");
        println(Payment_Channel.split(","), "Payment_Channel");
        println(AsktransDto.split(","), "AsktransDto");
        println(BankCard_Monitor.split(","), "BankCard_Monitor");
        println(BankCard_Key.split(","), "BankCard_Key");
        println(BankClient_Key.split(","), "BankClient_Key");
        println(BankCard_Pool.split(","), "BankCard_Pool");
        println(User_Info_Key.split(","), "User_Info_Key");
        println(Role_Key.split(","), "Role_Key");
        println(Menu_key.split(","), "Menu_key");
        println(SysConfig_key.split(","), "SysConfig_key");
        println(Limit_Value.split(","), "Limit_Value");
        println(BankClient_Version_Key.split(","), "BankClient_Version_Key");
        println(Wallet_Key.split(","), "Wallet_Key");
        println(BankType_Key.split(","), "BankType_Key");
        println(BusinessUser_Info_Key.split(","), "BusinessUser_Info_Key");
        println(SMS_Template_Key.split(","), "SMS_Template_Key");
        println(APP_Account_Key.split(","), "APP_Account_Key");
        println(APP_Account_Delete_Key.split(","), "APP_Account_Delete_Key");
    }

    private static void println(String[] items, String type) {

        for (String item : items) {
            String[] pair = item.split("=");
            System.out.printf((template) + "%n", type, pair[0], pair[1]);
        }
    }
}
