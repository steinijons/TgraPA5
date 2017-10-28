package com.ru.tgra.game;


import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.ru.tgra.graphics.*;
import com.ru.tgra.graphics.motion.BSplineMotion;
import com.ru.tgra.graphics.shapes.*;
import com.ru.tgra.graphics.shapes.g3djmodel.G3DJModelLoader;
import com.ru.tgra.graphics.shapes.g3djmodel.MeshModel;

public class LabMeshTexGame extends ApplicationAdapter implements InputProcessor {

	Shader shader;

	private float angle;

	private Camera cam;
	
	private float fov = 90.0f;
	
	float currentTime;
	boolean firstFrame = true;

	MeshModel model;
	
	//LinearMotion motion;
	//BezierMotion Bmotion;
	
	BSplineMotion motion;
	BSplineMotion followCam;
	
	CamControlPoints CamPoints;
	
	Point3D modelPosition;
	Point3D CameraPosition;
	
	private Texture Moon;
	private Texture Background;
	private Texture Earth;
	private Texture Sun;	
	private Texture Mercury;
	private Texture Venus;
	private Texture Mars;
	private Texture Jupiter;
	
	Point3D Pearth;
	Point3D Psun;
	Point3D Pmercury;
	Point3D Pvenus;
	Point3D Pmars;
	Point3D Pjupter;
	
	
	
	@Override
	public void create () {
		
		File ThemeSong = new File("sound/JohnMurphySunshine(AdagioInDMinor).wav");
		
		playSound(ThemeSong);
		
		Gdx.input.setInputProcessor(this);

		DisplayMode disp = Gdx.graphics.getDesktopDisplayMode();
		Gdx.graphics.setDisplayMode(disp.width, disp.height, true);

		shader = new Shader();
		
		CamPoints = new CamControlPoints();
		
		Background = new Texture(Gdx.files.internal("textures/stars.jpg"));
		Moon = new Texture(Gdx.files.internal("textures/phobos2k.png"));
		Earth = new Texture(Gdx.files.internal("textures/earth__.jpg"));
		Sun = new Texture(Gdx.files.internal("textures/2k_sun.jpg"));
		Mercury = new Texture(Gdx.files.internal("textures/mercury.jpg"));
		Venus = new Texture(Gdx.files.internal("textures/venus.jpg"));
		Mars = new Texture(Gdx.files.internal("textures/venus.jpg"));
		Jupiter = new Texture(Gdx.files.internal("textures/jupiter.jpg"));
		
		model = G3DJModelLoader.loadG3DJFromFile("testModel.g3dj");
		
		CamPoints.initialCameraPoints();
		
		motion = new BSplineMotion(CamPoints.getControlPoints(), 0.0f, 190.0f);
		//followCam = new BSplineMotion(CamPoints.getControlPoints(), 0.0f, 20.0f);
		
		
		modelPosition = new Point3D();
		
		
		Pearth = new Point3D();
		Psun = new Point3D(0.0f, 4.0f, 0.0f);
		Pmercury = new Point3D();
		Pvenus = new Point3D();
		Pmars = new Point3D();
		Pjupter = new Point3D();
		
		BoxGraphic.create();
		SphereGraphic.create();

		ModelMatrix.main = new ModelMatrix();
		ModelMatrix.main.loadIdentityMatrix();
		shader.setModelMatrix(ModelMatrix.main.getMatrix());

		cam = new Camera();
		Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
	}

	
	private void input()
	{
	}
	
