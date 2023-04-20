/**
 *    ===============================================================================
 *    Shape.java : The superclass of all shapes.
 *    A shape defines various properties, including selected, colour, width and height.
 *    YOUR UPI: ANSWER
 *    ===============================================================================
 */
import java.awt.*;
abstract class Shape {
    public static final int DEFAULT_PATHTYPE = 0;
    public static final int DEFAULT_SHAPETYPE = 0;
    public static final int DEFAULT_X = 0, DEFAULT_Y = 0, DEFAULT_WIDTH=100, DEFAULT_HEIGHT=100, DEFAULT_PANEL_WIDTH=600, DEFAULT_PANEL_HEIGHT=800;
    public static final Color DEFAULT_COLOR=Color.blue, DEFAULT_BORDER_COLOR=Color.orange;

    public int x, y, width=DEFAULT_WIDTH, height=DEFAULT_HEIGHT, panelWidth=DEFAULT_PANEL_WIDTH, panelHeight=DEFAULT_PANEL_HEIGHT; // the bouncing area
    protected Color color = DEFAULT_COLOR;
    protected boolean selected = false;    // draw handles if selected
    protected MovingPath path = new BouncingPath(1, 2);

	// data field
	// Complete the getBorderColor()
	// Complete the setBorderColor()

	//Complete the default constructor
	//Complete 2 abstract methods

	//Complete the two overloaded constructors
	//Complete the tostring() method

 	public int getX() { return this.x; }
    public int getY() { return this.y;}
    public int getWidth() { return width; }
	public void setWidth(int w) { if (w < DEFAULT_PANEL_WIDTH && w > 0) width = w; }
    public int getHeight() {return height; }
	public void setHeight(int h) { if (h < DEFAULT_PANEL_HEIGHT && h > 0) height = h; }
    public boolean isSelected() { return selected; }
    public void setSelected(boolean s) { selected = s; }
	public Color getColor() { return color; }
    public void setColor(Color fc) { color = fc; }
    public void resetPanelSize(int w, int h) {
		panelWidth = w;
		panelHeight = h;
	}
 	public void drawHandles(Graphics obj) {
        if (selected) {
			System.out.println("Draw 4 handles");
        }
    }
    public void move() {
	        path.move();
    }
    /* Inner class ===================================================================== Inner class
     *    MovingPath : The superclass of all paths. It is an inner class.
     *    A path can change the current position of the shape.
     *    =============================================================================== */
    abstract class MovingPath {
        protected int deltaX, deltaY; // moving distance
        public MovingPath() { }
        public abstract void move();
    }
    class BouncingPath extends MovingPath {
        public BouncingPath(int dx, int dy) {
            deltaX = dx;
            deltaY = dy;
         }
        public void move() {
             x = x + deltaX;
             y = y + deltaY;
             if ((x < 0) && (deltaX < 0)) {
                 deltaX = -deltaX;
                 x = 0;
             }
             else if ((x + width > panelWidth) && (deltaX > 0)) {
                 deltaX = -deltaX;
                 x = panelWidth - width;
             }
             if ((y< 0) && (deltaY < 0)) {
                 deltaY = -deltaY;
                 y = 0;
             }
             else if((y + height > panelHeight) && (deltaY > 0)) {
                 deltaY = -deltaY;
                 y = panelHeight - height;
             }
        }
    }
    //Complete the inner class
}