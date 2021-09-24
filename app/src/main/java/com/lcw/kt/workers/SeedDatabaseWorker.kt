package com.lcw.kt.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *
 * desc: TODO
 *
 * create by lcz on 2021/9/23
 */
class SeedDatabaseWorker(context: Context, params: WorkerParameters) :
    CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        withContext(Dispatchers.IO) {

        }
        return Result.success()
    }


}