	private void update()
	{
		float deltaTime = Gdx.graphics.getDeltaTime();
		
		if(firstFrame){
			currentTime = 0.0f;
			firstFrame = false;
		}else{
			currentTime += Gdx.graphics.getRawDeltaTime();
		}		

		
		
		angle += 180.0f * deltaTime;

		/*if(Gdx.input.isKeyPressed(Input.Keys.A)) {
			cam.slide(-30.0f * deltaTime, 0, 0);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			cam.slide(30.0f * deltaTime, 0, 0);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.W)) {
			cam.slide(0, 0, -30.0f * deltaTime);
			//cam.walkForward(3.0f * deltaTime);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.S)) {
			cam.slide(0, 0, 30.0f * deltaTime);
			//cam.walkForward(-3.0f * deltaTime);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.R)) {
			cam.slide(0, 30.0f * deltaTime, 0);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.F)) {
			cam.slide(0, -30.0f * deltaTime, 0);
		}

		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			cam.yaw(-90.0f * deltaTime);
			//cam.rotateY(90.0f * deltaTime);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			cam.yaw(90.0f * deltaTime);
			//cam.rotateY(-90.0f * deltaTime);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
			cam.pitch(-90.0f * deltaTime);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			cam.pitch(90.0f * deltaTime);
		}

		if(Gdx.input.isKeyPressed(Input.Keys.Q)) {
			cam.roll(-90.0f * deltaTime);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.E)) {
			cam.roll(90.0f * deltaTime);
		}

		if(Gdx.input.isKeyPressed(Input.Keys.T)) {
			fov -= 30.0f * deltaTime;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.G)) {
			fov += 30.0f * deltaTime;
		}
*/
		if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
		{
			Gdx.graphics.setDisplayMode(500, 500, false);
			Gdx.app.exit();
		}
		
		
		motion.getCurrentPosition(currentTime, modelPosition);
		//followCam.getCurrentPosition(cameraTime, CameraPosition);
		//Bmotion.getCurrentPosition(currentTime, modelPosition);
		
		//do all updates to the game
	}
	
	private void display()
	{
		//do all actual drawing and rendering here
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

		Gdx.gl.glEnable(GL20.GL_DEPTH_TEST);
		//Gdx.gl.glDisable(GL20.GL_DEPTH_TEST);

		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		//Gdx.gl.glBlendFunc(GL20.GL_ONE, GL20.GL_ONE);
		//Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE);
		ModelMatrix.main.loadIdentityMatrix();
		
		//Camera settings
		cameraSettings();	
		//BackGround		
		space();		
		//All planets
		drawPlanets();
		

		//shader.setLightPosition(0.0f + c * 3.0f, 5.0f, 0.0f + s * 3.0f, 1.0f);
		shader.setLightPosition(0.0f, 4.0f, 0.0f, 1.0f);
		//shader.setLightPosition(cam.eye.x, cam.eye.y, cam.eye.z, 1.0f);
		shader.setSpotDirection(-cam.n.x, -cam.n.y, -cam.n.z, 0.0f);
		//shader.setSpotExponent(0.0f);
		shader.setConstantAttenuation(1.0f);
		shader.setLinearAttenuation(0.00f);
		shader.setQuadraticAttenuation(0.00f);

		//shader.setLightColor(s2, 0.4f, c2, 1.0f);
		shader.setLightColor(1.0f, 1.0f, 1.0f, 1.0f);
		
		shader.setGlobalAmbient(0.3f, 0.3f, 0.3f, 1);			
		
	}

	private void space() {
		// TODO Auto-generated method stub
		
		shader.setMaterialDiffuse(1.0f, 1.0f, 1.0f, 1.0f);
		shader.setMaterialSpecular(1.0f, 1.0f, 1.0f, 1.0f);
		shader.setShininess(1.0f);
		shader.setMaterialEmission(0, 0, 0, 1);
		
		//Background
		ModelMatrix.main.pushMatrix();
		ModelMatrix.main.addTranslation(0.0f, 0.0f, 0.0f);
		ModelMatrix.main.addScale(50f, 50f, 50f);
		shader.setModelMatrix(ModelMatrix.main.getMatrix());
		SphereGraphic.drawSolidSphere(shader, Background);			
		ModelMatrix.main.popMatrix();		
	}

