package com.zat.finance.utils.source

interface ApiCaller {

//    @Multipart
//    @POST("api/register")
//    suspend fun register(
//        @Part("email") email: RequestBody,
//        @Part("firstname") firstname: RequestBody,
//        @Part("lastname") lastname: RequestBody,
//        @Part("mobile") mobile: RequestBody,
//        @Part("password") password: RequestBody,
//        @Part("password_confirmation") password_confirmation: RequestBody,
//        @Part("device_token") device_token: RequestBody,
//        @Part("gender") gender: RequestBody,
//        @Part imageFile: MultipartBody.Part?,
//        @Part("user_type") user_type: RequestBody
//    ): Response<RegisterMianModel>
//
//    @Multipart
//    @POST("api/group/store")
//    suspend fun creatGroup(
//        @Part("name") name: RequestBody,
//        @Part("description") description:RequestBody,
//        @Part("category_id") category_id:RequestBody,
//        @Part imageFile:MultipartBody.Part?,
//    ):Response<CreateGroupMainModel>
//
//    @Multipart
//    @POST("api/feed/store")
//    suspend fun createFeed(
//        @Part("title") title:RequestBody,
//        @Part("category_id") category_id:RequestBody,
//        @Part("description") description:RequestBody,
//        @Part media_url:MultipartBody.Part?,
//        @Part("media_type") media_type:RequestBody
//    ):Response<SimpleMessageModel>
//
//    @Multipart
//    @POST("api/user/update-profile")
//    suspend fun updateProfile(
//        @Part("mobile") mobile:RequestBody,
//        @Part("lastname") lastname:RequestBody,
//        @Part image:MultipartBody.Part?
//    ):Response<LoginMainModel>
//
//
//    @POST("api/match-otp")
//    suspend fun matchOTP(@Body matchOtpRequestModel: MatchOtpRequestModel): Response<LoginMainModel>
//
//    @POST("api/login")
//    suspend fun login(@Body loginRequestModel: LoginRequestModel): Response<LoginMainModel>
//
//    @POST("api/generate-new-otp")
//    suspend fun ResendOtp(@Body resendOTPRequest: ResendOTPRequest): Response<SimpleMessageModel>
//
//    @POST("api/forget-password")
//    suspend fun forgotPassword(@Body forgotPasswardRequestModel: ForgotPasswardRequestModel): Response<LoginMainModel>
//
//    @POST("api/match-pin")
//    suspend fun matchPin(@Body matchPinRequest: MatchPinRequest):Response<SimpleMessageModel>
//
//    @POST("api/change-password")
//    suspend fun newPassWord(@Body newPasswordRequest: NewPasswordRequest):Response<SimpleMessageModel>
//
//    @POST("api/logout")
//    suspend fun logout(): Response<SimpleMessageModel>
//
//    @POST("api/feed/report")
//    suspend fun reportFeed(@Body reportFeed: ReportFeedRequest):Response<SimpleMessageModel>
//
//    @POST("api/feed/{feed_id}/give-comment")
//    suspend fun feedComment(@Path("feed_id") feed_id:Int,
//                            @Body commentRequestModel: CommentRequestModel)
//                            :Response<SimpleMessageModel>
//
//    @POST("api/feed/{feed_id}/like-unlike")
//    suspend fun likedFeed(@Path ("feed_id") feed_id: Int):Response<SimpleMessageModel>
//
//    @POST("api/feed/{feed_id}/share")
//    suspend fun shareFeed(@Path("feed_id") feed_id: Int):Response<SimpleMessageModel>
//
//
//    @GET("api/privacy-policy")
//    suspend fun privacyPolicy(): Response<StaticDataMainModel>
//
//    @GET("api/terms-and-conditions")
//    suspend fun termsAndCondition(): Response<StaticDataMainModel>
//
//    @GET("api/feed")
//        suspend fun getAllFeeds():Response<FeedMainModel>
//
//    @GET("api/feed/get-comments/{feed_id}")
//    suspend fun getComments(@Path("feed_id") feed_id: Int):Response<FeedCommentMainModel>
//
//    @GET("api/user/get-profile")
//    suspend fun getPropfile() : Response<LoginMainModel>
//
//    @GET("api/getUser")
//    suspend fun getAllUser():Response<UserDetailModel>
//
//    @GET("api/getLeader")
//    suspend fun getAllLeader():Response<LeaderDetailMainModel>
//
//    @GET("api/categories")
//    suspend fun getAllCategory():Response<CategoryMainModel>
//
//    @GET("api/group")
//    suspend fun getAllGroup():Response<GroupMainModels>
}