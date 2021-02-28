package com.tjoeun.android.studentlist_20210221.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.tjoeun.android.studentlist_20210221.R
import com.tjoeun.android.studentlist_20210221.datas.Student
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.student_list_item.view.*
import java.util.*
import kotlin.collections.ArrayList

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

        // 화면에 뿌려지는 row를 일부 수정하고 나서 => return되도록
        // 몇번 줄에 뿌릴 row인지 파악하고 상황에 맞게 가공
        // mList에서 위치에 맞는 학생을 먼저 추출

        val student = _mList[position]

        //row변수 에서 => 필요한 텍스트 뷰/이미지뷰 등등을 꺼내오자 ()수기작업)
        val nameTxt = row.findViewById<TextView>(R.id.nameTxt)
        val ageTxt = row.findViewById<TextView>(R.id.ageTxt)

        // student의 값을 => 텍스트뷰에 반영

        //JAVA의 캘린더 객체생성
        // cal에서 년도값을 추출
        val cal = Calendar.getInstance()
        nameTxt.text = student.name

        val age = cal.get(Calendar.YEAR) - student.birthYear + 1

        // 현재 나이를 구해서 반영 => 현재년도 - 출생년도 +1
        ageTxt.text = "(${age}세)"


        return row
    }
}