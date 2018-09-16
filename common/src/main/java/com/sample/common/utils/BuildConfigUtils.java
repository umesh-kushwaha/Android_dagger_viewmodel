package com.sample.common.utils;


public class BuildConfigUtils {

    private String apiBaseUrl;
    private String imageBaseUrl;
    private String privacyPolicyUrl;
    private String termsAndConditionUrl;
    private String facebookPageUrl;
    private String twitterPageUrl;
    private String instagramPageUrl;
    private String yourTubeUrl;
    private String faqUrl;

    private String applicationId;

    private BuildConfigUtils(){

    }

    public static BuildConfigUtils getInstance(){
        return SingletonHelper.INSTANCE;
    }

    private static class SingletonHelper{
        private static final BuildConfigUtils INSTANCE = new BuildConfigUtils();
    }

    public String getApiBaseUrl() {
        return apiBaseUrl;
    }

    public void setApiBaseUrl(String apiBaseUrl) {
        this.apiBaseUrl = apiBaseUrl;
    }

    public String getImageBaseUrl() {
        return imageBaseUrl;
    }

    public void setImageBaseUrl(String imageBaseUrl) {
        this.imageBaseUrl = imageBaseUrl;
    }

    public String getPrivacyPolicyUrl() {
        return privacyPolicyUrl;
    }

    public void setPrivacyPolicyUrl(String privacyPolicyUrl) {
        this.privacyPolicyUrl = privacyPolicyUrl;
    }

    public String getTermsAndConditionUrl() {
        return termsAndConditionUrl;
    }

    public void setTermsAndConditionUrl(String termsAndConditionUrl) {
        this.termsAndConditionUrl = termsAndConditionUrl;
    }

    public String getFacebookPageUrl() {
        return facebookPageUrl;
    }

    public void setFacebookPageUrl(String facebookPageUrl) {
        this.facebookPageUrl = facebookPageUrl;
    }

    public String getTwitterPageUrl() {
        return twitterPageUrl;
    }

    public void setTwitterPageUrl(String twitterPageUrl) {
        this.twitterPageUrl = twitterPageUrl;
    }

    public String getInstagramPageUrl() {
        return instagramPageUrl;
    }

    public void setInstagramPageUrl(String instagramPageUrl) {
        this.instagramPageUrl = instagramPageUrl;
    }

    public String getYourTubeUrl() {
        return yourTubeUrl;
    }

    public void setYourTubeUrl(String yourTubeUrl) {
        this.yourTubeUrl = yourTubeUrl;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getFaqUrl() {
        return faqUrl;
    }

    public void setFaqUrl(String faq) {
        this.faqUrl = faq;
    }
}
