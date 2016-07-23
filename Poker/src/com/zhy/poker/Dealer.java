package com.zhy.poker;

import java.util.ArrayList;
import java.util.Collections;

public class Dealer {
	
	private ArrayList<PokerCard> _poker;// 荷官当前使用的扑克牌
	/**
	 * 设置荷官当前使用的扑克牌
	 * @param poker
	 */
	public void setPoker(ArrayList<PokerCard> poker){
		this._poker = poker;
	}
	/**
	 * 洗牌
	 */
	public void shuffle(){
		Collections.shuffle(_poker);
	}
	/**
	 * 发牌
	 * @param user1 玩家1（ 先发牌）
	 * @param user2 玩家2
	 */
	public void deal(User user1, User user2){
		user1.addCard(_poker.get(0));
		user2.addCard(_poker.get(1));
		user1.addCard(_poker.get(2));
		user2.addCard(_poker.get(3));
	}
	/**
	 * 宣布结果
	 * @param user1 玩家1
	 * @param user2 玩家2
	 */
	public void printRes(User user1, User user2){
		System.out.print("玩家 " + user1._nId + "持牌:");
		user1.printCard();
		System.out.print("玩家 " + user2._nId + "持牌:");
		user2.printCard();
	}
}
