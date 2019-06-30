package com.donald.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import org.junit.Test;

import com.donald.domain.Food;
import com.donald.domain.Snack;
import com.donald.utils.SnackUtils;

public class GameLabel extends JPanel {

	private Image image = null;
	private Graphics ig;
	public GameLabel() {
		
		int w_width = SnackUtils.cell_width*SnackUtils.cell_width_count;
		int w_height = SnackUtils.cell_height*SnackUtils.cell_height_count;
		this.setSize(w_width, w_height);
		//this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		this.setFocusable(true);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(this.getWidth(),this.getHeight());
	}



	public synchronized void rePlay(Snack snack,Food food) {
		if(ig == null) {
			image = createImage(this.getSize().width,this.getSize().height);
			if(image != null) {
				ig = image.getGraphics();
			}else {
				System.out.println(3);
			}
		}
		if(ig != null) {
			ig.clearRect(0, 0, image.getWidth(this), image.getHeight(this));
			snack.draw(ig);
			food.draw(ig);
			repaint();
			//paint(this.getGraphics());
		}else {
			System.out.println("12");
		}
	}
	
	
	@Override
	public void paint(Graphics g) {
		//»­³öimage
		g.drawImage(image, 0, 0, this);
	}
	
	
}
