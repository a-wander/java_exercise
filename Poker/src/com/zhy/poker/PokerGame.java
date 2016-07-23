package com.zhy.poker;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PokerGame {

	final String[] arrNum = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	final String[] arrFlower = new String[]{"��Ƭ", "����", "�ݻ�", "����"};
	public Dealer _dealer;// �ɹ�
	User _user1;
	User _user2;
	public ArrayList<PokerCard> _poker;//�˿���
	public PokerGame() {
		// �����ɹ�
		_dealer = new Dealer();
		// ��ʼ���˿���
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
		// �������봴�����
		System.out.println("��ӭ�����˿��Ʊȴ�С��Ϸ��");
		System.out.println("�������һλ��ҵ�id��");
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
				System.out.println("�����������������֣�");
				bContinue = true;
			} catch (Exception e) {
				//input.close();
				System.out.println("�������");
				return;
			}
		}while(bContinue);
		System.out.println("������ڶ�λ��ҵ�id��");
		int nId2 = 0;
		do{
			try {
				bContinue = false;
				Scanner input = new Scanner(System.in);
				nId2 = input.nextInt();
			} catch (InputMismatchException e) {
				//input.close();
				System.out.println("�����������������֣�");
				bContinue = true;
			} catch (Exception e) {
				//input.close();
				System.out.println("�������");
				return;
			}
		}while(bContinue);
		//input.close();
		// ��ʼ��Ϸ
		for (int i=0; i<3; ++i){
			System.out.println("��" + (i+1)+ "��:");
			PokerGame game = new PokerGame();
			game._user1 = new User(nId1,"Tommy");
			game._user2 = new User(nId2,"Alex");
			game._dealer.shuffle();
			game._dealer.deal(game._user1, game._user2);
			game._dealer.printRes(game._user1, game._user2);
		}
	}
}
