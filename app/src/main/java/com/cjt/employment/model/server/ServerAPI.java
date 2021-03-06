package com.cjt.employment.model.server;

import com.cjt.employment.bean.AccountInfo;
import com.cjt.employment.bean.AccountInfoBean;
import com.cjt.employment.bean.CollectionBean;
import com.cjt.employment.bean.CompanyDescpt;
import com.cjt.employment.bean.CompanyInfo;
import com.cjt.employment.bean.CompanyPosition;
import com.cjt.employment.bean.CompanyProject;
import com.cjt.employment.bean.Education;
import com.cjt.employment.bean.EnterprisePosition;
import com.cjt.employment.bean.HopeJob;
import com.cjt.employment.bean.InformationBean;
import com.cjt.employment.bean.InformationDetialBean;
import com.cjt.employment.bean.LoginResult;
import com.cjt.employment.bean.Project;
import com.cjt.employment.bean.Recruit;
import com.cjt.employment.bean.RecruitmentInfo;
import com.cjt.employment.bean.UpLoadImageResult;
import com.cjt.employment.bean.UpdateResult;
import com.cjt.employment.bean.UserBean;
import com.cjt.employment.bean.UserVitage;
import com.cjt.employment.bean.VitageBean;
import com.cjt.employment.bean.VitageDetailBean;
import com.cjt.employment.bean.VitageInfo;
import com.cjt.employment.bean.VitageStateBean;
import com.cjt.employment.bean.WorkExperience;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 作者: 陈嘉桐 on 2016/7/1
 * 邮箱: 445263848@qq.com.
 */
public interface ServerAPI {
    //网站根目录
    String baseUrl = "http://172.16.101.64:8080/EmploymentService/";
//    String baseUrl = "http://172.20.10.6:8080/EmploymentService/";
//    String baseUrl = "http://www.materialstyle.cn/EmploymentService/";

    //招聘信息
    @GET("servlet/RecruitServlet")
    Observable<Recruit> recruitServlet(@Query("action") String action);

    //资讯列表
    @GET("servlet/InfomationServlet")
    Observable<InformationBean> getInfomation(@Query("action") String action);

    //资讯详情
    @GET("servlet/InfomationServlet")
    Observable<InformationDetialBean> getInfomationDetial(
            @Query("action") String action,
            @Query("id") String id
    );

    //职位详情
    @GET("servlet/RecruitServlet")
    Observable<RecruitmentInfo> getRecruitInfoByID(@Query("action") String action, @Query("id") int id);

    //公司详情
    @GET("servlet/CompanyServlet")
    Observable<CompanyInfo> getCompanyInfoByCompanyId(@Query("action") String action, @Query("id") int id);

    //公司发布的职位
    @GET("servlet/CompanyServlet")
    Observable<Recruit> getRecruitByCompanyId(@Query("action") String action, @Query("id") int id);

    //获取用户信息
    @GET("servlet/AccountServlet")
    Observable<AccountInfo> getAccountInfoById(@Query("action") String action, @Query("id") int id);

    //获取用户基本信息
    @GET("servlet/AccountServlet")
    Observable<UserBean> getAccountInfo(
            @Query("action") String action,
            @Query("id") String id
    );

    //上传图片
    @Multipart
    @POST("servlet/ImageUpLoadServlet")
    Observable<UpLoadImageResult> upload(
            @Query("action") String name,
            @Query("id") int id,
            @Part("file\"; filename=\"image.jpg") RequestBody imgs
    );

    //更新用户姓名
    @GET("servlet/AccountServlet")
    Observable<UpLoadImageResult> updateName(
            @Query("action") String action,
            @Query("id") int id,
            @Query("name") String name
    );

    //获取用户信息
    @FormUrlEncoded
    @POST("servlet/LoginServlet")
    Observable<LoginResult> login(
            @Query("action") String action,
            @Field("phone") String id,
            @Field("password") String password
    );

    //注册
    @FormUrlEncoded
    @POST("servlet/LoginServlet")
    Observable<UpdateResult> register(
            @Query("action") String action,
            @Field("phone") String id,
            @Field("password") String password
    );

