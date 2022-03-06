package pgm.poolp.ugcanvas.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pgm.poolp.ugcanvas.data.Team
import pgm.poolp.ugcanvas.data.UGCanvasRoomDatabase

class TeamsDatabaseWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            val filename = inputData.getString(TEAMS_KEY_FILENAME)
            if (filename != null) {
                applicationContext.assets.open(filename).use { inputStream ->
                    JsonReader(inputStream.reader()).use { jsonReader ->
                        val teamType = object : TypeToken<List<Team>>() {}.type
                        val teamsList: List<Team> = Gson().fromJson(jsonReader, teamType)

                        val database = UGCanvasRoomDatabase.getInstance(applicationContext)
                        database.teamsDAO().insertAll(teamsList)

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

    companion object {
        private const val TAG = "TeamsDatabaseWorker"
        const val TEAMS_KEY_FILENAME = "TEAMS_DATA_FILENAME"
    }
}
