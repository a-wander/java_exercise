package com.zhy.poker;

/**
 * һ���˿��ơ���ʼʱ���úõ����ͻ�ɫ���������޸�
 * @author zhy
 *
 */
public class PokerCard {
	private String _strNumber;// ����
	private String _strFlower;// ��ɫ
	
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
