package com.example.personnal_project_heim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.personnal_project_heim.databinding.ActivityMainBinding
import com.example.personnal_project_heim.datatypes.PlaceTypes
import com.example.personnal_project_heim.datatypes.Places
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

const val MAIN_ACT_KEY = "MainActivity"
var places: Array<Places> = emptyArray()
class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val rootView = binding.root
        setContentView(rootView)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


        binding.helloWordTextView.text = "Hello Android"
        Log.i("MainActivity", binding.helloWordTextView.text.toString())

        // This is the first request to load all the places
        val client =  OkHttpClient()
        val request = Request.Builder().url("https://gist.githubusercontent.com/saravanabalagi/541a511eb71c366e0bf3eecbee2dab0a/raw/bb1529d2e5b71fd06760cb030d6e15d6d56c34b3/places.json").build()
        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e(MAIN_ACT_KEY, "Exception: $e")
            }


            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val bodyString = response.body?.string()
                    val gson = Gson()
                    places = gson.fromJson(bodyString, Array<Places>::class.java)
                    // places.forEach { Log.i(MAIN_ACT_KEY, "showdata: $it.toString()") }
                    Log.i(MAIN_ACT_KEY,places.toString())
                }
            }
        })

        // This is the second request to load the place types
        val client2 =  OkHttpClient()
        val request2 = Request.Builder().url("https://gist.githubusercontent.com/saravanabalagi/541a511eb71c366e0bf3eecbee2dab0a/raw/bb1529d2e5b71fd06760cb030d6e15d6d56c34b3/place_types.json").build()
        client2.newCall(request2).enqueue(object: Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.i(MAIN_ACT_KEY, "Exception: $e")
            }


            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val bodyString = response.body?.string()
                    val gson = Gson()
                    // Here I tried to put the data in an array, it's not working at all
                    var placeTypes = gson.fromJson(bodyString, Array<PlaceTypes>::class.java)
                    // places.forEach { Log.i(MAIN_ACT_KEY, "showdata: $it.toString()") }
                    Log.e(MAIN_ACT_KEY, "showdata: $placeTypes.toString(4)")
                }
            }
        })
    }

    override fun onMapReady(gm: GoogleMap) {
        // this is the example I wanted to follow to display the markers inside a foreach() loop
        val sydney = LatLng(-34.0, 151.0)
        gm.addMarker(
            MarkerOptions()
                .position(sydney)
                .title("Marker in Sydney"))
        gm.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}
