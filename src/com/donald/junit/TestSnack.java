package com.donald.junit;

import org.junit.Test;

import com.donald.view.GameLabel;

public class TestSnack {
	
	@Test
	public void test_replay() {
		System.out.println(new GameLabel().isDisplayable());
	}
}
