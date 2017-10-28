package com.ru.tgra.game;

import java.util.ArrayList;

import com.ru.tgra.graphics.Camera;
import com.ru.tgra.graphics.Point3D;

public class CamControlPoints {
	
	
	ArrayList<Point3D> controlPoints;
	ArrayList<Point3D> cameraPlanet;
	Camera cam;
	LabMeshTexGame planets;
	
	public CamControlPoints() {
		// TODO Auto-generated constructor stub

	}

	
	public void initialCameraPoints()
	{
		controlPoints = new ArrayList<Point3D>();
		cameraPlanet = new ArrayList<Point3D>();
		controlPoints.add(new Point3D(0.0f, -4.0f, 0.0f));
		controlPoints.add(new Point3D(-30.0f, -4.0f, -10.0f));
		controlPoints.add(new Point3D(-10.0f, -4.0f, 10.0f));
		controlPoints.add(new Point3D(5.0f, -4.0f, 20.0f));
		controlPoints.add(new Point3D(0.0f, -4.0f, 30.0f));
		controlPoints.add(new Point3D(-5.0f, -10.0f, 30.0f));
		controlPoints.add(new Point3D(-35.0f, -25.0f, -30.0f));
		controlPoints.add(new Point3D(-25.0f, -30.0f, -20.0f));
		controlPoints.add(new Point3D(-15.0f, -25.0f, -10.0f));
		controlPoints.add(new Point3D(0.0f, -4.0f, 0.0f));
	}
	
	public ArrayList<Point3D> getControlPoints()
	{
		return controlPoints;
	}
	
	public ArrayList<Point3D> getCameraPlanet()
	{
		return cameraPlanet;
	}
	
}
