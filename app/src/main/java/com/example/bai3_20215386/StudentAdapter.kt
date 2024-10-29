package com.example.bai3_20215386

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(private var students: List<Student>) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    // ViewHolder cho từng mục trong RecyclerView
    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_name)
        val tvMssv: TextView = itemView.findViewById(R.id.tv_mssv)
    }

    // Tạo ViewHolder và layout cho từng item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_student, parent, false)
        return StudentViewHolder(view)
    }

    // Gắn dữ liệu vào ViewHolder
    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.tvName.text = student.name
        holder.tvMssv.text = student.mssv
    }

    override fun getItemCount(): Int {
        return students.size
    }

    // Cập nhật danh sách sinh viên khi tìm kiếm
    fun updateList(newList: List<Student>) {
        students = newList
        notifyDataSetChanged()
    }
}
