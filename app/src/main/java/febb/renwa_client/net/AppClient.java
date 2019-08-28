package febb.renwa_client.net;


import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import febb.renwa_client.common.Construct;
import febb.renwa_client.entity.RenwaVoice;
import okhttp3.HttpUrl;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;


public interface AppClient {
    String BASE_URL = Construct.FP_DOMAIN;
    String PATH = "/getter?";


//    @GET("/getter?name=renwa")
//    Call<ResponseBody> testCall(@HeaderMap Map<String, String> headers);


//    @GET("/getter?name=renwa")
//    Call<RenwaVoice> testCall(@HeaderMap Map<String, String> headers);


//    @GET("{id}")
//Call<RenwaVoice> testCall(@Path(value = "id", encoded = true) String str);

//    @GET("{id}")
//    Call<RenwaVoice> testCall(@Path(value = "id", encoded = true) HttpUrl url);


//    @GET("getter?name={str}")
//    Call<String> testCall(@Path(value="str", encoded=true) String str);
//
//    @GET("feed/rdf/")
//    fun getFreeSearch(@Query("s") s: String) : Observable<Article>

//    @GET("getter?name=")
//    Call<String> testCall(String str);
//
//    @GET("api.php")
//    Call<Model> getRoms_center(@Query("company_name") String name);

    @GET("getter?")
    Call<String> testCall(@Query("name") String str);

//    @GET("feed/rdf/")
//    fun getFreeSearch(@Query("s") s: String) : Observable<Article>

