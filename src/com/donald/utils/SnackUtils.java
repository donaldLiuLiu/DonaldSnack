package com.donald.utils;

import java.awt.Color;

public class SnackUtils {
	public static final int up_direction = 1;
	public static final int down_direction = -1;
	public static final int left_direction = 2;
	public static final int right_direction = -2;
	public static int snack_default_direction = left_direction;
	
	public static int cell_width = 20;     //���ӵĿ�(px)
	public static int cell_height = 20;    //���ӵĳ�(px)
	public static int cell_width_count = 20;   //������ӵ�����
	public static int cell_height_count = 20;  //������ӵ�����
	
	public static final int snack_count = 2;  //��ʼ�ߵ���������
	public static final int snack_x = cell_width/2;  //��ʼ�ߵ�xλ��
	public static final int snack_y = cell_height/2; //��ʼ�ߵ�yλ��
	public static final Color snack_default_color = new Color(0xaaaaaa); //�ߵ�Ĭ����ɫ
	public static int snack_speed = 3;   //ÿ��һ��
	
	public static final int food_x = cell_width/2-2;  //ʳ����ʼλ��
	public static final int food_y = cell_height/2;
	public static final Color food_default_color = new Color(0x00ff00);  //ʳ��Ĭ����ɫ
	
	
}
