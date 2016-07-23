package com.zhy.poker;

/**
 * 一张扑克牌、初始时设置好点数和花色后不允许再修改
 * @author zhy
 *
 */
public class PokerCard {
	private String _strNumber;// 点数
	private String _strFlower;// 花色
	
	public PokerCard(String strNum, String strFlower) {
		_strNumber = strNum;
		_strFlower = strFlower;
	}
	
	public String get_strNumber() {
		return _strNumber;
	}

	public String get_strFlower() {
		return _strFlower;
	}
}
