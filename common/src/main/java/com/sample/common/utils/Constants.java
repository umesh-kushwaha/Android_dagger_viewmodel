package com.sample.common.utils;

/**
 * Created by Umesh on 10-03-2018.
 */

public interface Constants {

    public interface PreferenceKey {
        String OAUTH_DETIALS = "oauth_details";
        String USER_DETAILS = "user_details";
        String USER_PROFILES = "USER_PROFILES";
        String USER_PROFILE_ID = "user_profile_id";
        String USER_CATEGORY = "buyer_or_seller";
        String VARIANT_IMAGE_EDIT_ACTION_DONE = "is_action_is_performed_on_image";
        String IMAGE_SERVER_BASE_URL = "http://54.70.142.5/";
    }

    String LOGOUT_ACTION = "com.retailerbook.logout";
    String NETWORK_CONNECTED_ACTION = "com.retailerbook.internet.connected";

    interface OrderType {
        int RETURN_NEW = 11;
        int RETURN_ITEM_PICKED_UP = 12;// ;// When Pickup has been successfully done
        int RETURN_CANCELED = 13;// Buyer may cancel the return
        int RETURN_CONFIRMED = 14;// In case of unsold returns (seller confirmation)
        int RETURN_COMPLETE = 15;
        int RETURN_FAILED = 16;
        int RETURN_REJECTED = 17;// In case of unsold returns seller can reject the return
        int RETURN_CANCELED_BY_RETBOOK = 18;

        int EXCHANGE_NEW = 21;
        int EXCHANGE_ITEM_PICKED_UP = 22;// When Pickup has been successfully done
        int EXCHANGE_CANCELED = 23;// Buyer may cancel the request
        int EXCHANGE_CONFIRMED = 24;// In case of exchange  (seller confirmation)
        int EXCHANGE_COMPLETE = 25;
        int EXCHANGE_DISPATCHED = 26;
        int EXCHANGE_FAILED = 27;
        int EXCHANGE_REJECTED = 28;// seller may reject the request
        int EXCHANGE_CANCELED_BY_RETBOOK = 29;

        int ORDER_NEW = 1;
        int ORDER_CONFIRMED_BY_RETAILERS_BOOK=2;
        int ORDER_CONFIRMED = 3;
        int ORDER_PROCESSING = 4;
        int ORDER_DISPATCHED = 5;
        int ORDER_DELIVERED = 6;
        int ORDER_CANCELED_BY_RETBOOK = 7;
        int ORDER_CANCELED_BY_SELLER = 8;
        int ORDER_CANCELED_BY_BUYER = 9;
    }

    interface RequestType{
        int RETURN_REQUEST = 1;
        int EXCHANGE_REQUEST = 2;
    }

    interface WebView{
        String EXTRA_URL = "EXTRA_URL";
        String EXTRA_TITLE = "EXTRA_TITLE";
    }

    String privacyPolicyUrl = "file:///android_asset/termandconditions.html";
    String termsAndConditionUrl = "file:///android_asset/termandconditions.html";
}
