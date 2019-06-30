package com.donald.controller;

import java.awt.Dimension;

import com.donald.domain.Food;
import com.donald.domain.Snack;
import com.donald.game.GameFrame;
import com.donald.utils.SnackUtils;
import com.donald.view.GameLabel;

public class GameController {
	private Snack snack;
	private Food food;
	private GameLabel gLabel;
	private GameFrame frame;
	public GameController(Snack snack, Food food, GameLabel gLabel,GameFrame frame) {
		super();
		this.snack = snack;
		this.food = food;
		this.gLabel = gLabel;
		this.frame = frame;
	}
	
	public Snack getSnack() {
		return snack;
	}

	public void setSnack(Snack snack) {
		this.snack = snack;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public GameLabel getgLabel() {
		return gLabel;
	}

	public void setgLabel(GameLabel gLabel) {
		this.gLabel = gLabel;
	}

	public GameFrame getFrame() {
		return frame;
	}

	public void setFrame(GameFrame frame) {
		this.frame = frame;
	}

	public void start() throws Exception{
		gLabel.rePlay(snack, food);
		//�����߲�����ǰ�����ƶ�
		for(;;) {
			//���ƶ�һ��
			Thread.sleep(1000/SnackUtils.snack_speed);
			
			/*�ж��ƶ�һ��֮������
			 * 	1.����ʳ��
			 *  2.ײǽ
			 *  3.ҧ���Լ���β��
			 */
			
			/*
			 * 1.�����߳�ʳ��
			 *  	1.1���û������ʳ�ʲô��Ҳ����
			 *  	1.2�������ʳ���ʳ����Ϊ�ߵ�ͷ,�ں��ʵĵط������µ�ʳ��
			 */
			food.snackEatFood(snack,gLabel);
			
			/*
			 * 2.������ײǽ
			 * 		2.1�����û��ײ��ǽ��ʲôҲ����
			 * 		2.2�����ײ����ǽ������true��������Ϸ
			 */
			if(snack.isMeetWall()) {
				//game over
				System.out.println("meet wall game over");
				return ;
			}
			
			/*
			 * 3.�����߳��Լ���β��
			 * 		3.1�����û�гԵ��Լ���β�ͣ�ʲôҲ����
			 * 		3.2����߳Ե��Լ���β�ͣ�game over
			 */
			if(snack.isEatTail()) {
				//game over
				System.out.println("eat self game over");
				return ;
			}
			
			drivenMove();
		}
	}

	/*
	* ��������ǰ������һ��
	*/
	private void drivenMove() {
		//���ݵ�ǰ��������ͷ����һ��λ��
		Dimension next = snack.getNextHeadLocation();
		//����������һ��λ��ɾ��������Ϊnext�����꣬��ӵ�����
		snack.move(next);
		gLabel.rePlay(snack, food);
	}
	
	
}
