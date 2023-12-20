package representation;

import javax.imageio.ImageIO;
import javax.swing.*;

import fonctionGeneral.ImagePath;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;



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

            // Crée une fenêtre JFrame pour afficher l'image
            JFrame frame = new JFrame();
            frame.setTitle("Image Display");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // Crée un JLabel pour afficher l'image
            JLabel label = new JLabel(new ImageIcon(img));

            // Ajoute le JLabel à la fenêtre
            frame.getContentPane().add(label, BorderLayout.CENTER);

            // Ajuste manuellement la taille de la fenêtre
            int width = img.getWidth();
            int height = img.getHeight();
            frame.setSize(width + 50, height + 50); // Ajustez ces valeurs selon vos besoins

            // Rend la fenêtre modale (elle apparaît en premier plan)
            frame.setAlwaysOnTop(true);
            frame.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);

            // Centre la fenêtre sur l'écran
            frame.setLocationRelativeTo(null);

            // Rend la fenêtre visible
            frame.setVisible(true);

            // Crée un timer pour fermer la fenêtre après 4 secondes
            Timer timer = new Timer(3000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose(); // Ferme la fenêtre
                }
            });

            // Démarre le timer
            timer.setRepeats(false); // Ne se répète pas
            timer.start();

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
