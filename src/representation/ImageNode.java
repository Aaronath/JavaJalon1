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
    
    @Override
    public void setNextNodes(List<Event> asList) {
        decoratedEvent.setNextNodes(asList);
    }
}
