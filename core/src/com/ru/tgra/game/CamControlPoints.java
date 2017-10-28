package com.ru.tgra.game;

import java.util.ArrayList;

import com.ru.tgra.graphics.Camera;
import com.ru.tgra.graphics.Point3D;

public class CamControlPoints {
	
	
	ArrayList<Point3D> controlPoints;
	
	public CamControlPoints() {
		// TODO Auto-generated constructor stub

	}

	
	public void initialCameraPoints()
	{
		controlPoints = new ArrayList<Point3D>();
		controlPoints.add(new Point3D(0.0f, 4.0f, 0.0f));
		for(int i = 26; i > 0; i--) { controlPoints.add(new Point3D(-24.0f, 4.0f, -24.0f));}
		
		controlPoints.add(new Point3D(-20.0f, 0.0f, -20.0f));
		controlPoints.add(new Point3D(-20.0f, 0.0f, -20.0f));
		controlPoints.add(new Point3D(-20.0f, 0.0f, -20.0f));
		controlPoints.add(new Point3D(-20.0f, 0.0f, -20.0f));
		controlPoints.add(new Point3D(-20.0f, 0.0f, -20.0f));
		controlPoints.add(new Point3D(-20.0f, 0.0f, -20.0f));
		controlPoints.add(new Point3D(-20.0f, 0.0f, -20.0f));
		controlPoints.add(new Point3D(-20.0f, 0.0f, -20.0f));
		controlPoints.add(new Point3D(-20.0f, 0.0f, -20.0f));
		controlPoints.add(new Point3D(-20.0f, 0.0f, -20.0f));
		controlPoints.add(new Point3D(-20.0f, 0.0f, -20.0f));
		controlPoints.add(new Point3D(-20.0f, 0.0f, -20.0f));
		controlPoints.add(new Point3D(-20.0f, 0.0f, -20.0f));

		controlPoints.add(new Point3D(2.7f, 5.0f, 0.2f));
		controlPoints.add(new Point3D(3.5f, 2.0f, 0.9f));
		controlPoints.add(new Point3D(6.8f, 7.0f, 0.0f));
		controlPoints.add(new Point3D(0.0f, 6.0f, 2.0f));
		controlPoints.add(new Point3D(2.3f, 5.0f, 2.0f));
		controlPoints.add(new Point3D(4.0f, -2.0f, 2.5f));
		controlPoints.add(new Point3D(6.9f, -5.0f, 2.0f));
		controlPoints.add(new Point3D(0.0f, 6.0f, 4.4f));
		controlPoints.add(new Point3D(2.2f, 2.0f, 4.0f));
		controlPoints.add(new Point3D(4.0f, 4.0f, 4.0f));
		controlPoints.add(new Point3D(6.0f, 7.0f, 4.8f));
		controlPoints.add(new Point3D(0.5f, 4.0f, 6.0f));
		controlPoints.add(new Point3D(2.0f, -2.0f, 6.0f));
		controlPoints.add(new Point3D(4.0f, 1.0f, 6.0f));
		controlPoints.add(new Point3D(6.0f, 3.0f, 6.0f));
	}
	
	public ArrayList<Point3D> getControlPoints()
	{
		return controlPoints;
	}
	
}
