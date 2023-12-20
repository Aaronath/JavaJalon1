package representation;

import javax.swing.*;

import fonctionGeneral.ImagePath;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

// Décorateur concret pour l'image
public class ImageNode extends NodeDecorator {
    private ImagePath imagePath;
    

    public ImageNode(Event decoratedNode, ImagePath imagePath) {
        super(decoratedNode);
        this.imagePath = imagePath;
    }

    @Override
    public void display() {
        // Affiche l'image avant le contenu du nœud décoré
        showImage();
        super.display();
    }

    private void showImage() {
        // Logique pour afficher l'image
        try {
            BufferedImage img = ImageIO.read(new File(imagePath.getPath()));
            ImageIcon icon = new ImageIcon(img);
            JLabel label = new JLabel(icon);
            JOptionPane.showMessageDialog(null, label);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void setNextNodes(List<Event> asList) {
		decoratedEvent.setNextNodes(asList);
		
	}
}

