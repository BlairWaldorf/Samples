
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;

import im.delight.android.webview.AdvancedWebView;

public class MainActivityAdvancedWebView extends AppCompatActivity implements AdvancedWebView.Listener {

    private AdvancedWebView mWebView;
    Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.example_advanced_webview);

        mWebView = (AdvancedWebView) findViewById(R.id.webview);
        mWebView.setListener(this, this);
        mWebView.loadUrl("http://www.google.com/");
    }

    @SuppressLint("NewApi")
    @Override
    protected void onResume() {
        super.onResume();
        mWebView.onResume();
    }

    @SuppressLint("NewApi")
    @Override
    protected void onPause() {
        mWebView.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mWebView.onDestroy();
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        mWebView.onActivityResult(requestCode, resultCode, intent);
    }

    @Override
    public void onBackPressed() {
        if (!mWebView.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void onPageStarted(String url, Bitmap favicon) {
        if (snackbar!=null) {
            snackbar.dismiss();
        }
        snackbar = Snackbar.make(mWebView,"Loading...",Snackbar.LENGTH_INDEFINITE);
        snackbar.show();
    }

    @Override
    public void onPageFinished(String url) {
        if (snackbar!=null) {
            snackbar.dismiss();
        }
        snackbar = Snackbar.make(mWebView,"Loading Finished",Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    @Override
    public void onPageError(int errorCode, String description, String failingUrl) {
        if (snackbar!=null) {
            snackbar.dismiss();
        }
        snackbar = Snackbar.make(mWebView,"An Error Occurred During Loading",Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    @Override
    public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) {
    }

    @Override
    public void onExternalPageRequest(String url) {
    }
}
