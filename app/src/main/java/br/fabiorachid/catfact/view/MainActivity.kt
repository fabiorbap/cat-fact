package br.fabiorachid.catfact.view

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import br.fabiorachid.catfact.R
import br.fabiorachid.catfact.databinding.MainActivityBinding
import br.fabiorachid.catfact.viewmodel.FactsViewModel
import org.koin.androidx.viewmodel.ext.android.getStateViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    lateinit var factsViewModel: FactsViewModel
    lateinit var navView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        factsViewModel = getStateViewModel()
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        navView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_favorites
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}