    //获取用户头像
    @GET("servlet/LoginServlet")
    Observable<AccountInfo> getUserCover(@Query("action") String action, @Query("id") String id);

    //更新简历基本信息
    @GET("servlet/VitageServlet")
    Observable<UpdateResult> updateVitageUser(
            @Query("action") String action,
            @Query("id") String id,
            @Query("name") String name,
            @Query("sex") String sex,
            @Query("brithday") String brithday,
            @Query("education") String education,
            @Query("worktime") String worktime,
            @Query("phone") String phone,
            @Query("email") String email,
            @Query("city") String city
    );

    //获取简历基本信息
    @GET("servlet/VitageServlet")
    Observable<VitageBean> getVitageUser(
            @Query("action") String action,
            @Query("id") String id
    );

    //添加工作经历
    @GET("servlet/VitageServlet")
    Observable<UpdateResult> addWorkExperience(
            @Query("action") String action,
            @Query("id") String id,
            @Query("companyname") String companyname,
            @Query("position") String position,
            @Query("starttime") String starttime,
            @Query("endtime") String endtime,
            @Query("content") String content
    );

    //获取工作经历
    @GET("servlet/VitageServlet")
    Observable<WorkExperience> getWorkExperienceList(
            @Query("action") String action,
            @Query("id") String id
    );

    //获取项目经历
    @GET("servlet/VitageServlet")
    Observable<Project> getProjectList(
            @Query("action") String action,
            @Query("id") String id
    );

    //添加教育经历
    @GET("servlet/VitageServlet")
    Observable<UpdateResult> addEducation(
            @Query("action") String action,
            @Query("id") String id,
            @Query("schoolname") String schoolname,
            @Query("major") String major,
            @Query("graduationtime") String graduationtime,
            @Query("education") String education
    );

    //获取教育经历
    @GET("servlet/VitageServlet")
    Observable<Education> getEducationList(
            @Query("action") String action,
            @Query("id") String id
    );

    //获取期望工作
    @GET("servlet/VitageServlet")
    Observable<HopeJob> getHopeJob(
            @Query("action") String action,
            @Query("id") String id
    );

    //更新期望工作
    @GET("servlet/VitageServlet")
    Observable<UpdateResult> updateHopeJob(
            @Query("action") String action,
            @Query("id") String id,
            @Query("hopeposition") String hopeposition,
            @Query("jobtype") String jobtype,
            @Query("city") String city,
            @Query("money") String money,
            @Query("content") String content
    );

    //添加项目经历
    @GET("servlet/VitageServlet")
    Observable<UpdateResult> addProject(
            @Query("action") String action,
            @Query("id") String id,
            @Query("projectname") String projectname,
            @Query("responsibility") String responsibility,
            @Query("starttime") String starttime,
            @Query("endtime") String endtime,
            @Query("content") String content
    );

    //查询工作职位
    @GET("servlet/RecruitServlet")
    Observable<Recruit> searchRecruitment(
            @Query("action") String action,
            @Query("query") String query,
            @Query("city") String city,
            @Query("type") String type,
            @Query("education") String education
    );

    //根据用户ID获取他管理公司的职位
    @GET("servlet/RecruitServlet")
    Observable<EnterprisePosition> getPositionByCompanyId(
            @Query("action") String action,
            @Query("id") String id
    );

    //获取收藏列表
    @GET("servlet/CollectServlet")
    Observable<CollectionBean> getCollection(
            @Query("action") String action,
            @Query("id") String id
    );

    //删除收藏
    @GET("servlet/CollectServlet")
    Observable<UpdateResult> deleteCollectionById(
            @Query("action") String action,
            @Query("id") String id,
            @Query("recruitid") String recruitid
    );

    //发送简历
    @GET("servlet/RecruitServlet")
    Observable<UpdateResult> pushVitage(
            @Query("action") String action,
            @Query("id") String id,
            @Query("recruitId") int recruitId,
            @Query("companyId") int companyId
    );

