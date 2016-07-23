package com.zhy.poker;

import java.util.ArrayList;
import java.util.Collections;

public class Dealer {
	
	private ArrayList<PokerCard> _poker;// �ɹٵ�ǰʹ�õ��˿���
	/**
	 * ���úɹٵ�ǰʹ�õ��˿���
	 * @param poker
	 */
	public void setPoker(ArrayList<PokerCard> poker){
		this._poker = poker;
	}
	/**
	 * ϴ��
	 */
	public void shuffle(){
		Collections.shuffle(_poker);
	}
	/**
	 * ����
	 * @param user1 ���1�� �ȷ��ƣ�
	 * @param user2 ���2
	 */
	public void deal(User user1, User user2){
		user1.addCard(_poker.get(0));
		user2.addCard(_poker.get(1));
		user1.addCard(_poker.get(2));
		user2.addCard(_poker.get(3));
	}
	/**
	 * �������
	 * @param user1 ���1
	 * @param user2 ���2
	 */
	public void printRes(User user1, User user2){
		System.out.print("��� " + user1._nId + "����:");
		user1.printCard();
		System.out.print("��� " + user2._nId + "����:");
		user2.printCard();
	}
}
