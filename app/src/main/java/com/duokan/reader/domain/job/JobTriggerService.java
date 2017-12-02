package com.duokan.reader.domain.job;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.a;
import com.duokan.reader.DkApp;

@TargetApi(21)
public class JobTriggerService extends JobService {
    public boolean onStartJob(JobParameters jobParameters) {
        if (DkApp.get().forCommunity()) {
            a.c().a(LogLevel.EVENT, "job", "a trigger service started(id: %d)", Integer.valueOf(jobParameters.getJobId()));
        }
        b.a().a(new f(this, jobParameters));
        return false;
    }

    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}