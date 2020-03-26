package g_access;

import g_access.sub.Access;//Access클래스 다른 패키지에있어서 인식하기위해서 import로 끌어옴

// 2. 다른 패키지에서 확인
class Main
{
	public static void main(String[] args) 
	{
		Access me = new Access();
//		me.a="프라잆 변경";
		me.b="퍼블릭 변경";
//		me.c="프로텍티드 변경";
//		me.d="디폴트 변경";
		
		
		me.output();
	}
}

