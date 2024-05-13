package com.example.virginmoneyhilt

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import com.example.virginmoneyhilt.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_people_list) as NavHostFragment
        val navController = navHostFragment.navController


        //This will handle the Bottom navigation. Switches between People and Rooms Fragment
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_people_list -> navController.navigate(R.id.nav_people_list)//replaceFragment(PersonListFragment())
                R.id.nav_rooms -> navController.navigate(R.id.nav_rooms)//replaceFragment(RoomListFragment())
                else ->{}
            }
            true
        }

        //hide bottom nav
        navController.addOnDestinationChangedListener{_,destination, _ ->
            if(destination.id == R.id.personDetailsFragment){
                binding.bottomNavigationView.visibility = View.GONE
            }else{
                binding.bottomNavigationView.visibility = View.VISIBLE
            }
        }


    }





//  private fun replaceFragment (fragment: Fragment){
//        val fragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.frameLayout,fragment)
//        fragmentTransaction.commit()
//
//    }
}