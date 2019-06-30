package com.donald.domain;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.donald.utils.SnackUtils;
import com.donald.view.GameLabel;

public class Food {
	private Cell food;

	public Food() {
		super();
	}

	public Food(Cell food) {
		super();
		this.food = food;
	}

	public Cell getFood() {
		return food;
	}

	public void setFood(Cell food) {
		this.food = food;
	}

	public void draw(Graphics g) {
		
		g.setColor(food.getColor());
		g.fillRect(food.getX()*SnackUtils.cell_width, 
				food.getY()*SnackUtils.cell_height, SnackUtils.cell_width, 
				SnackUtils.cell_height);
		g.setColor(new Color(0xff0000));
		g.drawRect(food.getX()*SnackUtils.cell_width, 
				food.getY()*SnackUtils.cell_height, SnackUtils.cell_width, 
				SnackUtils.cell_height);
	}

	/*
	 * 1.处理蛇吃食物
	 *  	1.1如果没有遇到食物，什么事也不做
	 *  	1.2如果遇到食物，将食物作为蛇的头,在合适的地方生成新的食物
	 */
	public void snackEatFood(Snack snack, GameLabel gLabel) {
		if(isEat(snack)) {
System.out.println("eat a food");
			snack.setHeader(this.food);
			this.food = generateFood(snack);
			gLabel.rePlay(snack, this);
		}
	}

	private boolean isEat(Snack snack) {
		boolean flag = false;
		
		switch(snack.getNew_direction()){
		case SnackUtils.up_direction:
		if(snack.getHead().getX() == this.getFood().getX() &&
				snack.getHead().getY() == this.getFood().getY()+1) {
				flag = true;
			}
			break;
		case SnackUtils.down_direction:
			if(snack.getHead().getX() == this.getFood().getX() &&
				snack.getHead().getY() == this.getFood().getY()-1) {
				flag = true;
			}
			break;
		case SnackUtils.left_direction:
			if(snack.getHead().getX() == this.getFood().getX()+1 &&
					snack.getHead().getY() == this.getFood().getY()) {
				flag = true;
			}
			break;
		case SnackUtils.right_direction:
			if(snack.getHead().getX() == this.getFood().getX()-1 &&
					snack.getHead().getY() == this.getFood().getY()) {
				flag = true;
			}
			break; 
		}
		return flag;
	}

	/*
	 * 在合适的地方生成食物
	 */
	private Cell generateFood(Snack snack) {
		boolean flag = true;
		boolean fl = false;
		Random rand = new Random();
		int x = 1;
		int y = 1;
		while(flag) {
			fl = false;
			x = rand.nextInt(SnackUtils.cell_width_count-2)+1;
			y = rand.nextInt(SnackUtils.cell_height_count-2)+1;
			for(Cell s : snack.getBody()) {
				if(s.getX() == x && s.getY() == y) {
					flag = true;
					fl = true;
					break;
				}
			}
			if(!fl) {
				flag = false;
			}
		}
		Cell f = new Cell();
		f.setX(x);
		f.setY(y);
		f.setColor(SnackUtils.food_default_color);
		return f;
	}
	
	
}
