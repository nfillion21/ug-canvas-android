package pgm.poolp.ugcanvas.data

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class UGCanvasRepository @Inject constructor () {

    val dbReference = Firebase.database("https://ug-canvas-default-rtdb.europe-west1.firebasedatabase.app/").getReference("canvas")

    @OptIn(ExperimentalCoroutinesApi::class)
    fun getDataBoard() = callbackFlow {

        dbReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue<String>()
                if (value == null) {
                    trySend(null)
                }
                else {
                    //dataBoard = value
                    trySend(value)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                trySend(null)
            }
        })

        awaitClose {
        }
    }

    fun setDataBoard(data:String) {
        dbReference.setValue(data)
    }
}