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
        System.out.println("Joue le son: " + soundPath);
        playSound();
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
            Thread.sleep(clip.getMicrosecondLength() / 1000);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException | InterruptedException e) {
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
