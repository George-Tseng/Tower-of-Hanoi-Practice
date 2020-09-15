import java.util.Scanner;

public class Hanoi_Tower {
	public static void main(String[] args) {	
		//plateNum->盤子數
		int plateNum;
		//tmpText->暫存輸入值
		String tmpText;
		//boolKeep->是否要持續回到輸入盤子數目的狀態
		//boolKeep2->是否要再次執行河內塔
		//boolKeep3->是否要持續回到輸入是否繼續的狀態
		boolean boolKeep = true, boolKeep2 = false, boolKeep3;
		
		//使用Scanner讀取使用者輸入的資訊
        Scanner inputScanner = new Scanner(System.in);
		
		//無窮迴圈，直到符合條件才會繼續
		do {
			do {
				System.out.print("請輸入河內塔(Tower of Hanoi)的盤子數目(非零的正整數)：");
		        tmpText = inputScanner.nextLine();
		        //完全無輸入時
		        if(tmpText.equals("") == true) {
		        	System.out.println("沒有輸入任何值，請重新輸入一次");
		        }
		        //需檢查輸入值是否為數字以及輸入值是否為正數
		        else {
		        	//輸入為正整數時
		        	if(numCheck(tmpText) > 0) {
		        		boolKeep = false;
		        	}
		        	//不合條件時
		        	if(numCheck(tmpText) <= 0) {
		        		System.out.println("輸入的內容不符合條件(非零的正整數)");
		        	}
		        }
			}while(boolKeep);
			
			plateNum = numCheck(tmpText);
			
			System.out.println("\n開始顯示操作流程...");
			//顯示操作順序
			
			//使用自定義的類別生成物件
			Hanoi_Tower ht = new Hanoi_Tower();
			//使用物件中的方法
			ht.ptMove(plateNum, '1', '2', '3');
			
			do {
				System.out.print("\n展示完畢，請選擇是否繼續(『y』為『是』，『n』為『否』，預設為「否」)？");
				tmpText = inputScanner.nextLine();
		        //完全無輸入或輸入n/N時
		        if(tmpText.equals("") == true || tmpText.equals("n") == true || tmpText.equals("N") == true) {
		        	boolKeep3 = false;
		        	boolKeep2 = false;
		        }
		        else {
		        	//輸入y/Y時
			        if(tmpText.equals("y") == true || tmpText.equals("Y") == true) {
			        	boolKeep3 = false;
			        	boolKeep2 = true;
			        }
			        //其他輸入值
			        else {
			        	boolKeep3 = true;
			        	System.out.println("無效的輸入值，請重新輸入！");
			        }
		        }
			}while(boolKeep3);
		}while(boolKeep2);
        
		System.out.print("程式已終止");
        //關閉Scanner
        inputScanner.close(); 
	}
	
	//檢測字串是否為正整數
	private static int numCheck(String tmpText) {
    	int tmpNum;
        //用try...catch包起來以處理casting時可能發生的錯誤
    	try {
    		tmpNum = Integer.parseInt(tmpText);
    	}
    	catch(Exception NumberFormatException) {
    		//0代表錯誤
    		return 0;
    	}
    	//非0代表輸入值為整數
    	return tmpNum;
    }
	
	//使用遞迴移動盤子，參數有盤數plateNum、第一座塔towerNo1、第二座塔towerNo2、第三座塔towerNo3
	private void ptMove(int plateNum, char towerNo1, char towerNo2, char towerNo3) {
		if(plateNum == 1) {
			System.out.println("第 "+plateNum+" 個盤子由第 "+towerNo1+" 座塔移動到第 "+towerNo3+" 座塔");
		}
		else {
			ptMove(plateNum - 1, '1', '3', '2');
			System.out.println("第 "+plateNum+" 個盤子由第 "+towerNo1+" 座塔移動到第 "+towerNo3+" 座塔");
			ptMove(plateNum - 1, '2', '1', '3');
		}
	}
}
