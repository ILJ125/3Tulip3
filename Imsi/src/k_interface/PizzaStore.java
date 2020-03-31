package k_interface;

public class PizzaStore  implements DeliveryStore{

	private String [] orderList;
	private Food [] menuList=new Food[5];

	public void menuList() {
		menuList[0]=new Food("Cheese",16600);
		menuList[1]=new Food("Pineapple",18000);
		menuList[2]=new Food("Meatball",17000);
		menuList[3]=new Food("Bulgogi",20000);
		menuList[4]=new Food("Potato",16000);
	}

	public void setOrderList(String []orderList)
	{
		//메인에서 주문을 입력 받아 private로 설정한 orderList에 대입 
		this.orderList=orderList;
	}
	public int getTotalPrice() {
		//메뉴 리스트를 실행 해줘야지 메뉴리스트에서 값을 가져와서 쓸 수있다.
		menuList();
		int total=0;
		//내가 가진 메뉴와 주문 목록 비교해서 이름이 같은게 있으면 메뉴에서 가격 추가
		for(int i=0; i<menuList.length;i++) {
			for(int j=0;j<orderList.length;j++) {
				if((menuList[i].name).equals(orderList[j])) //????????equals 대신 ==은 쓸 수 없다.정확한 이유 묻기
				{
					total+=menuList[i].price;
				}
			}
		}
		return total;

	}



}
