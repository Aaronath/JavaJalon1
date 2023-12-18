import fonctionGeneral.AudioPath;
import representation.DecorateurNode;
import representation.InnerNode;
import representation.SoundNode;
import univers.Weapon;
import univers.Marine.NouvelleRecrue;

public class Main2 {
    public static void main(String[] args) {

        DecorateurNode soloNodeSound = new SoundNode(new InnerNode(2, "Tu es donc solo ! Tu pars en mer à bord de ton radeau !"),AudioPath.POWERUP);
        soloNodeSound.display();

    }
}