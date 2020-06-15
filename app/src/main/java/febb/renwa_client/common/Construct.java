package febb.renwa_client.common;


import febb.renwa_client.BuildConfig;

public class Construct {
    /* デバッグ */
    public static final int DEBUG = 0;

    /* プロジェクト固有文字列 */
//    public static final String PROJECT_STRING = "afb64c6955ce64ed50433e1637309228";
//    public static final String API_COMMON_HASH = "pB4kWe5lSfaQFHViAi4A1bqhjHrQ9Qq4";
//    public static final String APPLICATION_KEY = "30E21ADD16F0EEB3CE71A65F496D604DD938C8CF6D9C87E07C177FF875C2724C";
//    public static final String SIGNATURE_METHOD = "HmacSHA256";
//
//    /* 決済方法 */
//    public static final String PAY_METHOD_CREDIT = "1";
//    public static final String PAY_METHOD_DOCOMO = "2";
//    public static final String PAY_METHOD_AU = "3";
//    public static final String PAY_METHOD_SOFTBANK = "4";
//
//    /* キャリアコード */
//    public static final String CARRIER_CODE_DOCOMO = "1";
//    public static final String CARRIER_CODE_AU = "2";
//    public static final String CARRIER_CODE_SOFTBANK = "3";
//    public static final String CARRIER_CODE_OTHER = "99";

    /* ブロック回避依頼するドメイン */
//    public static final String DOMAIN_NOT_BLOCK = "@ixit.co.jp";

    /* 各種URL */
//    public static final String FP_FQDN;
//    public static final String FP_SCHEME;

    public static final String FP_FQDN ="http://" + "flask-env.5csymrfgjb.us-east-2.elasticbeanstalk.com/";
//    static {
//        if (BuildConfig.BUILD_TYPE.equals("debug")) {
//            FP_FQDN = "coin.dev.ixit.jp";
//            FP_SCHEME = "firstpassport://";
//        } else if (BuildConfig.BUILD_TYPE.equals("staging")) {
//            FP_FQDN = "coin.dev.ixit.jp";
//            FP_SCHEME = "stg-firstpassport://";
//        } else { // release
//            FP_FQDN = "coin.dev.ixit.jp";
//            FP_SCHEME = "firstpassport://";
//        }
//    }
    public static final String FP_DOMAIN = "http://" + "flask-env.5csymrfgjb.us-east-2.elasticbeanstalk.com/";

//    public static final String SETTING_USER_POLICY = FP_DOMAIN + "/contents/user_policy.html";
//    public static final String SETTING_PRIVACY_POLICY = FP_DOMAIN + "/contents/privacy_policy.html";
//    public static final String SETTING_TRANSACTION_RAW = FP_DOMAIN + "/contents/transaction_raw.html";


    /* SBPS */
//    public static final String POST_URL_BUY = "https://" + (BuildConfig.BUILD_TYPE.equals("release") ? "" : "stb") + "fep.sps-system.com/f01/FepBuyInfoReceive.do";
//    public static final String POST_URL_MRC = "https://" + (BuildConfig.BUILD_TYPE.equals("release") ? "" : "stb") + "fep.sps-system.com/f01/FepMrcInfoReceive.do";
//    public static final String SUCCESS_URL_ADD = FP_DOMAIN + "/payment/add_complete";
//    public static final String SUCCESS_URL_UPD = FP_DOMAIN + "/payment/upd_complete";
//    public static final String CANCEL_URL = FP_SCHEME + "cancel";
//    public static final String ERROR_URL = FP_SCHEME + "error";
//    public static final String PAGE_CON_URL_ADD = FP_DOMAIN + "/payment/add_result";
//    public static final String PAGE_CON_URL_UPD = FP_DOMAIN + "/payment/upd_result";

    /* リクエストコード */
//    public static final int CAMERA_ACTIVITY_REQUEST_CODE = 1001;

}
