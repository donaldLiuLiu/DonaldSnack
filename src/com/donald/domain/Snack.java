package com.donald.domain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.LinkedList;

import com.donald.game.GameFrame;
import com.donald.utils.SnackUtils;

public class Snack {
	private LinkedList<Cell> body = new LinkedList<Cell>();  //蛇身
	private int new_direction = SnackUtils.snack_default_direction;  //当前移动的方向
	private int old_direction;  //前一次的移动方向
	
	public Snack() {
		super();
	}


	public Snack(LinkedList<Cell> body) {
		super();
		this.body = body;
	}


	public LinkedList<Cell> getBody() {
		return body;
	}


	public void setBody(LinkedList<Cell> body) {
		this.body = body;
	}


	public int getNew_direction() {
		return new_direction;
	}


	public void setNew_direction(int new_direction) {
		this.new_direction = new_direction;
	}


	public int getOld_direction() {
		return old_direction;
	}


	public void setOld_direction(int old_direction) {
		this.old_direction = old_direction;
	}


	public void draw(Graphics g) {
		
		for(Cell cell : body) {
			g.setColor(cell.getColor());
			g.fillRect(cell.getX()*SnackUtils.cell_width, 
					cell.getY()*SnackUtils.cell_height, SnackUtils.cell_width, 
					SnackUtils.cell_height);
			g.setColor(new Color(0xff0000));
			g.drawRect(cell.getX()*SnackUtils.cell_width, 
					cell.getY()*SnackUtils.cell_height, SnackUtils.cell_width, 
					SnackUtils.cell_height);
		}
		
	}
	
	/*
	 * 获得下一个蛇头的位置
	 */
	public Dimension getNextHeadLocation() {
		int next_x = getHead().getX();  //获取蛇头的位置
		int next_y = getHead().getY();
		switch(new_direction) {
		case SnackUtils.up_direction:
			next_y = next_y-1;
			break;
		case SnackUtils.down_direction:
			next_y = next_y+1;
			break;
		case SnackUtils.left_direction:
			next_x -= 1;
			break;
		case SnackUtils.right_direction:
			next_x += 1;
			break;
		}
		return new Dimension(next_x, next_y);
		
	}
	
	public Cell getHead() {
		return body.getFirst();
	}

	/*
	 * 将蛇身的最后一个位置删除，设置为next的坐标，添加到蛇首
	 */
	public void move(Dimension next) {
		Cell last = body.removeLast();
		last.setX(next.getSize().width);
		last.setY(next.getSize().height);
		body.addFirst(last);
	}

	/*
	 * 添加蛇头
	 */
	public void setHeader(Cell food) {
		food.setColor(SnackUtils.snack_default_color);
		this.body.addFirst(food);
	}


	public boolean isMeetWall() {
		boolean flag = false;
		System.out.println("end x="+this.getHead().getX());
		System.out.println("end y="+this.getHead().getY());
		
		if(this.getHead().getX() < 1 || this.getHead().getX() > SnackUtils.cell_width_count-1 ||
				this.getHead().getY() <1 || this.getHead().getY() > SnackUtils.cell_height_count-1) {
			flag = true;
		}
		return flag;
	}


	public boolean isEatTail() {
		boolean flag = false;
		for(int i=1;i<body.size();i++) {
			if(getHead().equals(body.get(i))) {
				flag = true;
			}
		}
		return flag;
	}
	
	
}
