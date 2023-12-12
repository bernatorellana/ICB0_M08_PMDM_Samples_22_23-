package org.milaifontanals.webviewapp;

import android.webkit.JavascriptInterface;

public class JavaInterface {

    @JavascriptInterface
    public String getContacts(){

        return "<ul><li>Primer</li><li>Segon</li></ul> ";
    }

}
