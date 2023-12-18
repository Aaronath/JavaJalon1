package representation;

import java.io.IOException;

import javax.sound.sampled.*;

public class SoundNode extends DecorateurNode {
    String audioChemin;

    // Mettre une classe d'énumération qui donne un nom pour chaque chemin a la place d'une string
    public SoundNode(Node node, String audioChemin) {
        super(node);
        this.audioChemin = audioChemin;
    }

    @Override
    public Node chooseNext() {
        // TODO Auto-generated method stub
        return super.chooseNext();
    }

    @Override
    public void display() {
        super.display();
        try {
            AudioInputStream streamSound = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(audioChemin));
            Clip clip = AudioSystem.getClip();
            clip.open(streamSound);
            clip.start();
            Thread.sleep(clip.getMicrosecondLength() / 1000);
            clip.stop();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }


}
