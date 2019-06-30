package com.donald.listener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.donald.controller.GameController;
import com.donald.utils.SnackUtils;

public class SnackKeyListener extends KeyAdapter {
	
	private GameController controller;

	public SnackKeyListener(GameController controller) {
		this.controller = controller;
	}
	
	@Override
	public synchronized void keyPressed(KeyEvent e) {
		//过滤出上下左右按键
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			if(controller.getSnack().getNew_direction() != SnackUtils.right_direction) {
				controller.getSnack().setOld_direction(controller.getSnack().getNew_direction());
				controller.getSnack().setNew_direction(SnackUtils.left_direction);
			}
			/*
			if(controller.getSnack().getOld_direction() == 0) {  //第一次
				if(controller.getSnack().getNew_direction() != SnackUtils.right_direction) {
					controller.getSnack().setOld_direction(controller.getSnack().getNew_direction());
					controller.getSnack().setNew_direction(SnackUtils.left_direction);
				}
			}else {
				if(controller.getSnack().getOld_direction() != SnackUtils.right_direction) {
					controller.getSnack().setOld_direction(controller.getSnack().getNew_direction());
					controller.getSnack().setNew_direction(SnackUtils.left_direction);
				}
			}
			*/
			System.out.println("old:"+controller.getSnack().getOld_direction());
			System.out.println("new:"+controller.getSnack().getNew_direction());
			break;
		case KeyEvent.VK_RIGHT:
			if(controller.getSnack().getNew_direction() != SnackUtils.left_direction) {
				controller.getSnack().setOld_direction(controller.getSnack().getNew_direction());
				controller.getSnack().setNew_direction(SnackUtils.right_direction);
			}
			/*
			if(controller.getSnack().getOld_direction() == 0) {  //第一次
				if(controller.getSnack().getNew_direction() != SnackUtils.left_direction) {
					controller.getSnack().setOld_direction(controller.getSnack().getNew_direction());
					controller.getSnack().setNew_direction(SnackUtils.right_direction);
				}
			}else {
				if(controller.getSnack().getOld_direction() != SnackUtils.left_direction) {
					controller.getSnack().setOld_direction(controller.getSnack().getNew_direction());
					controller.getSnack().setNew_direction(SnackUtils.right_direction);
				}
			}
			*/
			System.out.println("old:"+controller.getSnack().getOld_direction());
			System.out.println("new:"+controller.getSnack().getNew_direction());
			break;
		case KeyEvent.VK_UP:
			if(controller.getSnack().getNew_direction() != SnackUtils.down_direction) {
				controller.getSnack().setOld_direction(controller.getSnack().getNew_direction());
				controller.getSnack().setNew_direction(SnackUtils.up_direction);
			}
			/*
			if(controller.getSnack().getOld_direction() == 0) {  //第一次
				if(controller.getSnack().getNew_direction() != SnackUtils.down_direction) {
					controller.getSnack().setOld_direction(controller.getSnack().getNew_direction());
					controller.getSnack().setNew_direction(SnackUtils.up_direction);
				}
			}else {
				if(controller.getSnack().getOld_direction() != SnackUtils.down_direction) {
					controller.getSnack().setOld_direction(controller.getSnack().getNew_direction());
					controller.getSnack().setNew_direction(SnackUtils.up_direction);
				}
			}
			*/
			System.out.println("old:"+controller.getSnack().getOld_direction());
			System.out.println("new:"+controller.getSnack().getNew_direction());
			break;
		case KeyEvent.VK_DOWN:
			if(controller.getSnack().getNew_direction() != SnackUtils.up_direction) {
				controller.getSnack().setOld_direction(controller.getSnack().getNew_direction());
				controller.getSnack().setNew_direction(SnackUtils.down_direction);
			}
			/*
			if(controller.getSnack().getOld_direction() == 0) {  //第一次
				if(controller.getSnack().getNew_direction() != SnackUtils.up_direction) {
					controller.getSnack().setOld_direction(controller.getSnack().getNew_direction());
					controller.getSnack().setNew_direction(SnackUtils.down_direction);
				}
			}else {
				if(controller.getSnack().getOld_direction() != SnackUtils.up_direction) {
					controller.getSnack().setOld_direction(controller.getSnack().getNew_direction());
					controller.getSnack().setNew_direction(SnackUtils.down_direction);
				}
			}
			*/
			System.out.println("old:"+controller.getSnack().getOld_direction());
			System.out.println("new:"+controller.getSnack().getNew_direction());
			break;
		}
	}
	
}
