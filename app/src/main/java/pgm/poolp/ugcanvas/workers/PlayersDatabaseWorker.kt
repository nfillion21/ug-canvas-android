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
import pgm.poolp.ugcanvas.data.Player
import pgm.poolp.ugcanvas.data.UGCanvasRoomDatabase

class PlayersDatabaseWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            val filename = inputData.getString(PLAYERS_KEY_FILENAME)
            if (filename != null) {
                applicationContext.assets.open(filename).use { inputStream ->
                    JsonReader(inputStream.reader()).use { jsonReader ->
                        val playerType = object : TypeToken<List<Player>>() {}.type
                        val playersList: List<Player> = Gson().fromJson(jsonReader, playerType)

                        val database = UGCanvasRoomDatabase.getInstance(applicationContext)
                        database.playersDAO().insertAll(playersList)

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
        private const val TAG = "PlayersDatabaseWorker"
        const val PLAYERS_KEY_FILENAME = "PLAYERS_DATA_FILENAME"
    }
}
