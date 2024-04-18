package game;

import java.util.Random;
import java.util.Scanner;

public class Survivor {
	Scanner sc = new Scanner(System.in);
	
	String name;
	String gender;
	String item;
	int inventory;
	int tired;
	int hunger;
	int thrist;
	int health;
	int botle;
	int hay;
	int twigs;
	int tree_fruit;
	int stone;
	int bandage;
	int water;
	int choicebotle = 0;
	
	Survivor(String name) {
		this.name = name;
		health = 70;
		tired = 50;
		thrist = 50;
		hunger = 50;
		inventory = 0;
	}

	void printInfo() {
		System.out.println("이름" + name);
		System.out.println("성별" + gender);
		System.out.println("체력" + health);		
		System.out.println("피로도" + tired);
		System.out.println("갈증" + thrist);
		System.out.println("허기" + hunger);
		System.out.println("가방" + inventory);
	}
	
	void item() {
		System.out.println("물병" + botle);
		System.out.println("건초" + hay);
		System.out.println("잔가지" + twigs);
		System.out.println("나무열매" + tree_fruit);
		System.out.println("돌멩이" + stone);
		System.out.println("붕대" + bandage);
		System.out.println("물" + water);
	}
	
	void botle(String item) {
		while(botle == 0) {
			System.out.println("물병이 비었습니다.");
			System.out.println("물병에 물을 담으시겠습니까?\n1. 네\n2. 아니오");
			System.out.println("선택지 입력 >> ");
			choicebotle = sc.nextInt();
			
			if(choicebotle == 1) {
				System.out.println("물병에 물을 담는 중입니다.");
				for (int i = 0; i < 3; i++) {
					try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();} // 1초의 텀을주는 코드
					System.out.println("....");				
				}
				
				System.out.println("물을 담았습니다.");
				botle += 50;							
			}
			if(choicebotle == 2) {
				System.out.println("자리를 떠납니다...");
			}
			
			
			
			
			
			
			
			
		}
	}
	
	// 탐색하는 코드
	void Scan() {
		if(tired <=10) {
			System.out.println("피곤하여 움직이지 못합니다. 휴식이나 잠자기를 통해 피로도를 회복하세요.");
		}
		else {
			Random r = new Random();
			int[] percent = new int[100];
			int rating = 40;
			
			for (int i = 0; i < rating; i++) {
				percent[i] = 1;
			}
			
			System.out.println("주변을 탐색합니다...");
			for (int i = 0; i < 3; i++) {
				try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();} // 1초의 텀을주는 코드
				System.out.println("....");
				
			}
			
			// 40%의 확률로 아무것도 못찾음.
			if(percent[r.nextInt(percent.length)] == 1) {
				System.out.println("아무것도 찾지 못했습니다...");
				tired -= 10;
				thrist -= 10;
				hunger -= 10;
			}
			
			else {
				System.out.println("탐색품을 찾았습니다.");
				tired -= 5;
				thrist -= 5;
				hunger -= 5;
			}
		}

	}	
	
	// 휴식으로 회복하는 코드
	void Refresh() {
		if(tired >= 10) {
			System.out.println(this.name + "이(가) 휴식 중입니다.");
			for (int i = 0; i < 3; i++) {
				try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();} // 1초의 텀을주는 코드
				System.out.println("....");				
			}
			
			System.out.println(this.name + "이(가) 휴식을 끝냈습니다");
			tired += 30;
			health += 30;
			thrist -= 10;
			hunger -= 10;
		}
	}
	
	// 잠자기로 회복하는 코드
	void sleep() {
		if(tired >= 10) {
			System.out.println(this.name + "이(가) 휴식 중입니다.");
			for (int i = 0; i < 3; i++) {
				try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();} // 1초의 텀을주는 코드
				System.out.println("....");				
			}
			
			System.out.println(this.name + "이(가) 휴식을 끝냈습니다");
			tired += 50;
			health += 50;
			thrist -= 20;
			hunger -= 20;
		}
		
		else {
			System.out.println("tip : 휴식이나 잠자기로 피로도와 체력을 회복할 수 있습니다...");
		}
	}
	
	// 허기를 채우는 코드
	void eat() {
		if(inventory <= 0) {
			System.out.println("음식이 없습니다. 탐색을 통해 음식을 얻으세요");
			return;
		}
		System.out.println("나무열매를 먹어 허기를 달랩니다.");
		inventory --;
		thrist +=5;
		hunger +=5;
	}
	
	// 갈증을 해결하는 코드 (시냇물을 마심)
	void drink() {
		if(thrist <= 0) {
			System.out.println("심한 갈증을 느낌니다. 마실것이 필요합니다.");
			return;
		}
		System.out.println("물을 마셔 갈증을 해결합니다.");
		thrist += 30;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}



