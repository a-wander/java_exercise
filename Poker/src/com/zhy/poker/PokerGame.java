package com.zhy.poker;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PokerGame {

	final String[] arrNum = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	final String[] arrFlower = new String[]{"方片", "红桃", "草花", "黑桃"};
	public Dealer _dealer;// 荷官
	User _user1;
	User _user2;
	public ArrayList<PokerCard> _poker;//扑克牌
	public PokerGame() {
		// 创建荷官
		_dealer = new Dealer();
		// 初始化扑克牌
		_poker = new ArrayList<PokerCard>();
		for (String strnum : arrNum) {
			for (String strFlower : arrFlower) {
				PokerCard card = new PokerCard(strnum, strFlower);
				_poker.add(card);
			}
		}
		_dealer.setPoker(_poker);
	}
	
	public static void main(String[] args) {
		// 根据输入创建玩家
		System.out.println("欢迎来到扑克牌比大小游戏！");
		System.out.println("请输入第一位玩家的id：");
		int nId1 = 0;
		boolean bContinue = false;
		//Scanner input = null;
		do{
			try {
				bContinue = false;
				Scanner input = new Scanner(System.in);
				nId1 = input.nextInt();
			} catch (InputMismatchException e) {
				//input.close();
				System.out.println("输入有误，请输入数字！");
				bContinue = true;
			} catch (Exception e) {
				//input.close();
				System.out.println("程序出错！");
				return;
			}
		}while(bContinue);
		System.out.println("请输入第二位玩家的id：");
		int nId2 = 0;
		do{
			try {
				bContinue = false;
				Scanner input = new Scanner(System.in);
				nId2 = input.nextInt();
			} catch (InputMismatchException e) {
				//input.close();
				System.out.println("输入有误，请输入数字！");
				bContinue = true;
			} catch (Exception e) {
				//input.close();
				System.out.println("程序出错！");
				return;
			}
		}while(bContinue);
		//input.close();
		// 开始游戏
		for (int i=0; i<3; ++i){
			System.out.println("第" + (i+1)+ "局:");
			PokerGame game = new PokerGame();
			game._user1 = new User(nId1,"Tommy");
			game._user2 = new User(nId2,"Alex");
			game._dealer.shuffle();
			game._dealer.deal(game._user1, game._user2);
			game._dealer.printRes(game._user1, game._user2);
		}
	}
}
