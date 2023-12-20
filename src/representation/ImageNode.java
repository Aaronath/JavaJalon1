package representation;

import javax.swing.*;

import fonctionGeneral.ImagePath;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

/**
 * La classe ImageNode est un décorateur concret qui ajoute la fonctionnalité
 * d'afficher une image avant le contenu du nœud décoré.
 */
public class ImageNode extends NodeDecorator {

    /** Chemin vers l'image à afficher. */
    private ImagePath imagePath;

    /**
     * Constructeur de ImageNode.
     * @param decoratedNode Le nœud décoré auquel l'image sera ajoutée.
     * @param imagePath Le chemin vers l'image à afficher.
     */
    public ImageNode(Event decoratedNode, ImagePath imagePath) {
        super(decoratedNode);
        this.imagePath = imagePath;
    }

    /**
     * Affiche l'image avant le contenu du nœud décoré.
     */
    @Override
    public void display() {
        showImage();
        super.display();
    }

    /**
     * Affiche l'image à partir du chemin spécifié.
     */
    private void showImage() {
        try {
            BufferedImage img = ImageIO.read(new File(imagePath.getPath()));
            ImageIcon icon = new ImageIcon(img);
            JLabel label = new JLabel(icon);
            JOptionPane.showMessageDialog(null, label);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Définit la liste des événements suivants possibles après ce nœud décoré.
     * @param asList La liste des événements suivants possibles.
     */
    @Override
    public void setNextNodes(List<Event> asList) {
        decoratedEvent.setNextNodes(asList);
    }
}
