package com.ru.tgra.graphics.motion;

import com.ru.tgra.graphics.Point3D;

public class Bezier {
	
	public static void getPosition(Point3D P1, Point3D P2, Point3D P3, Point3D P4, float t, Point3D out_position)
	{	
		out_position.x = (1.0f - t)*(1.0f - t)*(1.0f - t) * P1.x + 3*(1.0f - t)*(1.0f - t) * t * P2.x + 3*(1.0f - t)*t * t * P3.x +  t*t*t * P4.x;
		out_position.y = (1.0f - t)*(1.0f - t)*(1.0f - t) * P1.y + 3*(1.0f - t)*(1.0f - t) * t * P2.y + 3*(1.0f - t)*t * t * P3.y +  t*t*t * P4.y;
		out_position.z = (1.0f - t)*(1.0f - t)*(1.0f - t) * P1.z + 3*(1.0f - t)*(1.0f - t) * t * P2.z + 3*(1.0f - t)*t * t * P3.z +  t*t*t * P4.z;
	}
	
}