	private void drawPlanets() {
		
		float s = (float)Math.sin((angle / 2.0) * Math.PI / 180.0);
		float c = (float)Math.cos((angle / 2.0) * Math.PI / 180.0);
		
		shader.setMaterialDiffuse(0.0f, 0.0f, 1.0f, 1.0f);
		shader.setMaterialSpecular(1.0f, 1.0f, 1.0f, 1.0f);
		shader.setShininess(50.0f);
		shader.setMaterialEmission(0, 0, 0, 1);
		
		//The SUN
		
		ModelMatrix.main.pushMatrix();
		ModelMatrix.main.addTranslation(0.0f, 4.0f, 0.0f);	
		ModelMatrix.main.addScale(2.5f, 2.5f, 2.5f);
		ModelMatrix.main.addRotation(angle/100, new Vector3D(1,1,1));
		shader.setModelMatrix(ModelMatrix.main.getMatrix());
		//BoxGraphic.drawSolidCube(shader, tex);
		SphereGraphic.drawSolidSphere(shader, Sun);
		//model.draw(shader);		
		ModelMatrix.main.popMatrix();
		
		//Mercury
		
		s = (float)Math.sin((angle / 13) * Math.PI / 180.0);
		c = (float)Math.cos((angle / 13) * Math.PI / 180.0);
		
		ModelMatrix.main.pushMatrix();	
		ModelMatrix.main.addTranslation(0.0f + c * 8f , 4.0f, 0.0f + s * 8f);
		Pmercury.set(0.0f + c * 8f , 4.0f, 0.0f + s * 8f);
		ModelMatrix.main.addScale(0.038f, 0.038f, 0.038f);
		ModelMatrix.main.addRotation(angle/100, new Vector3D(1,1,1));
		shader.setModelMatrix(ModelMatrix.main.getMatrix());
		SphereGraphic.drawSolidSphere(shader, Mercury);
		//model.draw(shader);		
		ModelMatrix.main.popMatrix();
		
		//Venus
		
		s = (float)Math.sin((angle / 24) * Math.PI / 180.0);
		c = (float)Math.cos((angle / 24) * Math.PI / 180.0);
		
		ModelMatrix.main.pushMatrix();
		ModelMatrix.main.addTranslation(0.0f + c *13f , 4.0f, 0.0f + s * 13f);
		Pvenus.set(0.0f + c *13f , 4.0f, 0.0f + s * 13f);
		//ModelMatrix.main.addTranslation(25.0f, 4.0f, 25.0f);	
		ModelMatrix.main.addScale(0.095f, 0.095f, 0.095f);
		ModelMatrix.main.addRotation(angle/100, new Vector3D(1,1,1));
		shader.setModelMatrix(ModelMatrix.main.getMatrix());
		SphereGraphic.drawSolidSphere(shader, Venus);		
		ModelMatrix.main.popMatrix();
		
		//Earth
		
		s = (float)Math.sin((angle / 29) * Math.PI / 180.0);
		c = (float)Math.cos((angle / 29) * Math.PI / 180.0);
		
		ModelMatrix.main.pushMatrix();
		ModelMatrix.main.addTranslation(0.0f + c * 14f, 4.0f, 0.0f + s * 14f);	
		Pearth.set(0.0f + c * 14f, 4.0f, 0.0f + s * 14f);			
		//ModelMatrix.main.addTranslation(35.0f, 4.0f, 35.0f);	
		ModelMatrix.main.addScale(0.1f, 0.1f, 0.1f);
		ModelMatrix.main.addRotation(angle/100, new Vector3D(1,1,1));
		shader.setModelMatrix(ModelMatrix.main.getMatrix());
		SphereGraphic.drawSolidSphere(shader, Earth);
		//model.draw(shader);		
		ModelMatrix.main.popMatrix();
		
		//Moon

		s = (float)Math.sin((angle / 5) * Math.PI / 180.0);
		c = (float)Math.cos((angle / 5) * Math.PI / 180.0);
		
		ModelMatrix.main.pushMatrix();
		ModelMatrix.main.addTranslation(Pearth.x + c * 0.6f, 4.0f, Pearth.z + s * 0.6f);
		ModelMatrix.main.addScale(0.025f, 0.0125f, 0.0125f);
		ModelMatrix.main.addRotation(angle/100, new Vector3D(1,1,1));
		shader.setModelMatrix(ModelMatrix.main.getMatrix());
		SphereGraphic.drawSolidSphere(shader, Moon);
		//model.draw(shader);		
		ModelMatrix.main.popMatrix();
		
		
		//Mars
		
		s = (float)Math.sin((angle / 35) * Math.PI / 180.0);
		c = (float)Math.cos((angle / 35) * Math.PI / 180.0);
		
		ModelMatrix.main.pushMatrix();
		ModelMatrix.main.addTranslation(0.0f + c * 17f , 4.0f, 0.0f + s * 17f);
		Pmars.set(0.0f + c * 17f , 4.0f, 0.0f + s * 17f);
		//ModelMatrix.main.addTranslation(45.0f, 4.0f, 45.0f);	
		ModelMatrix.main.addScale(0.053f, 0.05f, 0.053f);
		ModelMatrix.main.addRotation(angle/100, new Vector3D(1,1,1));
		shader.setModelMatrix(ModelMatrix.main.getMatrix());
		SphereGraphic.drawSolidSphere(shader, Mars);
		//model.draw(shader);		
		ModelMatrix.main.popMatrix();
		
		//Jupiter
		
		s = (float)Math.sin((angle / 47) * Math.PI / 180.0);
		c = (float)Math.cos((angle / 47) * Math.PI / 180.0);
		
		ModelMatrix.main.pushMatrix();
		ModelMatrix.main.addTranslation(0.0f + c * 22.5f , 4.0f, 0.0f + s * 22.5f);
		Pjupter.set(0.0f + c * 22.5f , 4.0f, 0.0f + s * 22.5f);
		//ModelMatrix.main.addTranslation(60.0f, 4.0f, 60.0f);	
		ModelMatrix.main.addScale(1.12f, 1.12f, 1.12f);
		ModelMatrix.main.addRotation(angle/100, new Vector3D(1,1,1));
		shader.setModelMatrix(ModelMatrix.main.getMatrix());
		SphereGraphic.drawSolidSphere(shader, Jupiter);
		//model.draw(shader);		
		ModelMatrix.main.popMatrix();
		
		
	}

