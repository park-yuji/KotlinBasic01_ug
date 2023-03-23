package com.reno.kotlinbasic01_ug

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.reno.kotlinbasic01_ug.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // 변수
    private var mBinding: ActivityMainBinding? = null
    // 상수
    private val binding get() = mBinding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         // setContentView(R.layout.activity_main)

        // 자동 생성된 뷰 바인딩 클래스에서의 inflate라는 메서드를 활용해서
        // 액티비티에서 사용할 바인딩 클래스의 인스턴스 생성
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        // getRoot 메서드로 레이아웃 내부의 최상위 위치 뷰의
        // 인스턴스를 활용하여 생성된 뷰를 액티비티에 표시 합니다.
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener {
            // 조회
            val inputId = binding.emailTxt.text.toString()
            val inputPw = binding.pwdTxt.text.toString()

            if("admin@test.com".equals(inputId) && "qwer".equals(inputPw)){
                Toast.makeText(this, "관리자 입니다.", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "로그인 실패!!", Toast.LENGTH_SHORT).show()
            }


        }

       /* binding.clickBtn.setOnClickListener{
            // 코드에 메모 남기기 (Ctrl+/)
//            이 {} 안에 있는 코드만 버튼이 눌렸을때 실행
            Log.d("메인 화면 로그","클릭용 버튼 눌림")
            Log.e("메인화면로그","에러관련로그")
        }

        */
    }
    override fun onDestroy() {
        // onDestroy 에서 binding class 인스턴스 참조를 정리해주어야 한다.
        mBinding = null
        super.onDestroy()
    }


}