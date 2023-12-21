package representation;

import javax.sound.sampled.*;
import fonctionGeneral.AudioPath;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * La classe SoundNode est un décorateur de nœud qui ajoute la fonctionnalité
 * de jouer un fichier audio avant d'afficher le contenu du nœud décoré.
 */
public class SoundNode extends NodeDecorator {

    /** Le chemin vers le fichier audio. */
    private AudioPath soundPath;

    /**
     * Constructeur de SoundNode.
     * @param decoratedEvent Le nœud décoré auquel le son sera ajouté.
     * @param soundPath Le chemin vers le fichier audio à jouer.
     */
    public SoundNode(Event decoratedEvent, AudioPath soundPath) {
        super(decoratedEvent);
        this.soundPath = soundPath;
    }

    /**
     * Affiche le nœud décoré en jouant le son avant d'afficher le contenu.
     */
    @Override
    public void display() {
        // Utilisation d'un thread pour jouer le son de manière asynchrone
        Thread soundThread = new Thread(() -> playSound());
        soundThread.start();

        super.display();
    }

    /**
     * Joue le son à partir du fichier audio spécifié.
     */
    public void playSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundPath.getPath()));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            // Pas besoin de Thread.sleep ici pour permettre à la lecture de continuer en arrière-plan
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
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
