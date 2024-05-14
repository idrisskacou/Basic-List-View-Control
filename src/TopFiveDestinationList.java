import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class TopFiveDestinationList {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	TopDestinationListFrame topDestinationListFrame = new TopDestinationListFrame();
                topDestinationListFrame.setTitle("Top 5 Destination List with my name "); //// Top Label of the window 
                topDestinationListFrame.setVisible(true);
            }
        });
    }
}


class TopDestinationListFrame extends JFrame {
    private DefaultListModel listModel;

    public TopDestinationListFrame() {
    	// Top Label of the window 
        super("Top Five Destination List with my name ");
        
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 750);

        listModel = new DefaultListModel();


        //Make updates to your top 5 list below. Import the new image files to resources directory.
        // This is about natural wonders and beautiful landscapes
        /*
         * Image source: David Marcu "hedgehog," 2016. Accessed via https://commons.wikimedia.org/wiki/File:Alone_in_the_unspoilt_wilderness_(Unsplash).jpg
         */
        addDestinationNameAndPicture("1. Romania Top Destination: natural wonders and beautifull landscapes ", new ImageIcon(getClass().getResource("/resources/Romania.jpg")));

        // 2 Image Top Destination: Eiffel Tower is a symbol of Paris
        /*
         * Image source: Joe Ravi, "Landing on runway 19L" 2011. Accessed via https://commons.wikimedia.org/wiki/File:Air_France_A380_F-HPJA.jpg
         */
        addDestinationNameAndPicture("2. France Top Destination: Eiffel Tower is a symbol of Paris and place for many tourist", new ImageIcon(getClass().getResource("/resources/Air_France.jpg")));
        
        // 3 Image Top Destination Germani Top Destination
        /*
         * Image source: Granada, "2022 European Championships Munich, Beach Volleyball. Picture shows: Tanja Hüberli (SUI), Kira Walkenhorst (GER)," 2009. Accessed via https://commons.wikimedia.org/wiki/File:20220816_European_Championships_Munich_2022_Hüberli_Walkenhorst_DSC_6653.jpg
         */
        addDestinationNameAndPicture("3. Germani Top Destination: Neuschwanstein Castle is a must see", new ImageIcon(getClass().getResource("/resources/Germani.jpg")));
       
        // 4 Image This is the image about 
        /*
         * Image source: Moheen Reeyad, " Cape Town, South Africa, is one of the streets in a former township, situated on the slopes of Signal Hill above the city centre and a historical centre of Cape Malay culture in Cape Town." 2009. Accessed via https://commons.wikimedia.org/wiki/File:Chiappini_Street,_Bo-Kaap_(01).jpg
         */
        addDestinationNameAndPicture("4. South Africa Top Destination: Cape Town is modern and beautifull Mountain which simply strunning", new ImageIcon(getClass().getResource("/resources/South_Africa.jpg")));
        
        // 5 Image Mexico Top Destination
        /*
         * Image source: Jeses, "Mexico City - Palace of fine arts seen from top of Torre Latinoamericana " 2006. Accessed via https://commons.wikimedia.org/wiki/File:Mexico_City_Palacio_de_bellas_artes.jpg
         */
        addDestinationNameAndPicture("5. Mexico Top Destination: National Anthropology Museums", new ImageIcon(getClass().getResource("/resources/Mexico.jpg")));
        
        // Add a label with your name on it.
        addDestinationNameAndPicture("Idriss Kacou", new ImageIcon(getClass().getResource("/resources/TestImage.jpg")));
        
        JList list = new JList(listModel);
        JScrollPane scrollPane = new JScrollPane(list);

        TextAndIconListCellRenderer renderer = new TextAndIconListCellRenderer(2);

        list.setCellRenderer(renderer);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void addDestinationNameAndPicture(String text, Icon icon) {
        TextAndIcon tai = new TextAndIcon(text, icon);
        listModel.addElement(tai);
    }
}


class TextAndIcon {
    private String text;
    private Icon icon;

    public TextAndIcon(String text, Icon icon) {
        this.text = text;
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
}


class TextAndIconListCellRenderer extends JLabel implements ListCellRenderer {
    private static final Border NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);

    private Border insideBorder;

    public TextAndIconListCellRenderer() {
        this(0, 0, 0, 0);
    }

    public TextAndIconListCellRenderer(int padding) {
        this(padding, padding, padding, padding);
    }

    public TextAndIconListCellRenderer(int topPadding, int rightPadding, int bottomPadding, int leftPadding) {
        insideBorder = BorderFactory.createEmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding);
        setOpaque(true);
    }

    public Component getListCellRendererComponent(JList list, Object value,
    int index, boolean isSelected, boolean hasFocus) {
        // The object from the combo box model MUST be a TextAndIcon.
        TextAndIcon tai = (TextAndIcon) value;

        // Sets text and icon on 'this' JLabel.
        setText(tai.getText());
        setIcon(tai.getIcon());

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        Border outsideBorder;

        if (hasFocus) {
            outsideBorder = UIManager.getBorder("List.focusCellHighlightBorder");
        } else {
            outsideBorder = NO_FOCUS_BORDER;
        }

        setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
        setComponentOrientation(list.getComponentOrientation());
        setEnabled(list.isEnabled());
        setFont(list.getFont());

        return this;
    }

    // The following methods are overridden to be empty for performance
    // reasons. If you want to understand better why, please read:
    //
    // http://java.sun.com/javase/6/docs/api/javax/swing/DefaultListCellRenderer.html#override

    public void validate() {}
    public void invalidate() {}
    public void repaint() {}
    public void revalidate() {}
    public void repaint(long tm, int x, int y, int width, int height) {}
    public void repaint(Rectangle r) {}
}