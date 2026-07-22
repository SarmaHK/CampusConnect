package com.example.campusconnect

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MembersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_members)

        // 1. Initialize RecyclerView
        val rvMembers = findViewById<RecyclerView>(R.id.rvMembers)
        
        // 2. Create sample list of members
        val memberList = listOf(
            Member("Sarma HK", "President"),
            Member("John Silva", "Vice President"),
            Member("Nimal Perera", "Secretary"),
            Member("Kavindi Fernando", "Treasurer"),
            Member("Amal Jayasinghe", "Member"),
            Member("Sasivarnasarma", "Marketing Coordinator")
        )

        // 3. Set LayoutManager and Adapter
        rvMembers.layoutManager = LinearLayoutManager(this)
        rvMembers.adapter = MemberAdapter(memberList)

        // 4. Setup Bottom Navigation
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigationMembers)
        bottomNavigation.selectedItemId = R.id.navMembers // Set current item as selected

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navHome -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                    true
                }
                R.id.navMembers -> {
                    // Already in MembersActivity
                    true
                }
                R.id.navProfile -> {
                    // Navigate to Profile if implemented
                    true
                }
                else -> false
            }
        }
    }
}
