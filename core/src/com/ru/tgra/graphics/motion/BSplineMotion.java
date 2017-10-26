package com.ru.tgra.graphics.motion;

import java.util.ArrayList;

import com.ru.tgra.graphics.Point3D;
import com.ru.tgra.graphics.Vector3D;

public class BSplineMotion {
	
	
	ArrayList<BezierMotion> motions;
	
	Point3D Pstart;
	Point3D Pend;
	
	float startTime;
	float endTime;
	
	public BSplineMotion(ArrayList<Point3D> controlPoints, float startTime, float endTime)
	{
		this.startTime = startTime;
		this.endTime = endTime;
		
		int motionCount = (controlPoints.size() / 2) - 1;
		float timePerMotion = (endTime - startTime) / (float)motionCount;
		
		motions = new ArrayList<BezierMotion>();
		
		if(controlPoints.size() < 4)
		{
			motions = null;
			return;
		}
		
		Point3D P1 = controlPoints.get(0);
		Point3D P2 = controlPoints.get(1);
		Point3D P3 = controlPoints.get(2);
		Point3D P4 = controlPoints.get(3);
		
		BezierMotion motion = 
				new BezierMotion(P1, P2, P3, P4, startTime, startTime + timePerMotion);
		
		motions.add(motion);
		
		Pstart = P1;
		
		for(int i = 1; i < motionCount; i++)
		{
			P1 = P4;
			P2 = P1;
			P2.add(Vector3D.difference(P4, P3));
			
			P3 = controlPoints.get((i + 1) * 2);
			P4 = controlPoints.get((i + 1) * 2 + 1);
			
			motion = new BezierMotion(P1, P2, P3, P4, startTime + timePerMotion * i, startTime + timePerMotion * (i + 1));
			motions.add(motion);
			
			
		
		}		
		Pend = P4;
	}
	
	public void getCurrentPosition(float currentTime, Point3D out_position)
	{
		if(currentTime < startTime)
		{
			out_position.x = Pstart.x;
			out_position.y = Pstart.y;
			out_position.z = Pstart.z;
		}
		else if(currentTime > endTime)
		{
			out_position.x = Pend.x;
			out_position.y = Pend.y;
			out_position.z = Pend.z;
		}
		else
		{
			for(BezierMotion motion: motions)
			{
				if(motion.startTime < currentTime && currentTime < motion.endTime)
				{
					motion.getCurrentPosition(currentTime, out_position);
					break;
				}
			}
		}
	}
}