    //添加收藏
    @GET("servlet/CollectServlet")
    Observable<UpdateResult> addCollection(
            @Query("action") String action,
            @Query("id") String id,
            @Query("recruitid") String recruitId
    );

    //添加收藏
    @GET("servlet/CollectServlet")
    Observable<UpdateResult> isCollection(
            @Query("action") String action,
            @Query("id") String id,
            @Query("recruitid") String recruitId
    );

    //获取简历
    @GET("servlet/RecruitServlet")
    Observable<UserVitage> getUserVitage(
            @Query("action") String action,
            @Query("id") String id,
            @Query("state") String state

    );

    //获取企业信息
    @GET("servlet/CompanyServlet")
    Observable<CompanyInfo> getEnterpriseInfo(
            @Query("action") String action,
            @Query("id") String id
    );

    //更新企业名称
    @GET("servlet/CompanyServlet")
    Observable<UpdateResult> updateCompanyNameById(
            @Query("action") String action,
            @Query("name") String name,
            @Query("id") String id
    );

    //更新企业情况
    @GET("servlet/CompanyServlet")
    Observable<UpdateResult> updateCompanyConditionById(
            @Query("action") String action,
            @Query("financing") String financing,
            @Query("pattern") String pattern,
            @Query("startnumber") String startnumber,
            @Query("endnumber") String endnumber,
            @Query("id") String id
    );

    //获取企业介绍
    @GET("servlet/CompanyServlet")
    Observable<CompanyDescpt> getCompanyControduceById(
            @Query("action") String action,
            @Query("id") String id
    );

    //更新企业介绍
    @GET("servlet/CompanyServlet")
    Observable<UpdateResult> updateCompanyControduceById(
            @Query("action") String action,
            @Query("id") String id,
            @Query("content") String content
    );

    //获取企业产品介绍
    @GET("servlet/CompanyServlet")
    Observable<CompanyProject> getProjectControduceById(
            @Query("action") String action,
            @Query("id") String id
    );

    //更新企业产品介绍
    @GET("servlet/CompanyServlet")
    Observable<UpdateResult> updateProjectControduceById(
            @Query("action") String action,
            @Query("id") String id,
            @Query("content") String content
    );

    //获取企业介绍
    @GET("servlet/CompanyServlet")
    Observable<CompanyPosition> getCompanyPositionById(
            @Query("action") String action,
            @Query("id") String id
    );

    //获取投递的简历
    @GET("servlet/VitageServlet")
    Observable<VitageInfo> getVitageInfoById(
            @Query("action") String action,
            @Query("id") String id
    );

    //获取投递记录
    @GET("servlet/VitageServlet")
    Observable<VitageDetailBean> getVitageDetail(
            @Query("action") String action,
            @Query("id") String id
    );

    //更新简历状态
    @GET("servlet/VitageServlet")
    Observable<UpdateResult> updateVitageState(
            @Query("action") String action,
            @Query("id") String id,
            @Query("state") String state,
            @Query("result") String result
    );

    //添加职位
    @GET("servlet/CompanyServlet")
    Observable<UpdateResult> addCompanyPosition(
            @Query("action") String action,
            @Query("id") String id,
            @Query("position") String position,
            @Query("type") String type,
            @Query("education") String education,
            @Query("number") String number,
            @Query("startwarge") String startwarge,
            @Query("endwarge") String endwarge,
            @Query("startworktime") String startworktime,
            @Query("endworktime") String endworktime,
            @Query("city") String city,
            @Query("address") String address,
            @Query("content") String content
    );

    //获取投递的简历
    @GET("servlet/RecruitServlet")
    Observable<VitageStateBean> getAllStateVitage(
            @Query("action") String action,
            @Query("id") String id,
            @Query("state") String state
    );


    //获取投递的简历
    @GET("servlet/CompanyServlet")
    Observable<UpdateResult> applyEnterprise(
            @Query("action") String action,
            @Query("id") String id,
            @Query("companyname") String companyname
    );
}
