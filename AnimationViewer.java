/**
 * ==========================================================================================
 *  AnimationPanel.java : Moves shapes around on the screen according to different paths.
 *  It is the main drawing area where shapes are added and manipulated.
 *  YOUR UPI: Okav891
 *  =========================================================================================
 */

import java.awt.*;
import java.util.ArrayList;

class AnimationViewer  {
    private ArrayList<Shape> shapes = new ArrayList<Shape>(); //create the ArrayList to store shapes
    private int currentShapeType=Shape.DEFAULT_SHAPETYPE; // the current shape type,
    private int currentPathType=Shape.DEFAULT_PATHTYPE;  // the current path type
    private Color currentColor=Shape.DEFAULT_COLOR;  // the current fill colour of a shape
    private int currentPanelWidth=Shape.DEFAULT_PANEL_WIDTH, currentPanelHeight = Shape.DEFAULT_PANEL_HEIGHT, currentWidth=Shape.DEFAULT_WIDTH, currentHeight=Shape.DEFAULT_HEIGHT;

	// data field
private Color currentBorderColor = Shape.DEFAULT_BORDER_COLOR;
	public Color getCurrentBorderColor(){ return currentBorderColor; }
	public void setCurrentBorderColor(Color bc){ currentBorderColor = bc; }
	//Complete the createNewshape method
    protected void createNewShape(int x, int y){
        switch(currentShapeType){
            case RECTANGLE:
                shapes.add(new RectangleShape(x, y, getCurrentWidth(), getCurrentHeight(), currentPanelWidth, currentPanelHeight, getCurrentColor(), getCurrentBorderColor(), getCurrentPathType()));
                break;
            case OVAL:
                shapes.add(new OvalShape(x, y, getCurrentWidth(), getCurrentHeight(), currentPanelWidth, currentPanelHeight, getCurrentColor(), getCurrentBorderColor(), getCurrentPathType()));
                break;
            case STAR:
                shapes.add(new StarShape(x, y, getCurrentWidth(), getCurrentHeight(), currentPanelWidth, currentPanelHeight, getCurrentColor(), getCurrentBorderColor(), getCurrentPathType()));
                break;
            case OCTAGON:
                shapes.add(new OctagonShape(x, y, getCurrentWidth(), getCurrentHeight(), currentPanelWidth, currentPanelHeight, getCurrentColor(), getCurrentBorderColor(), getCurrentPathType()));
                break;
        }
    }
	public AnimationViewer() {}

	//Complete the get/set currentShapeType methods
	//Complete the get/set currentPathType methods

	public int getCurrentWidth() { return  currentWidth; }
	public int getCurrentHeight() { return currentHeight; }
    public void setCurrentWidth(int w) {currentWidth=w;}
    public void setCurrentHeight(int h) {currentHeight=h;}
    public Color getCurrentColor() { return currentColor; }
    public void setCurrentColor(Color c){currentColor = c;}
    public void setPanelWidth(int w) {currentPanelHeight=w;}
    public void setPanelHeight(int h) {currentPanelHeight=h;}
    public void paintComponent(Graphics g) {
		for (Shape currentShape: shapes) {
			currentShape.move();
			currentShape.draw(g);
			currentShape.drawHandles(g);
		}
    }
}