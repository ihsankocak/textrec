package com.bekdik.textrec.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;


import static android.content.Context.CLIPBOARD_SERVICE;

/**
 * Created by NETIKOCAK on 05/09/2018.
 */

public class Util {
  private   Context mContext;
    public void copy2Clipboard(String text){
        ClipboardManager clipboard = (ClipboardManager) mContext.getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("label", text);
        clipboard.setPrimaryClip(clip);
    }

    public Util(Context mContext) {
        this.mContext = mContext;
    }
}
