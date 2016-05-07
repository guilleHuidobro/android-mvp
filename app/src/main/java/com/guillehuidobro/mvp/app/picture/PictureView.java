package com.guillehuidobro.mvp.app.picture;

import android.content.Context;
import android.content.IntentFilter;

import com.guillehuidobro.mvp.app.utils.InterfaceCommon;

/**
 * Created by guille on 06/05/2016.
 */
public interface PictureView extends InterfaceCommon{
    void navigateTo();

    public void showMessage(String msg);
}