    //    @GET(PATH + "/pre_users")
//    Call<PreUsers> getAuthCode(@HeaderMap Map<String, String> headers, @QueryMap HashMap<String, String> param);
//



//    @GET("/user/{name}")
//    Call<ResponseBody> notEncoded(@Path(value="name", encoded=true) String name);

//    @GET(PATH + "{id}")
//    Call<RenwaVoice> testCall(@Path(value = "id", encoded = true) String str);


//    Call<RenwaVoice> testCall(String str);

//    @POST(PATH + "/tokens")
//    Call<ResponseBody> postTokens(@HeaderMap Map<String, String> headers, @Body TokensPostRequest body);
//
//    @PUT(PATH + "/tokens")
//    Call<TokensPutResponse> putTokens(@HeaderMap Map<String, String> headers, @Body HashMap<String, String> body);
//
//    @GET(PATH + "/tokens/{url_token}")
//    Call<JsonObject> getMailAddressFromToken(@HeaderMap Map<String, String> headers, @Path("url_token") String token);
//
//    @POST(PATH + "/pre_users")
//    Call<ResponseBody> postAuthCode(@HeaderMap Map<String, String> headers, @Body PreUsers body);
//
//    @GET(PATH + "/pre_users")
//    Call<PreUsers> getAuthCode(@HeaderMap Map<String, String> headers, @QueryMap HashMap<String, String> param);
//
//    @POST(PATH + "/users")
//    Call<UsersPostResponse> postUsers(@HeaderMap Map<String, String> headers, @Body UsersPostRequest body);
//
//    @PUT(PATH + "/users/{user_id}")
//    Call<ResponseBody> putUsers(@HeaderMap Map<String, String> headers, @Path("user_id") String userId, @Body UsersPutRequest body);
//
//    @GET(PATH + "/users/{user_id}")
//    Call<UsersGetResponse> getUsers(@HeaderMap Map<String, String> headers, @Path("user_id") String userId);
//
//    @HTTP(method = "DELETE", path = PATH + "/users/{user_id}", hasBody = true)
//    Call<ResponseBody> retireUser(@HeaderMap Map<String, String> headers, @Path("user_id") String userId, @Body UserRetirementRequest body);
//
//    @PUT(PATH + "/user_passwords/{user_id}")
//    Call<ResponseBody> updatePassword(@HeaderMap Map<String, String> headers, @Path("user_id") String userId, @Body PwdUpdateRequest body);
//
//    @POST(PATH + "/user_retirements")
//    Call<ResponseBody> userRetirements(@HeaderMap Map<String, String> headers, @Body UserRetirementRequest body);
//
//    @POST(PATH + "/login")
//    Call<UserAuth> login(@HeaderMap Map<String, String> headers, @Body LoginPostRequest body);
//
//    @GET(PATH + "/logout")
//    Call<ResponseBody> logout(@HeaderMap Map<String, String> headers);
//
//    @POST(PATH + "/user_devices")
//    Call<ResponseBody> postUserDevices(@HeaderMap Map<String, String> headers, @Body UsersDevicePostRequest body);
//
//    @PUT(PATH + "/user_devices/{user_id}")
//    Call<ResponseBody> putUserDevices(@HeaderMap Map<String, String> headers, @Path("user_id") String userId, @Body UsersDevicePutRequest body);
//
//    @GET(PATH + "/user_payments/{user_id}")
//    Call<List<UserPaymentsGetResponse>> getUserPayments(@HeaderMap Map<String, String> headers, @Path("user_id") String userId);
//
//    @HTTP(method = "DELETE", path = PATH + "/user_payments/{user_id}", hasBody = true)
//    Call<ResponseBody> deleteUserPayments(@HeaderMap Map<String, String> headers, @Path("user_id") String userId, @Body UserPaymentsDeleteRequest body);
//
//    @POST(PATH + "/user_payments")
//    Call<UserPaymentsPostResponse> postUserPayments(@HeaderMap Map<String, String> headers, @Body UserPaymentsPostRequest body);
//
//    @GET(PATH + "/shop_lists")
//    Call<List<Shop>> getShopLists(@HeaderMap Map<String, String> headers, @QueryMap HashMap<String, String> param);
//
//    @GET(PATH + "/coupon_lists")
//    Call<List<Coupon>> getCouponLists(@HeaderMap Map<String, String> headers, @QueryMap HashMap<String, String> param);
//
//    @GET(PATH + "/coupons")
//    Call<Coupon> getCoupons(@HeaderMap Map<String, String> headers, @QueryMap HashMap<String, String> param);
//
//    @POST(PATH + "/coupons")
//    Call<CouponHistory> useCouponTemp(@HeaderMap Map<String, String> headers, @Body HashMap<String, String> body);
//
//    @PUT(PATH + "/coupons/{coupon_history_id}")
//    Call<ResponseBody> certifyCoupon(@HeaderMap Map<String, String> headers, @Path("coupon_history_id") String couponHistoryId, @Body HashMap<String, String> authCode);
//
//    @GET(PATH + "/faqs")
//    Call<List<FaqList>> getFaqList(@HeaderMap Map<String, String> headers);
//
//    @POST(PATH + "/contacts")
//    Call<ResponseBody> contacts(@HeaderMap Map<String, String> headers, @Body Contacts body);
//
//    @GET(PATH + "/price_plans")
//    Call<ArrayList<Plan>> getPlanList(@HeaderMap Map<String, String> headers);
//
//    @POST(PATH + "/password_reminds")
//    Call<ResponseBody> postPasswordReminds(@HeaderMap Map<String, String> headers, @Body HashMap<String, String> body);
//
//    @GET(PATH + "/password_reminds/{remind_code}")
//    Call<UserInfo> getRemindsUser(@HeaderMap Map<String, String> headers, @Path("remind_code") String remindCode);
//
//    @GET(PATH + "/news")
//    Call<List<News>> getNewsList(@HeaderMap Map<String, String> headers);
//
//    @GET(PATH + "/menus")
//    Call<List<MenuItem>> getMenuList(@HeaderMap Map<String, String> headers);
//
//    @GET(PATH + "/menu_categories")
//    Call<List<MenuCategory>> getMenuCategory(@HeaderMap Map<String, String> headers);
//
//    @GET(PATH + "/system_settings")
//    Call<SystemSettings> getSystemSettings(@HeaderMap Map<String, String> headers);
//
//    @GET(PATH + "/app_versions/{os}/{version}")
//    Call<AppVersions> getAppVersions(@HeaderMap Map<String, String> headers, @Path("os") String os, @Path("version") String version);
}
