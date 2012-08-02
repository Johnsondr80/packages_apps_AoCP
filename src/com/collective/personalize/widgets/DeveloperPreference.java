
package com.collective.personalize.widgets;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.collective.personalize.R;

public class DeveloperPreference extends Preference {

    TextView mName;
    TextView twitter;
    TextView profileText;
    ImageView icon;
    LinearLayout twitterLayout;
    LinearLayout profileLayout;
    ImageView profileButton;

    String twitterHandle;
    String profileLink;
    String name;

    public DeveloperPreference(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DeveloperPreference);
        twitterHandle = a.getString(R.styleable.DeveloperPreference_twitterHandle);
        profileLink = a.getString(R.styleable.DeveloperPreference_profileLink);
        a.recycle();

    }

    @Override
    protected View onCreateView(ViewGroup parent) {

        View layout = View.inflate(getContext(), R.layout.developer_preference, null);

        mName = (TextView) layout.findViewById(com.android.internal.R.id.title);
        twitter = (TextView) layout.findViewById(R.id.twitter_handle);
        profileButton = (ImageView) layout.findViewById(R.id.profile_team);
        twitterLayout = (LinearLayout) layout.findViewById(R.id.twitter_layout);
        icon = (ImageView) layout.findViewById(R.id.twitter_icon);

        return layout;
    }

    @Override
    protected void onBindView(View view) {
        super.onBindView(view);

        twitter.setText(twitterHandle);
        icon.setImageResource(R.drawable.twitter_bird);

        if (twitterHandle == null) {
            twitterLayout.setVisibility(View.GONE);
        } else
            this.setOnPreferenceClickListener(new OnPreferenceClickListener() {
                @Override
                public boolean onPreferenceClick(Preference preference) {
                    Uri uriUrl = Uri.parse("http://twitter.com/#!/" + twitterHandle);
                    Intent twitter = new Intent(Intent.ACTION_VIEW, uriUrl);
                    getContext().startActivity(twitter);
                    return true;
                }
            });

        if (profileLink == null)
            profileButton.setVisibility(View.GONE);
        else
            profileButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uriUrl = Uri.parse(profileLink);
                    Intent profile = new Intent(Intent.ACTION_VIEW, uriUrl);
                    getContext().startActivity(profile);
                }
            });

    }
}
