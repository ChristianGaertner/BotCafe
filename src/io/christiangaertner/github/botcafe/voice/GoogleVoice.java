package io.christiangaertner.github.botcafe.voice;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
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

    static {
        System.setProperty("http.agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.7; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
    }

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
