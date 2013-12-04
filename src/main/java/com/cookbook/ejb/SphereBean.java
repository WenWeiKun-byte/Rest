package com.cookbook.ejb;

import javax.ejb.Stateless;

@Stateless
public class SphereBean {
	//bad practice for stateless ejb to have the Instance variables
	private String unit;

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double computeVolume(double radius) {
		return (4.0 / 3.0) * Math.PI * (radius * radius * radius);
	}
}
