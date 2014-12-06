/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cms.constant;

/**
 *
 * @author birui
 *
 * <p>
 * These constant are for define operation status</p>
 * <p>
 * Mod 10 can get final status BEGIN FROM 0;</p>
 * <p>
 * Message Queue operation BEGIN FROM 10;</p>
 * <p>
 * Email operation BEGIN 100;</p>
 */
public class Constant {
    public static final String ADDRESS = "127.0.0.1"+":8080"+"//CourseManagementClient/";
    public static final int SUCCESS = 0;
    public static final int PARTIAL_SUCCESS = 1;
    public static final int FAIL = 2;
    public static final int MSG_SET_SUCCESS = 10;
    public static final int MSG_SET_FAIL = 11;
    public static final int MSG_GET_SUCCESS = 20;
    public static final int MSG_GET_FAIL = 21;
    public static final int MAIL_SEND_SUCCESS = 100;
    public static final int MAIL_SEND_FAIL = 101;
    public static final int MSG_SET_MAIL_SUCCESS = 110;
    public static final int ONLY_MAIL_SUCCESS = 111;
    public static final int ONLY_MSG_SET_SUCCESS = 121;
    public static final int MSG_SET_MAIL_FAIL = 122;

}
