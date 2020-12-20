/**
 * Copyright (C) 2020 Fernando Cejas Open Source Project
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
package com.dre.loyalty.core.di

import com.dre.loyalty.AndroidApplication
import com.dre.loyalty.core.di.viewmodel.ViewModelModule
import com.dre.loyalty.core.navigation.RouteActivity
import com.dre.loyalty.features.authenticationselector.presentation.AuthenticationSelectorFragment
import com.dre.loyalty.features.login.presentation.LoginFragment
import com.dre.loyalty.features.register.presentation.RegisterFragment
import com.dre.loyalty.features.movies.MovieDetailsFragment
import com.dre.loyalty.features.movies.MoviesFragment
import com.dre.loyalty.features.pin.presentation.PinFragment
import com.dre.loyalty.features.splash.presentation.SplashScreenActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ViewModelModule::class])
interface ApplicationComponent {
    fun inject(application: AndroidApplication)
    fun inject(routeActivity: RouteActivity)
    fun inject(activity: SplashScreenActivity)

    fun inject(fragment: RegisterFragment)
    fun inject(fragment: LoginFragment)
    fun inject(fragment: PinFragment)
    fun inject(fragment: AuthenticationSelectorFragment)
    fun inject(moviesFragment: MoviesFragment)
    fun inject(movieDetailsFragment: MovieDetailsFragment)
}
