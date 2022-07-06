package cn.zm.common.utils;

public class AppRegexpConstants {
    /**
     * Description : 贵宾号  <br/>
     */
    public static final String VIP_NUM = "^[A-Za-z]{1,4}[0-9]{5}$";

    /**
     * Description :  数字  <br/>
     */
    public static final String NUMBER = "^[0-9]*$";

    /**
     * Description : 零和非零开头的数字  <br/>
     */
    public static final String ZERO_NONZERO_START_INTERGER = "^(0|[1-9][0-9]*)$";
    /**
     * Description : 输入有两位小数的正实数  <br/>
     */
    public static final String TWO_DECIMAL_PLACES_DOUBLE = "^[0-9]+(.[0-9]{2})?$";
   /**
    * Description : 只能输入非零的负整数  <br/>
    */
    public static final String NON_ZERO_POSITIVE_INTERGER = "^\\-[1-9][0-9]*$";

    /**
     * Description : 只能输入非零的正整数  <br/>
     */
    public static final String NON_ZERO_NEGATIVE_INTERGER = "^\\+?[1-9][0-9]*$";

    /**
     * Description :  26个英文字母组成的字符串 <br/>
     */
    public static final String ENGLISH_STRING = "^[A-Za-z]*$";
    /**
     * Description :  26个大写英文字母组成的字符串 <br/>
     */
    public static final String UPPER_ENGLISH_STRING = "^[A-Z]*$";

    /**
     * Description :  26个小写英文字母组成的字符串 <br/>
     */
    public static final String LOWWER_ENGLISH_STRING = "^[a-z]*$";

    /**
     * Description : 由数字和26个英文字母组成的字符串 <br/>
     */
    public static final String ENGLISH_NUMBER_STRING = "^[A-Za-z0-9]*$";

    /**
     * Description : 由数字、26个英文字母或者下划线组成的字符串 <br/>
     */
    public static final String ENGLISH_NUMBER_UNDERLINE_STRING = "^\\w*$";

    /**
     * Description : 验证身份证号（18位数字） <br/>
     */
    public static final String ID_NUM = "^[1-9][0-9]{5}(18|19|20)[0-9]{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)[0-9]{3}([0-9]|(X|x))";

    /**
     * Description : 验证有线和移动电话号码  正确格式为："XXXXXXXXXX","XXX-XXXXXXX"、"XXXX-XXXXXXXX"、"XXX-XXXXXXX"、"XXX-XXXXXXXX"、"XXXXXXX"和"XXXXXXXX"。<br/>
     */
    public static final String PHONE = "^(((\\d{3,4})|(\\d{3,4}-))?\\d{7,8})|(\\d{11})$";

    /**
     * Description : 验证固定电话号码  正确格式为："XXX-XXXXXXX"、"XXXX-XXXXXXXX"、"XXX-XXXXXXX"、"XXX-XXXXXXXX"、"XXXXXXX"和"XXXXXXXX"。<br/>
     */
    public static final String WIRE_PHONE = "^((\\d{3,4})|(\\d{3,4}-))?\\d{7,8}$";


    /**
     * Description : 验证手机号码  正确格式为："XXXXXXXXXXX"<br/>
     */
    public static final String MOBILE_PHONE = "^\\d{11}$";

    /**
     * Description : 验证Email地址 <br/>
     */
    public static final String EMAIL ="^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";

    /**
     * Description : 验证用户密码 正确格式为：以字母开头，长度在6~18之间，只能包含字符、数字和下划线。 <br/>
     */
    public static final String USER_NAME_OR_PASSWORD = "^[a-zA-Z]\\w{5,17}$";

    /**
     * Description : 经度验证 <br/>
     */
    public static final String LONGITUDE = "^[\\+\\-]?1?[0-9]{1,2}(\\.[0-9]{1,17})?$";
    /**
     * Description : 纬度验证 <br/>
     */
    public static final String LATITUDE = "^[\\+\\-]?((([0-8]?[0-9])(\\.[0-9]{1,17})?)|(90))$";
    /**
     * Description : 验证0至3位整数 <br/>
     */
    public static final String THREE_NUMBER ="^(0|[1-9]\\d{0,2})$";

    /**
     * Description : 验证数字或字母或汉字组合 <br/>
     */
    public static final String ENGLISH_NUMBER_CHINESE ="^[\\dA-Za-z\\u4e00-\\u9fa5]+$";

    /**
     * Description : 验证字母或汉字组合 <br/>
     */
    public static final String ENGLISH_CHINESE_STRING ="^[\\u4e00-\\u9fa5a-zA-Z-z]+$";

}
