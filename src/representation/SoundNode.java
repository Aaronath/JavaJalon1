package representation;

import java.io.File;
import java.io.IOException;

import java.net.URL;
import javax.sound.sampled.*;

import fonctionGeneral.AudioPath;

public class SoundNode extends DecorateurNode {
    String audioChemin;

    // Utilisez une classe d'énumération pour définir les chemins audio au lieu d'une chaîne.
    public SoundNode(Node node, AudioPath audioChemin) {
        super(node);
        this.audioChemin = audioChemin.getPath();
    }

    /**
     * Redéfinition de la méthode chooseNext.
     * 
     * @return Le prochain nœud choisi.
     */
    @Override
    public Node chooseNext() {
        // TODO: Implémentez la logique de choix du prochain nœud si nécessaire.
        return super.chooseNext();
    }

    /**
     * Redéfinition de la méthode display pour jouer le son en plus de l'affichage du nœud.
     */
    @Override
    public void display() {
        super.display();
        try {
            // Obtenez l'URL de la ressource audio.
            File audioFile = new File(audioChemin);
        
            if (audioFile != null) {
                // Créez un AudioInputStream à partir de l'URL.
                AudioInputStream streamSound = AudioSystem.getAudioInputStream(audioFile);
        
                Clip clip = AudioSystem.getClip();
                clip.open(streamSound);
        
                // Démarrage de la lecture du son.
                clip.start();
        
                // Attente de la fin de la lecture du son (approche bloquante).
                Thread.sleep(clip.getMicrosecondLength() / 1000);
        
                // Arrêt du son.
                clip.stop();
            } else {
                System.err.println("Impossible de charger le fichier audio à partir du chemin : " + audioChemin);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
}

