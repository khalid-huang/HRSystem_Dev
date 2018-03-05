package com.kevin.HRSystem.constant;

public class ConstantManager {
    //登录失败
    public  static final int LOGIN_FALT = 0;
    //以普通员工登录
    public static final int LOGIN_EMP = 0;
    //以经理登录
    public static final int LOGIN_MGR = 2;

    //不能打卡
    public static final int NO_PUNCH = 0;
    //只能上班打卡
    public static final int COME_PUNCH = 1;
    //只能下班打卡
    public static final int LEAVE_PUNCH = 2;
    //既可以上班也可以下班打卡
    public static final int BOTH_PUNCH = 3;

    //打卡失败
    public static final int PUNCH_FALT = 0;
    //已经打卡
    public static final int PUNCHED = 1;
    //打卡成功
    public static final int PUNCH_SUCC = 2;

    //以上午11点为上午时间
    public static final int AM_LIMIT = 11;

    //以上午9点之前为正常上班
    public static final int COME_LIMIT= 9;
    //以上午9点到11点算迟到
    public static final int LATE_LIMIT = 11;
    //以下午18点之后算正常下班
    public static final int LEAVE_LIMIT= 18;
    //以上午16点到18点之间算迟到
    public static final int EARLY_LIMIT = 16;
}
