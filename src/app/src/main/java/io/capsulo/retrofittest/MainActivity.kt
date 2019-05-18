package io.capsulo.retrofittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.capsulo.retrofittest.data.RetrofitImpl
import io.capsulo.retrofittest.data.User
import io.capsulo.retrofittest.data.UserService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    val TAG: String = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetch_photos_main.setOnClickListener { init() }
    }


    /**
     * Start app features.
     */
    fun init() {
        // Get UserService object
        val service: UserService = RetrofitImpl
            .getInstance()
            ?.create(UserService::class.java) as UserService

        // Fetch all users asynchronously
        val call: Call<List<User>> = service.getAllUsers()
        call.enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Log.i(TAG, "Failure.")
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                response.body()?.let {
                    for(user in it) {
                        println("user => $user.company")
                    }
                }
            }
        })
    }
}
