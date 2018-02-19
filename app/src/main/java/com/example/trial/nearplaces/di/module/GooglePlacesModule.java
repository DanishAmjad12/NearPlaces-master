/*
 * Copyright (c) 2016 Filippo Engidashet
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.trial.nearplaces.di.module;

import com.example.trial.nearplaces.api.APIService;
import com.example.trial.nearplaces.di.scope.PerActivity;
import com.example.trial.nearplaces.mvp.view.MainView;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * @author Filippo Engidashet <filippo.eng@gmail.com>
 * @version 1.0.0
 * @since 9/24/2016
 */
@Module
public class GooglePlacesModule {

    private MainView mView;

    public GooglePlacesModule(MainView view) {
        mView = view;
    }

    @PerActivity
    @Provides
    APIService provideApiService(Retrofit retrofit) {
        return retrofit.create(APIService.class);
    }

    @PerActivity
    @Provides
    MainView provideView() {
        return mView;
    }
}
