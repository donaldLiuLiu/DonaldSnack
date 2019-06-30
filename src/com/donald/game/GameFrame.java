package com.donald.game;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.LinkedList;

import javax.swing.JFrame;

import com.donald.controller.GameController;
import com.donald.domain.Cell;
import com.donald.domain.Food;
import com.donald.domain.Snack;
import com.donald.listener.SnackKeyListener;
import com.donald.utils.SnackUtils;
import com.donald.view.GameLabel;

public class GameFrame extends JFrame {
	public static int FRAME_WIDTH;
	public static int FRAME_HEIGHT;
	
	public GameFrame() {
		this.setVisible(true);
		//������
		LinkedList<Cell> body = new LinkedList<Cell>();
		for(int i=0;i<SnackUtils.snack_count;i++) {
			Cell e = new Cell();
			/*
			 * bug:
			 * 		����Ĵ����Ǵ�����ʽ������ߵ����壬��ˣ�ͷ��������ߣ������Ĭ�ϵ�
			 * 		ǰ���ķ��������ҵĻ����ͻ����
			 */
			e.setX(SnackUtils.snack_x+i);
			e.setY(SnackUtils.snack_y);
			e.setColor(SnackUtils.snack_default_color);
			body.add(e);
		}		Snack snack = new Snack();
		snack.setBody(body);
		//����ʳ��
		Food food = new Food();
		Cell f = new Cell();
		f.setX(SnackUtils.food_x);
		f.setY(SnackUtils.food_y);
		f.setColor(SnackUtils.food_default_color);
		food.setFood(f);
		//������ʾ��ͼ
		GameLabel gLabel = new GameLabel();
		add(gLabel);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int w_width = SnackUtils.cell_width*SnackUtils.cell_width_count;
		int w_height = SnackUtils.cell_height*SnackUtils.cell_height_count;
		
		this.setLocation(screenSize.width/2-w_width/2, screenSize.height/2-w_height/2);
		pack();
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FRAME_WIDTH = this.getWidth();
		FRAME_HEIGHT = this.getHeight();
	System.out.println(FRAME_WIDTH);
	System.out.println(FRAME_HEIGHT);
		//���߶���ʳ�������ʾ��ͼ���󣬽������������󣬿������������start��������ʼ
		try {
			GameController controller = new GameController(snack,food,gLabel,this);
			/*
			 * ���̼����¼�
			 */
			this.addKeyListener(new SnackKeyListener(controller));
			controller.start();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}
	
	public static void main(String[] args) {
		new GameFrame();
	}
	
}
