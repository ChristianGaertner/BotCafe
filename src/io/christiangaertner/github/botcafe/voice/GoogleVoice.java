package io.christiangaertner.github.botcafe.voice;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author Christian
 */
public class GoogleVoice {

    public enum Lang {

        GERMAN("de"),
        ENGLISH("en"),
        US("en_us");
        private String lang;

        private Lang(String l) {
            lang = l;
        }

        public String get() {
            return lang;
        }
    }
    private static final int MAX_TXT_LENGTH = 100;
    private static final String GOOGLE_URL = "http://translate.google.com/translate_tts?tl=%lang%&q=%txt%";
    private final Lang lang;

    public GoogleVoice(Lang l) {
        lang = l;
    }

    public void read(String txt) {
        if (txt.length() > MAX_TXT_LENGTH) {
            Iterator<String> i = splitToChunks(txt).iterator();

            while (i.hasNext()) {
                playText(i.next());
            }
        } else {
            playText(txt);
        }
    }

    private void playText(String txt) {
        try {
            InputStream is = makeUrl(txt).openConnection().getInputStream();
            
            Player pl = new Player(is);
            pl.play();
            
        } catch (IOException ex) {
            System.err.println("Error with GoogleVoice (URL): " + ex.getMessage());
        } catch (JavaLayerException ex) {
            System.err.println("Error with GoogleVoice (Player): " + ex.getMessage());
        }

    }

    private URL makeUrl(String txt) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private ArrayList<String> splitToChunks(String txt) {
        String[] words = txt.split(" ");
        
        ArrayList<String> chunks = new ArrayList<String>();
        
        String toAdd = "";
        for (String word : words) {
            if ((toAdd + word).length() > MAX_TXT_LENGTH && !toAdd.isEmpty()) {
                
                chunks.add(toAdd.trim());
                
                toAdd = "";
                
            }
            
            toAdd += word;
        }
        
        return chunks;
    }
}
