package portfolio;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class ATM {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random(); //ランダム
		
		String myAccount = ""; // save the account
		String pw = "";
		int wallet = 0;
		
		
		System.out.println("☆★☆★ATMを起動します☆★☆★");
		
		while(true) {
			System.out.println();
			System.out.println("--main menu--");
			System.out.println("1. 口座開設");
			System.out.println("2. 入金");
			System.out.println("3. 出金");
			System.out.println("4. 終了");
			System.out.print("入力 >> ");
			int choice = Integer.parseInt(sc.nextLine());
			
			
			if(choice == 1) {
				// 口座開設
//				System.out.println( r.nextInt(100) + "-" + r.nextInt(10000) + "-" + r.nextInt(10000));
//				System.out.printf("%02d-%04d-%04d\n", r.nextInt(100), r.nextInt(10000), r.nextInt(10000));
				
				for(int i = 0; i < 3; i++) {
					System.out.print("設定するパスワードを入力してください。 >> ");
					pw = sc.nextLine();
					System.out.print("パスワードを再入力してください。 >>");
					String ch_pw =sc.nextLine();
					if(pw.equals(ch_pw)) {// パスワードが一致すればストップ
						myAccount = String.format("%02d-%04d-%04d", r.nextInt(100), r.nextInt(10000), r.nextInt(10000));
						System.out.println();
						System.out.println("口座番号発行ありがとうございます。");
						System.out.println("口座番号 : " + myAccount);
						System.out.println("パスワードの設定が完了できました!");
						break;
					}else {
						if (i == 2) {
							System.out.println("パスワードの設定に失敗しました、 メインメニューに戻ります。");
							break;
						}
						System.out.println("パスワードが一致してません。  残り: " + (2-i) + "回");
					}
				}
				
				
				
			}else if(choice == 2) {
				//入金
				// 口座が存在すれば進む
				if(myAccount.equals("")) {
					System.out.println("口座を先に発行してください。");
					continue;
				}
				System.out.print("入金する口座の口座番号を入力してください。 >> ");
				String inputAccount = sc.nextLine();
				
				// 保存された口座番号と入力が同じなら
				// 口座の入力が間違えた時は該当する口座が存在しておりませんを出力後、メインメニューに戻る
				if(myAccount.equals(inputAccount)) {
					
					for(int i = 0; i < 3; i++) {
						// パスワード入力
						System.out.println("パスワードを入力してください。 >> ");
						String inputPw = sc.nextLine();
						if(pw.equals(inputPw)) {// 設定したパスワードと入力されたパスワードが一致したら
							System.out.print("入金する金額を入力してください。 >>");
							int money = Integer.parseInt(sc.nextLine());
							wallet += money;  //wallet = wallet + money;
							
							System.out.println(money + "円が入金されました。");
							System.out.println("現在口座の残高は : " + wallet + "円です");
							break;
						
						}else {
							if(i == 2) {
								System.out.println("パスワードが一致してないので、 メインメニューに戻ります。");
								break;
							}
							System.out.println("パスワードが正しくありません、 残り :" + (2-i) + "回");
						}
						
					}
				}else {
					System.out.println("該当する口座が存在しておりません。");
				}
				
			}else if(choice == 3) {
				//出金
				// 口座が存在すれば進む
				if(myAccount.equals("")) {
					System.out.println("口座を先に発行してください。");
					continue;
				}
				
				System.out.println("出金する口座の口座番号を入力してください。 >>  ");
				String inputAccount = sc.nextLine();
				
				if(myAccount.equals(inputAccount)) {
					for (int i = 0; i < 3; i++) {
						System.out.println("パスワードを入力してください。 >> ");
						String inputPw = sc.nextLine();
						if(pw.equals(inputPw)) {
							System.out.println("出金する金額を入力してください。 >>");
							int money = Integer.parseInt(sc.nextLine());
							if(money <= wallet) {
								wallet -= money; //wallet = wallet - money;
								System.out.println(money + "円出金成功、 現在口座の残高は :" +wallet + "円です");
								break;
							}
								// 口座の残高が足りなかったら失敗
								System.out.println("口座の残高が足りないんです。 現在残高は : " + wallet + "円です");
								break;
							
							
						}else {
							// パスワードの入力が間違えたら失敗
							if(i == 2) {
								System.out.println("パスワードが一致してないので、 メインメニューに戻ります。");
								break;
							}
							System.out.println("パスワードが正しくありません、 残り :" + (2-i) + "回");
						}
					}
					
				}else {
					// 口座番号が存在しなかったら失敗
					System.out.println("該当する口座が存在しておりません。");
				}
				
				
				
			}else if(choice == 4) {
				//終了
				System.out.println("ATMを終了します");
				break;
			}else {
				// 入力間違い
				System.out.println("入力に間違いがあります。");
				System.out.println();
			}
			
			
		}//main menuを閉じる
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
