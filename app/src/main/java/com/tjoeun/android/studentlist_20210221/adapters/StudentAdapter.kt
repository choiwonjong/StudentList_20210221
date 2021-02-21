package com.tjoeun.android.studentlist_20210221.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.tjoeun.android.studentlist_20210221.datas.Student
import kotlinx.android.synthetic.main.activity_main.*

class StudentAdapter(
    val _mContext : Context,     // 어떤 화면?
    val _resId : Int,            // 어떤 셀?
    val _mList : ArrayList<Student>) : ArrayAdapter<Student>(_mContext, _resId, _mList) {

    // student_list_item xml을 가지고 -> 코틀린에서 다룰 수 있계 도와느는 변수 (inf) 클래스 (LayoutInflater)
    val inf = LayoutInflater.from(_mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return super.getView(position, convertView, parent)

        // 임시로 한칸을
        var tempRow = convertView

        if (tempRow == null) {
            //어떤xml을 줄까?              무엇을             부가정보는 없어
           tempRow = inf.inflate(R.layout.student_list_item, null)
        }

        val row = tempRow!!
        return row
    }
}