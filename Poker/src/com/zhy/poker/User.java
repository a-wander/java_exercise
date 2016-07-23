package com.zhy.poker;

import java.util.ArrayList;

public class User {
	public String _strUserName;
	public int _nId;
	private ArrayList<PokerCard> _arrCard;
	
	public User(int nId, String strName){
		_strUserName = strName;
		_nId = nId;
		_arrCard = new ArrayList<PokerCard>();
	}
	public void addCard(PokerCard card) {
		_arrCard.add(card);
	}
	public void printCards() {
		System.out.println("Íæ¼Ò£º" + _nId + "³ÖÅÆ£º");
		for (PokerCard pokerCard : _arrCard) {
			System.out.println(pokerCard.get_strFlower() + "" + pokerCard.get_strNumber());
		}
	}
	public PokerCard getMax(){
		return _arrCard.get(0);
	}
	
	public void printCard() {
		String strTmp = new String();
		for (PokerCard pokerCard : _arrCard) {
			strTmp += pokerCard.get_strFlower();
			strTmp += " ";
			strTmp += pokerCard.get_strNumber();
			strTmp += "  ";
		}
		System.out.println(strTmp);
	}
}
