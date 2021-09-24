package com.lcw.kt.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.lcw.kt.room.AppDatabase
import com.lcw.kt.room.PhotoImageEntity
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
            try {
                val filename = inputData.getString(KEY_FILENAME)
                if (filename != null) {
                    applicationContext.assets.open(filename).use { inputStream ->
                        JsonReader(inputStream.reader()).use { jsonReader ->
                            val plantType = object : TypeToken<List<PhotoImageEntity>>() {}.type
                            val plantList: List<PhotoImageEntity> = Gson().fromJson(jsonReader, plantType)

                            val database = AppDatabase.getInstance(applicationContext)
                            database.photoImageDao().insertAll(plantList)

                            Result.success()
                        }
                    }
                } else {
                    Log.e(TAG, "Error seeding database - no valid filename")
                    Result.failure()
                }
            } catch (ex: Exception) {
                Log.e(TAG, "Error seeding database", ex)
                Result.failure()
            }
        }
        return Result.success()
    }

    companion object {
        private const val TAG = "SeedDatabaseWorker"
        const val KEY_FILENAME = "LCW_DATA_FILENAME"
    }

}