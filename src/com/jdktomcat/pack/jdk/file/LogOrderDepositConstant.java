package com.jdktomcat.pack.jdk.file;

/**
 * @Author jalen
 * @Date 2023/1/14 21:51
 * @desc
 */
public class LogOrderDepositConstant {

    /**
     * 提款订单已创建
     */
    public static final int W_O_STATUS_CREATE = 0;

    /**
     * 提款订单处理中（匹配成功）
     */
    public static final int W_O_STATUS_MATCHED = 1;

    /**
     * 提款订单已确认完成
     */
    public static final int W_O_STATUS_CONFIRM = 4;

    /**
     * 提款订单已取消
     */
    public static final int W_O_STATUS_CANCEL = 7;

    /**
     * 提款订单未匹配-过期转自动
     */
    public static final int W_O_STATUS_EXPIED_AUTO = 5;

    /**
     * 提款订单超时未匹配-待处理
     */
    public static final int W_O_STATUS_EXPIRED_UNMATCHED = 501;

    /**
     * 提款订单处理中(匹配成功)-已过期
     */
    public static final int W_O_STATUS_MATCHED_EXPIED = 6;

    /**
     * 订单待确认（ 充值已确认后的提款订单状态）
     */
    public static final int O_STATUS_WAIT_CONFIRM = 10;

    /**
     * 订单匹配成功-取消转自动
     */
    public static final int W_O_STATUS_CANCEL_AUTO = 71;

    /**
     * 提款订单匹配成功-过期已确认
     */
    public static final int W_O_STATUS_MATCHED_EXPIED_CONFIRM = 604;

    /**
     * 提款订单匹配成功-过期已取消
     */
    public static final int W_O_STATUS_MATCHED_EXPIED_CANCEL = 607;

    /**
     * 提款订单处理中(匹配成功)-过期转手动
     */
    public static final int W_O_STATUS_MATCHED_EXPIED_MANUAL = 611;
    /**
     * 二次匹配
     */
    public static final int O_STATUS_TWO_MATCHED = 11;

    /**
     * 重推匹配
     */
    public static final int O_STATUS_REMATCH = 110;

    /**
     * 重推二次匹配
     */
    public static final int O_STATUS_REMATCH_SECOND = 111;

    /**
     * 提款订单超时时间KEY：用于设置提款订单未匹配的超时时间
     */
    public static final String W_O_VALIDATE_KEY = "w_o_validate";

    /**
     * 提款订单匹配成功超时时间KEY：用于设置提款订单匹配成功的超时时间
     */
    public static final String W_O_UNMATCHED_TIMEOUT_KEY = "w_o_unmatched_timeout";

    /** ----------------充值订单常量------------------------ **/
    //提款pay_message  已确认(4，604),超时转自出(5),超时未确认(6),已取消 (7,607)
    /**
     * 充值订单已创建
     */
    public static final int D_O_STATUS_CREATE = 0;

    /**
     * 充值订单处理中（匹配成功）
     */
    public static final int D_O_STATUS_MATCHED = 1;
    /**
     * 充值订单已确认完成
     */
    public static final int D_O_STATUS_CONFIRM = 4;

    /**
     * 提款待确认
     */
    public static final int D_STATUS_WAIT_CONFIRM = 10;

    /**
     * 充值订单已取消
     */
    public static final int D_O_STATUS_CANCEL = 7;

    /**
     * 充值订单处理中(匹配成功)-已过期
     */
    public static final int D_O_STATUS_MATCHED_EXPIED = 6;

    /**
     * 充值订单匹配成功-过期已确认
     */
    public static final int D_O_STATUS_MATCHED_EXPIED_CONFIRM = 604;

    /**
     * 充值订单匹配成功-过期已取消
     */
    public static final int D_O_STATUS_MATCHED_EXPIED_CANCEL = 607;

    /** ----------------订单匹配配置常量------------------------ **/
    /**
     * 提款未匹配订单的有效期，单位为分钟，默认30分钟
     */
    public static final int WITHDRAW_UNMATCH_VALID_TIME = 30;

    /**
     * 匹配成功订单超时时限，单位为小时，默认6小时
     */
    public static final int MATCHUP_SUCCESS_TIMEOUT = 6;

    /**
     * 充值订单失败
     */
    public static final int FAIL = 17;

    /**
     * 冲正
     */
    public static final int O_STATUS_JUSTIFY = 19;

    /**
     * 已优先确认
     */
    public static final int O_STATUS_CONFIRM_PRIOR = 40;

    /**
     * 优先匹配
     */
    public static final int    PRIORITY_CONFIRM = 91;

    /**
     * 加入最优先匹配池
     */
    public static final int JOIN_MOST_PRIORITY = 92;


    /**
     * 子单转手出
     */
    public static final int SUB_HAND_OUT = 93;


    /**
     * 系统
     */
    public static final int SYSTEM = -1;


    /**
     * 订单匹配顺序更新
     */
    public static final int ORDER_MATCH_UPDATE = 85;


    /**
     * 手动出款订单列表-处理中
     */
    public static final int HAND_OUT_ORDER_MATCHED = 90;

}
