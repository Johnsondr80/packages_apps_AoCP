
package com.collective.personalize.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceScreen;

import com.collective.personalize.COLLECTIVEPreferenceFragment;
import com.collective.personalize.R;

public class About extends COLLECTIVEPreferenceFragment {

    public static final String TAG = "About";

    Preference mSiteUrl;
    Preference mSourceUrl;
    Preference mReviewUrl;
    Preference mGplusUrl;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.prefs_about);
        mSiteUrl = findPreference("collective_website");
        mSourceUrl = findPreference("collective_source");
        mReviewUrl = findPreference("collective_review");
        mGplusUrl = findPreference("collective_gplus");

    }

    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        if (preference == mSiteUrl) {
            launchUrl("http://under.construction/");
        } else if (preference == mSourceUrl) {
            launchUrl("http://github.com/xAOCPx");
	} else if (preference == mReviewUrl) {
            launchUrl("http://notyetset");
        } else if (preference == mGplusUrl) {
            launchUrl("https://plus.google.com/118410901028408865706/posts");
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }

    private void launchUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent profile = new Intent(Intent.ACTION_VIEW, uriUrl);
        getActivity().startActivity(profile);
    }
}
