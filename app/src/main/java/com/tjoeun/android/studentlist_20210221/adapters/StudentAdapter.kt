package com.tjoeun.android.studentlist_20210221.adapters

import android.content.Context
import android.widget.ArrayAdapter
import com.tjoeun.android.studentlist_20210221.datas.Student

class StudentAdapter(
    val mContext : Context,     // 어떤 화면?
    val resId : Int,            //
    val mList : ArrayList<Student>) : ArrayAdapter<Student>(mContext,resId,mList) {

}