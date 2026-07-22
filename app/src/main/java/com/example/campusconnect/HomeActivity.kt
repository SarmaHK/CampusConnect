package com.example.campusconnect

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        // Receive username
        val username = intent.getStringExtra("USERNAME") ?: "User"
        tvWelcome.text = getString(R.string.welcome_user, username)

        // Logout Menu
        toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menuLogout -> {
                    AlertDialog.Builder(this)
                        .setTitle(getString(R.string.logout_confirm_title))
                        .setMessage(getString(R.string.logout_confirm_msg))
                        .setPositiveButton(getString(R.string.yes)) { _, _ ->
                            startActivity(Intent(this, MainActivity::class.java))
                            finish()
                        }
                        .setNegativeButton(getString(R.string.cancel), null)
                        .show()
                    true
                }
                else -> false
            }
        }

        // Bottom Navigation
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navHome -> {
                    tvWelcome.text = getString(R.string.welcome_user, username)
                    true
                }
                R.id.navMembers -> {
                    startActivity(Intent(this, MembersActivity::class.java))
                    true
                }
                R.id.navProfile -> {
                    tvWelcome.text = getString(R.string.profile_screen)
                    true
                }
                else -> false
            }
        }
    }
}