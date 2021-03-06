package com.brunoaybar.unofficialupc.data.source.injection;

import android.content.Context;

import com.brunoaybar.unofficialupc.UpcApplication;
import com.brunoaybar.unofficialupc.analytics.AppRemoteConfig;
import com.brunoaybar.unofficialupc.data.source.interfaces.ApplicationDao;
import com.brunoaybar.unofficialupc.utils.interfaces.InternetVerifier;
import com.brunoaybar.unofficialupc.data.source.interfaces.RemoteSource;
import com.brunoaybar.unofficialupc.data.source.preferences.UserPreferencesDataSource;
import com.brunoaybar.unofficialupc.data.source.remote.UpcServiceDataSource;
import com.brunoaybar.unofficialupc.utils.interfaces.DateProvider;
import com.brunoaybar.unofficialupc.utils.interfaces.StringProvider;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by brunoaybar on 11/03/2017.
 */

@Module
public class DataModule {

    @Inject Context context;
    @Inject DateProvider dateProvider;
    @Inject InternetVerifier internetVerifier;
    @Inject AppRemoteConfig remoteConfig;
    @Inject StringProvider stringProvider;

    public DataModule(){
        UpcApplication.getComponent().inject(this);
    }

    @Provides @Singleton
    public ApplicationDao provideDao(){
        return new UserPreferencesDataSource(context,dateProvider);
    }

    @Provides @Singleton
    public Context provideContext(){
        return context;
    }

    @Provides @Singleton
    public RemoteSource provideService(){
        return new UpcServiceDataSource();
    }

    @Provides @Singleton
    public InternetVerifier providerInternetVerifier(){
        return internetVerifier;
    }

    @Provides @Singleton
    public AppRemoteConfig provideRemoteConfig(){
        return remoteConfig;
    }

    @Provides @Singleton
    public DateProvider provideDateProvider(){
        return dateProvider;
    }

    @Provides @Singleton
    public StringProvider provideStringProvider(){
        return stringProvider;
    }
}
