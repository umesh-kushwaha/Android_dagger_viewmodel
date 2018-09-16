package com.sample.common.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.ScrollView;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by Umesh on 10-03-2018.
 */

public class Utils {

    private static final String TAG = Utils.class.getName();
    public final static boolean isValidEmail(CharSequence email) {
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    public static String getFormattedPrice(Object price) {
        Double newPrice = Double.parseDouble(price + "");
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
        return format.format(newPrice)+"";
    }

    public static String getRequiredUrlForThisImage(ImageView imageView, String relativeUrl) {

        if(relativeUrl != null && relativeUrl.contains("http")){
            return relativeUrl;
        }
        int heightInPixel = imageView.getHeight();
        int widthInPixel = imageView.getWidth();
        if (heightInPixel == 0) {
            heightInPixel = 500;
        }
        if (widthInPixel == 0) {
            widthInPixel = 300;
        }
        if(heightInPixel > 512){
            heightInPixel = 512;
        }
        if(widthInPixel > 512){
            widthInPixel = 512;
        }
        // Log.d("Image dimension",heightInPixel+"X"+widthInPixel);
        return BuildConfigUtils.getInstance().getImageBaseUrl() + "media/" + heightInPixel + "-" + widthInPixel + "/" + relativeUrl;
    }

    public static String makeFirstCharacterCapital(String input) {
        char first = input.toCharArray()[0];
        first = Character.toUpperCase(first);
        if (input.length() > 1)
            return first + input.substring(1);
        else
            return first + "";
    }

    /**
     * Used to scroll to the given view.
     *
     * @param scrollViewParent Parent ScrollView
     * @param view View to which we need to scroll.
     */
    public static void scrollToView(final ScrollView scrollViewParent, final View view) {
        // Get deepChild Offset
        Point childOffset = new Point();
        getDeepChildOffset(scrollViewParent, view.getParent(), view, childOffset);
        // Scroll to child.
        scrollViewParent.smoothScrollTo(0, childOffset.y);
    }

    public static String html2text(String html) {
        return html.replace("<b>","").replace("</b>","").replace("<em>","").replace("</em>","");
    }

    public static void getDeepChildOffset(final ViewGroup mainParent, final ViewParent parent, final View child, final Point accumulatedOffset) {
        ViewGroup parentGroup = (ViewGroup) parent;
        accumulatedOffset.x += child.getLeft();
        accumulatedOffset.y += child.getTop();
        if (parentGroup.equals(mainParent)) {
            return;
        }
        getDeepChildOffset(mainParent, parentGroup.getParent(), parentGroup, accumulatedOffset);
    }

    public static float convertPixelsToDp(float px){
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float dp = px / (metrics.densityDpi / 160f);
        return Math.round(dp);
    }

    public static float convertDpToPixel(float dp){
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return Math.round(px);
    }

    public static int convertDpToPx(int dp){
        return Math.round(dp*(Resources.getSystem().getDisplayMetrics().xdpi/DisplayMetrics.DENSITY_DEFAULT));

    }

    public static int convertPxToDp(int px){
        return Math.round(px/(Resources.getSystem().getDisplayMetrics().xdpi/ DisplayMetrics.DENSITY_DEFAULT));
    }

    public static float dpFromPx(Context context,float px)
    {
        return px / context.getResources().getDisplayMetrics().density;
    }

    public static float pxFromDp(Context context,float dp)
    {
        return dp * context.getResources().getDisplayMetrics().density;
    }


    public static boolean isNetworkAvailable(Context context) {

        ConnectivityManager cm =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        Log.v(TAG, "Internet connection status : " + isConnected);

        return isConnected;
    }
}