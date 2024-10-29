package com.example.bai3_20215386

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var studentAdapter: StudentAdapter
    private lateinit var studentList: List<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etSearch = findViewById<EditText>(R.id.et_search)
        val rvStudentList = findViewById<RecyclerView>(R.id.rv_student_list)

        // Tạo danh sách sinh viên mẫu
        studentList = listOf(
            Student("Nguyen Van An", "20214001"),
            Student("Le Thi Bach", "20204002"),
            Student("Tran Van Cuong", "20184003"),
            Student("Pham Thi Dung", "20194004"),
            Student("Nguyễn Minh Anh", "20191234"),
            Student("Trần Bảo Châu", "20202345"),
            Student("Lê Thị Thu Hà", "20183456"),
            Student("Phạm Thanh Huy", "20194567"),
            Student("Đặng Ngọc Anh", "20205678"),
            Student("Vũ Thị Lan", "20186789"),
            Student("Hoàng Văn Hùng", "20177890"),
            Student("Phạm Quỳnh Chi", "20218901"),
            Student("Đỗ Minh Quân", "20199012"),
            Student("Nguyễn Hải Nam", "20181123"),
            Student("Lý Phương Mai", "20192234"),
            Student("Đỗ Văn Bình", "20203345"),
            Student("Phan Quốc Bảo", "20194456"),
            Student("Trịnh Khánh Hòa", "20205567"),
            Student("Ngô Hoài Nam", "20186678"),
            Student("Lê Thanh Phong", "20197789"),
            Student("Nguyễn Hồng Sơn", "20208890"),
            Student("Đặng Thị Hoa", "20189901"),
            Student("Trần Văn Long", "20211012"),
            Student("Lê Thị Yến", "20192123"),
            Student("Phạm Văn Lộc", "20193234"),
            Student("Nguyễn Thị Cẩm Vân", "20204345"),
            Student("Bùi Văn Phát", "20195456"),
            Student("Hoàng Ngọc Thái", "20206567"),
            Student("Nguyễn Thanh Tú", "20187678"),
            Student("Phạm Bảo Ngọc", "20198789")
        )

        // Thiết lập Adapter và RecyclerView
        studentAdapter = StudentAdapter(studentList)
        rvStudentList.layoutManager = LinearLayoutManager(this)
        rvStudentList.adapter = studentAdapter

        // Lắng nghe thay đổi văn bản trong ô tìm kiếm
        etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterList(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    // Hàm lọc danh sách sinh viên theo từ khóa
    private fun filterList(keyword: String) {
        if (keyword.length > 2) {
            val filteredList = studentList.filter {
                it.name.contains(keyword, ignoreCase = true) || it.mssv.contains(keyword, ignoreCase = true)
            }
            studentAdapter.updateList(filteredList)
        } else {
            // Hiển thị toàn bộ danh sách nếu từ khóa nhỏ hơn 2 ký tự
            studentAdapter.updateList(studentList)
        }
    }
}
