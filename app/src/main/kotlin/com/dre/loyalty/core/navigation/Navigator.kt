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
package com.dre.loyalty.core.navigation

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import androidx.fragment.app.FragmentActivity
import com.dre.loyalty.core.extension.empty
import com.dre.loyalty.features.authenticationselector.presentation.AuthenticationSelectorActivity
import com.dre.loyalty.features.login.data.Authenticator
import com.dre.loyalty.features.login.presentation.LoginActivity
import com.dre.loyalty.features.movies.MovieDetailsActivity
import com.dre.loyalty.features.movies.MovieView
import com.dre.loyalty.features.movies.MoviesActivity
import com.dre.loyalty.features.pin.presentation.PinActivity
import com.dre.loyalty.features.register.presentation.RegisterActivity
import com.dre.loyalty.features.splash.presentation.SplashScreenActivity
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class Navigator @Inject constructor(private val authenticator: Authenticator) {

    fun showMain(context: Context) {
        when (authenticator.userLoggedIn()) {
            true -> showMovies(context)
            false -> showAuthSelector(context)
        }
    }

    fun showLogin(context: Context) = context.startActivity(LoginActivity.callingIntent(context))
    fun showRegister(context: Context) = context.startActivity(RegisterActivity.callingIntent(context))

    private fun showAuthSelector(context: Context) =
        context.startActivity(AuthenticationSelectorActivity.callingIntent(context))

    private fun showMovies(context: Context) = context.startActivity(MoviesActivity.callingIntent(context))

    fun showMovieDetails(activity: FragmentActivity, movie: MovieView, navigationExtras: Extras) {
        val intent = MovieDetailsActivity.callingIntent(activity, movie)
        val sharedView = navigationExtras.transitionSharedElement as ImageView
        val activityOptions = ActivityOptionsCompat
                .makeSceneTransitionAnimation(activity, sharedView, sharedView.transitionName)
        activity.startActivity(intent, activityOptions.toBundle())
    }

    private val VIDEO_URL_HTTP = "http://www.youtube.com/watch?v="
    private val VIDEO_URL_HTTPS = "https://www.youtube.com/watch?v="

    fun openVideo(context: Context, videoUrl: String) {
        try {
            context.startActivity(createYoutubeIntent(videoUrl))
        } catch (ex: ActivityNotFoundException) {
            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl)))
        }
    }

    private fun createYoutubeIntent(videoUrl: String): Intent {
        val videoId = when {
            videoUrl.startsWith(VIDEO_URL_HTTP) -> videoUrl.replace(VIDEO_URL_HTTP, String.empty())
            videoUrl.startsWith(VIDEO_URL_HTTPS) -> videoUrl.replace(VIDEO_URL_HTTPS, String.empty())
            else -> videoUrl
        }

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:$videoId"))
        intent.putExtra("force_fullscreen", true)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        return intent
    }

    fun showPin(context: Context) {
        context.startActivity(PinActivity.callingIntent(context))
    }

    fun showSplashScreen(context: Context) {
        context.startActivity(SplashScreenActivity.callingIntent(context))
    }

    class Extras(val transitionSharedElement: View)
}


