package com.example.campusconnect

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MemberAdapter(private val memberList: List<Member>) : RecyclerView.Adapter<MemberAdapter.MemberViewHolder>() {

    // ViewHolder class to hold the UI elements for each item
    class MemberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvMemberName)
        val tvRole: TextView = itemView.findViewById(R.id.tvMemberRole)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
        // Inflate the member_item.xml layout
        val view = LayoutInflater.from(parent.context).inflate(R.layout.member_item, parent, false)
        return MemberViewHolder(view)
    }

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) {
        // Get the current member from the list
        val currentMember = memberList[position]
        
        // Set the name and role in the TextViews
        holder.tvName.text = currentMember.name
        holder.tvRole.text = currentMember.role
    }

    override fun getItemCount(): Int {
        return memberList.size
    }
}
