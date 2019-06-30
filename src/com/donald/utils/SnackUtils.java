package com.donald.utils;

import java.awt.Color;

public class SnackUtils {
	public static final int up_direction = 1;
	public static final int down_direction = -1;
	public static final int left_direction = 2;
	public static final int right_direction = -2;
	public static int snack_default_direction = left_direction;
	
	public static int cell_width = 20;     //格子的宽(px)
	public static int cell_height = 20;    //格子的长(px)
	public static int cell_width_count = 20;   //横向格子的数量
	public static int cell_height_count = 20;  //纵向格子的数量
	
	public static final int snack_count = 2;  //开始蛇的蛇身数量
	public static final int snack_x = cell_width/2;  //开始蛇的x位置
	public static final int snack_y = cell_height/2; //开始蛇的y位置
	public static final Color snack_default_color = new Color(0xaaaaaa); //蛇的默认颜色
	public static int snack_speed = 3;   //每秒一格
	
	public static final int food_x = cell_width/2-2;  //食物起始位置
	public static final int food_y = cell_height/2;
	public static final Color food_default_color = new Color(0x00ff00);  //食物默认颜色
	
	
}
