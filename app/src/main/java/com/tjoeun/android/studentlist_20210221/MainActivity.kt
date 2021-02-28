package com.tjoeun.android.studentlist_20210221

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.tjoeun.android.studentlist_20210221.adapters.StudentAdapter
import com.tjoeun.android.studentlist_20210221.datas.Student
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // 실제 학생들 목록을 담아줄 목록변수
    val mStudentList = ArrayList<Student>()

    //리스트뷰의 각각의 줄을 실제로 뿌려줄 어댑터변수.
    lateinit var mAdapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mStudentList.add(Student("조경진", 1988))
        mStudentList.add(Student("강서영", 1990))
        mStudentList.add(Student("김윤경", 1981))
        mStudentList.add(Student("박은희", 1970))
        mStudentList.add(Student("신정범", 1989))
        mStudentList.add(Student("오이슬", 1994))
        mStudentList.add(Student("이예슬", 1990))
        mStudentList.add(Student("이지인", 1996))
        mStudentList.add(Student("채명호", 1973))
        mStudentList.add(Student("최원종", 1967))
        mStudentList.add(Student("최윤정", 1987))
        mStudentList.add(Student("조경진", 1988))
        mStudentList.add(Student("강서영", 1990))
        mStudentList.add(Student("김윤경", 1981))
        mStudentList.add(Student("박은희", 1970))
        mStudentList.add(Student("신정범", 1989))
        mStudentList.add(Student("오이슬", 1994))
        mStudentList.add(Student("이예슬", 1990))
        mStudentList.add(Student("이지인", 1996))
        mStudentList.add(Student("채명호", 1973))
        mStudentList.add(Student("최원종", 1967))
        mStudentList.add(Student("최윤정", 1987))
        mStudentList.add(Student("조경진", 1988))
        mStudentList.add(Student("강서영", 1990))
        mStudentList.add(Student("김윤경", 1981))
        mStudentList.add(Student("박은희", 1970))
        mStudentList.add(Student("신정범", 1989))
        mStudentList.add(Student("오이슬", 1994))
        mStudentList.add(Student("이예슬", 1990))
        mStudentList.add(Student("이지인", 1996))
        mStudentList.add(Student("채명호", 1973))
        mStudentList.add(Student("최원종", 1967))
        mStudentList.add(Student("최윤정", 1987))


        // 나중에 담아준다던 mAdapter 에 실제 어댑터 대입
        mAdapter = StudentAdapter(this, R.layout.student_list_item, mStudentList)

        // 리스트뷰의 어댑터로써 => mAdapter를 지정.
        studentListView.adapter = mAdapter

        // 리스트뷰의 각 줄이 눌린경우
        studentListView.setOnItemClickListener { parent, view, position, id ->
            // posion : 눌린줄 위치

            // 클릭된 학생의 이름을 토스트로
            val clickStudent = mStudentList[position]
            Toast.makeText(this, clickStudent.name, Toast.LENGTH_SHORT).show()

        }

        studentListView.setOnItemLongClickListener { parent, view, position, id ->

        //    val std = mStudentList[position]
        //    Toast.makeText(this, "${std.name} 길게눌림", Toast.LENGTH_SHORT).show()

            // 진짜 삭제를 진행하기 전에 최종확인
            val alert = AlertDialog.Builder(this)
            alert.setTitle("삭제확인")
            alert.setMessage("정말 해당 학생을 삭제하시겠습니까?")
            alert.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->
                //확인 버튼이 눌리면 할 일 -> 진짜 삭제 진행

                // 목록에서 해당위치의 학생 제거
                mStudentList.removeAt(position)

                //리스트뷰의 어뎁터에게 알림전달 => 새로고침 요청
                mAdapter.notifyDataSetChanged()
            })

            alert.setNegativeButton("취소", null)
            alert.show()


            // true - 롱클릭 전용  false - 손 뗄때 일반클릭도 처리  -> 일반적으로 true
            // return@setOnItemLongClickListener false
            return@setOnItemLongClickListener true
        }

    }
}