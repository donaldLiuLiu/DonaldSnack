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
		//驱动蛇不断向当前方向移动
		for(;;) {
			//蛇移动一步
			Thread.sleep(1000/SnackUtils.snack_speed);
			
			/*判断移动一步之后的情况
			 * 	1.遇到食物
			 *  2.撞墙
			 *  3.咬到自己的尾巴
			 */
			
			/*
			 * 1.处理蛇吃食物
			 *  	1.1如果没有遇到食物，什么事也不做
			 *  	1.2如果遇到食物，将食物作为蛇的头,在合适的地方生成新的食物
			 */
			food.snackEatFood(snack,gLabel);
			
			/*
			 * 2.处理蛇撞墙
			 * 		2.1如果蛇没有撞到墙，什么也不做
			 * 		2.2如果蛇撞到了墙，返回true，结束游戏
			 */
			if(snack.isMeetWall()) {
				//game over
				System.out.println("meet wall game over");
				return ;
			}
			
			/*
			 * 3.处理蛇吃自己的尾巴
			 * 		3.1如果蛇没有吃到自己的尾巴，什么也不做
			 * 		3.2如果蛇吃到自己的尾巴，game over
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
	* 驱动蛇向当前方向走一步
	*/
	private void drivenMove() {
		//根据当前方向获得蛇头的下一个位置
		Dimension next = snack.getNextHeadLocation();
		//将蛇身的最后一个位置删除，设置为next的坐标，添加到蛇首
		snack.move(next);
		gLabel.rePlay(snack, food);
	}
	
	
}
