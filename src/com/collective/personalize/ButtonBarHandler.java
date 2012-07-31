
package com.collective.personalize;

/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.widget.Button;

/**
 * Interface letting {@link COLLECTIVEPreferenceFragment} access to bottom bar inside
 * {@link android.preference.PreferenceActivity}.
 */
public interface ButtonBarHandler {
    public boolean hasNextButton();

    public Button getNextButton();
}
