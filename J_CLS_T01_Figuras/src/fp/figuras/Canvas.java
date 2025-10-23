package fp.figuras;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.*;

/**
 * Canvas is a class to allow for simple graphical drawing on a canvas.
 * This is a modification of the general purpose Canvas, specially made for
 * the BlueJ "shapes" example. 
 *
 * @author: Bruce Quig
 * @author: Michael Kölling (mik)
 *
 * @version 2011.07.31
 */
public class Canvas
{
    // Note: The implementation of this class (specifically the handling of
    // shape identity and colors) is slightly more complex than necessary. This
    // is done on purpose to keep the interface and instance fields of the
    // shape objects in this project clean and simple for educational purposes.

    private static Canvas canvasSingleton;

    /**
     * Factory method to get the canvas singleton object.
     */
    public static Canvas getCanvas()
    {
        if(canvasSingleton == null) {
            canvasSingleton = new Canvas("Demo para FP", 500, 300, 
                                         Color.white);
        }
        canvasSingleton.setVisible(true);
        return canvasSingleton;
    }

    //  ----- instance part -----

    private JFrame frame;
    private CanvasPane canvas;
    private Graphics2D graphic;
    private Color colorFondo;
    private Image canvasImage;
    private List<Object> objetos;
    private Map<Object, ShapeDescription> formas;
    
    /**
     * Crea un Canvas.
     * @param titulo    Título que aparece en el marco del canvas
     * @param anchura   Anchura deseada del canvas
     * @param altura   Altura deseada del canvas
     * @param colorFondo Color de fondo deseado del canvas
     */
    private Canvas(String titulo, Integer anchura, Integer altura, Color colorFondo)
    {
        frame = new JFrame();
        canvas = new CanvasPane();
        frame.setContentPane(canvas);
        frame.setTitle(titulo);
        frame.setLocation(30, 30);
        canvas.setPreferredSize(new Dimension(anchura, altura));
        this.colorFondo = colorFondo;
        frame.pack();
        objetos = new ArrayList<Object>();
        formas = new HashMap<Object, ShapeDescription>();
    }

    /**
     * Hace que el canvas sea visible y lo trae al primer plano de la pantalla.
     * Este m�todo tambi�n puede usarse para traer al primer plano a un canvas visible
     * con objeto de colocarlo por delante de otras ventanas.
     * @param visible  Valor booleano que representa la visibilidad deseada del canvas (tru o false)
     * the canvas (true or false) 
     */
    public void setVisible(Boolean visible)
    {
        if(graphic == null) {
            // first time: instantiate the offscreen image and fill it with
            // the background color
            Dimension size = canvas.getSize();
            canvasImage = canvas.createImage(size.width, size.height);
            graphic = (Graphics2D)canvasImage.getGraphics();
            graphic.setColor(colorFondo);
            graphic.fillRect(0, 0, size.width, size.height);
            graphic.setColor(Color.black);
        }
        frame.setVisible(visible);
    }

    /**
     * Dibuja una forma dada en el canvas
     * @param  referenceObject  un objeto para definir la identidad de esta forma
     * @param  color            El color de la forma
     * @param  shape            El objeto shape a dibujar en el canvas
     */
     // Note: this is a slightly backwards way of maintaining the shape
     // objects. It is carefully designed to keep the visible shape interfaces
     // in this project clean and simple for educational purposes.
    public void dibujar(Object referenceObject, String color, Shape shape)
    {
        objetos.remove(referenceObject);   // just in case it was already there
        objetos.add(referenceObject);      // add at the end
        formas.put(referenceObject, new ShapeDescription(shape, color));
        redibujar();
    }
 
    /**
     * Borra una forma dada del canvas
     * @param  referenceObject  El objeto a borrar. 
     */
    public void borrar(Object referenceObject)
    {
        objetos.remove(referenceObject);   // just in case it was already there
        formas.remove(referenceObject);
        redibujar();
    }

    /**
     * Asigna el color de fondo del Canvas.
     * @param  nuevoColor   El nuevo color de fondo del canvas. Solo puede tomar los valores
     * "red", "black", "blue", "yellow", "green", "magenta", "white" 
     * 
     */
    public void setColorFondo(String colorString)
    {
        if(colorString.equals("red")) {
            graphic.setColor(new Color(235, 25, 25));
        }
        else if(colorString.equals("black")) {
            graphic.setColor(Color.black);
        }
        else if(colorString.equals("blue")) {
            graphic.setColor(new Color(30, 75, 220));
        }
        else if(colorString.equals("yellow")) {
            graphic.setColor(new Color(255, 230, 0));
        }
        else if(colorString.equals("green")) {
            graphic.setColor(new Color(80, 160, 60));
        }
        else if(colorString.equals("magenta")) {
            graphic.setColor(Color.magenta);
        }
        else if(colorString.equals("white")) {
            graphic.setColor(Color.white);
        }
        else {
            graphic.setColor(Color.black);
        }
    }

    /**
     * Espera un n�mero especificado de milisegundos antes de acabar.
     * Proporciona una forma f�cil de espercificar un peque�o retraso que
     * puede ser usando cuando se generan animaciones.
     * @param  milisegundos  El n�mero de milisegundos a esperar
     */
    public void esperar(Integer milisegundos)
    {
        try
        {
            Thread.sleep(milisegundos);
        } 
        catch (Exception e)
        {
            // ignoring exception at the moment
        }
    }

    /**
     * Redibuja todas las formas que hay actualmente en el canvas.
     */
    private void redibujar()
    {
        borrar();
        for(Object shape : objetos) {
            formas.get(shape).draw(graphic);
        }
        canvas.repaint();
    }
       
    /**
     * Borra todo el canvas (no lo repinta).
     *      */
    private void borrar()
    {
        Color original = graphic.getColor();
        graphic.setColor(colorFondo);
        Dimension size = canvas.getSize();
        graphic.fill(new Rectangle(0, 0, size.width, size.height));
        graphic.setColor(original);
    }


    /************************************************************************
     * Clase interna CanvasPane - El componente del canvas actual contenido en el marco del Canvas,
     * Es esencialmente un JPanel con una capacidad a�adida para refrescar 
     * la imagen en �l.
     */
    private class CanvasPane extends JPanel
    {

		private static final long serialVersionUID = 1L;

		public void paint(Graphics g)
        {
            g.drawImage(canvasImage, 0, 0, null);
        }
    }
    
    /************************************************************************
     * Inner class CanvasPane - the actual canvas component contained in the
     * Canvas frame. This is essentially a JPanel with added capability to
     * refresh the image drawn on it.
     */
    private class ShapeDescription
    {
        private Shape shape;
        private String colorString;

        public ShapeDescription(Shape shape, String color)
        {
            this.shape = shape;
            colorString = color;
        }

        public void draw(Graphics2D graphic)
        {
            setColorFondo(colorString);
            graphic.fill(shape);
        }
    }

}
