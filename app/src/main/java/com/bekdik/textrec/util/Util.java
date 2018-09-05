package com.bekdik.textrec.util;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;


import static android.content.Context.CLIPBOARD_SERVICE;

/**
 * Created by NETIKOCAK on 05/09/2018.
 */

public class Util {
    private Context mContext;

    public void copy2Clipboard(String text) {
        ClipboardManager clipboard = (ClipboardManager) mContext.getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("label", text);
        clipboard.setPrimaryClip(clip);
    }

    public Util(Context mContext) {
        this.mContext = mContext;
    }

    public void sendAsEmail(String text) {
        final Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        String uriText =
                "mailto:" +
                        "?subject=" + Uri.encode("") +
                        "&body=" + Uri.encode(text);
        Uri uri = Uri.parse(uriText);
        emailIntent.setData(uri);

        try {
            mContext.startActivity(Intent.createChooser(emailIntent,
                    "Send email using..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(mContext,
                    "No email clients installed.",
                    Toast.LENGTH_SHORT).show();
        }

    }

    public void send2Whatsapp(String text) {

        PackageManager pm=mContext.getPackageManager();
        try {

            Intent waIntent = new Intent(Intent.ACTION_SEND);
            waIntent.setType("text/plain");


            PackageInfo info=pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
            //Check if package exists or not. If not then code
            //in catch block will be called
            waIntent.setPackage("com.whatsapp");

            waIntent.putExtra(Intent.EXTRA_TEXT, text);
            mContext.startActivity(Intent.createChooser(waIntent, "Share with"));

        } catch (PackageManager.NameNotFoundException e) {
            Toast.makeText(mContext, "WhatsApp not Installed", Toast.LENGTH_SHORT)
                    .show();
        }

    }

}

