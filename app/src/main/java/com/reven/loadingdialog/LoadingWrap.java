package com.reven.loadingdialog;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

/**
 * Created by LiuCongshan on 2016/7/1.
 * LoadingWrap
 */
public class LoadingWrap {
    private static Dialog dialog;
    private static TextView tvMessage;

    public static void show(Context context) {
        show(context, "");
    }

    public static void setCanceledOnTouchOutside(boolean cancel) {
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(cancel);
        }
    }

    public static void setCancelable(boolean flag) {
        if (dialog != null) {
            dialog.setCancelable(flag);
        }
    }

    public static void show(Context context, String message) {
        if (context == null) {
            return;
        }

        if (dialog == null || dialog.getContext() != context) {
            dialog = new Dialog(context, R.style.LoadingDialog);
            dialog.setContentView(R.layout.dialog_loading);
            //            dialog.setCancelable(false);
            //            dialog.setCanceledOnTouchOutside(false);
            tvMessage = (TextView) dialog.findViewById(R.id.tv_message);
        }
        dialog.show();

        if (tvMessage == null) {
            tvMessage = (TextView) dialog.findViewById(R.id.tv_message);
        }
        if (tvMessage != null) {
            if (TextUtils.isEmpty(message)) {
                tvMessage.setVisibility(View.GONE);
            } else {
                tvMessage.setVisibility(View.VISIBLE);
                tvMessage.setText(message);
            }
        }
    }

    public static void close() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
