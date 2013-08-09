package io.github.christiangaertner.botcafe.voice;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author Christian
 */
public class GoogleVoice {

    // Essential, otherwise Google will throw a 403
    static {
        System.setProperty("http.agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.7; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
    }

    /**
     * The languages avaible (for this class only!)
     */
    public enum Lang {

        /**
         * Deutsch - de - German
         */
        GERMAN("de"),
        /**
         * English - en - British English
         */
        ENGLISH("en"),
        /**
         * English - en_us - American English
         */
        US("en_us");
        /**
         * The language selected
         */
        private String lang;
        
        /**
         * Constructor.
         * @param l (The language string)
         */
        private Lang(String l) {
            lang = l;
        }

        /**
         * Returns the language string
         * @return
         */
        public String get() {
            return lang;
        }
    }
    private static final int MAX_TXT_LENGTH = 100;
    private static final String GOOGLE_URL = "http://translate.google.com/translate_tts?tl=%lang%&q=%txt%";
    private final Lang lang;

    /**
     * Constructor.
     * @param l (The language string)
     */
    public GoogleVoice(Lang l) {
        lang = l;
    }

    /**
     * Plays the given text out loud.
     * @uses playText
     * @param txt
     */
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
    
    /**
     * Downloads audio and plays it
     * @param txt 
     */
    private void playText(String txt) {
        try {
            URLConnection con = makeUrl(txt).openConnection();
            InputStream is = con.getInputStream();

            Player pl = new Player(is);
            pl.play();

        } catch (IOException ex) {
            System.err.println("Error with GoogleVoice (URL): " + ex.getMessage());
        } catch (JavaLayerException ex) {
            System.err.println("Error with GoogleVoice (Player): " + ex.getMessage());
        }

    }
    
    /**
     * Encodes and converts a string to an URL object
     * @param txt
     * @return The new URL object
     */
    private URL makeUrl(String txt) {
        try {
            txt = URLEncoder.encode(txt.trim(), "UTF-8");
            String url;

            url = GOOGLE_URL.replace("%lang%", lang.get());
            url = url.replace("%txt%", txt);

            return new URL(url);

        } catch (MalformedURLException ex) {
            System.err.println("Error with GoogleVoice (URL): " + ex.getMessage());
            return null;
        } catch (UnsupportedEncodingException ex) {
            System.err.println("Error with GoogleVoice (TXT)[" + txt + "]: " + ex.getMessage());
            return null;
        }
    }
    
    /**
     * Splits large Strings into a smaller pieces of MAX_TXT_LENGTH
     * @param txt
     * @return The chunks
     */
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
