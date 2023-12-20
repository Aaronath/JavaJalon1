package representation;
import javax.sound.sampled.*;

import fonctionGeneral.AudioPath;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SoundNode extends NodeDecorator {
    private AudioPath soundPath; // Chemin vers le fichier audio

    public SoundNode(Event decoratedEvent, AudioPath soundPath) {
        super(decoratedEvent);
        this.soundPath = soundPath;
    }

    @Override
    public void display() {


        // Logique spécifique pour jouer le son
        System.out.println("Joue le son: " + soundPath);

        playSound();
        super.display();
    }

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

	@Override
	public void setNextNodes(List<Event> asList) {
		decoratedEvent.setNextNodes(asList);
	}
}
