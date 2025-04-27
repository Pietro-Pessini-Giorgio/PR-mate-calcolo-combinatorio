import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;


public class Main {
    public static void main(String[] args){
        Font sizedFont,sizedFont2,sizedFont3;
        try {
            InputStream is = Main.class.getResourceAsStream("VT323\\VT323-Regular.ttf");
            Font pixelFont = Font.createFont(Font.TRUETYPE_FONT, is);
            sizedFont = pixelFont.deriveFont(25f);
            sizedFont2 = pixelFont.deriveFont(18f);
            sizedFont3 = pixelFont.deriveFont(15f);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            sizedFont = new Font(Font.MONOSPACED, Font.PLAIN, 25);
            sizedFont2 = new Font(Font.MONOSPACED, Font.PLAIN, 18);
            sizedFont3 = new Font(Font.MONOSPACED, Font.PLAIN, 15);
        }
        Mainframe APP= new Mainframe(sizedFont,sizedFont2,sizedFont3);
    }
}