	private void cameraSettings() {
		// TODO Auto-generated method stub
		ModelMatrix.main.addTranslation(modelPosition.x, modelPosition.y, modelPosition.z);		
		
		shader.setMaterialDiffuse(1.0f, 1.0f, 1.0f, 1.0f);
		shader.setMaterialSpecular(1.0f, 1.0f, 1.0f, 1.0f);
		shader.setShininess(1.0f);
		shader.setMaterialEmission(0, 0, 0, 1);
		
		
		cam.perspectiveProjection(fov, (float)Gdx.graphics.getWidth() / (float)(2*Gdx.graphics.getHeight()), 0.2f, 100.0f);
		shader.setViewMatrix(cam.getViewMatrix());
		shader.setProjectionMatrix(cam.getProjectionMatrix());
		//shader.setEyePosition(cam.eye.x, cam.eye.y, cam.eye.z, 1.0f);
		//cam.setEye(CameraPosition.x, CameraPosition.y, CameraPosition.z);
		cam.look(cam.getEye(), modelPosition , new Vector3D(0,1,0));
	}
	
	@Override
	public void render () {
		
		input();
		//put the code inside the update and display methods, depending on the nature of the code
		update();
		display();

	}
	
	//https://www.youtube.com/watch?v=QVrxiJyLTqU
	private void playSound(File themeSong) {
		// TODO Auto-generated method stub
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(themeSong));
			clip.start();
		}catch(Exception e)
		{
			
		}
	}


	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}


}