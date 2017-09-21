package urm;

import java.awt.*;
import javax.swing.ImageIcon;

public class Splash extends Window {
    Image splashImage;
    Toolkit toolkit;
    private static Splash splash = null;
    ImageIcon icone;

    static {
        splash = new Splash();
    }

    private Splash() {
        super(new Frame());
        setVisible(false);
        icone = new ImageIcon(getClass().getResource("../imagem/inicio.png"));

        splashImage = null;
        toolkit = Toolkit.getDefaultToolkit();
    }

    public static Splash getInstance() {
        return splash;
    }

    /**
     * Method initSplash.
     */
    private void initSplash() {
        // Carrega a imagem na memoria
        MediaTracker media = new MediaTracker(this);
        splashImage = icone.getImage();
        //                toolkit.getImage(getClass().getResource("info.png"));

        if (splashImage != null) {
            media.addImage(splashImage, 0);

            try {
                media.waitForID(0);
            } catch (InterruptedException ie) {
            }
        }

        // Configura o tamanho do splash e a posicao na tela
        setSize(splashImage.getWidth(this), splashImage.getHeight(this));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension size = getSize();

        if (size.width > screenSize.width) {
            size.width = screenSize.width;
        }

        if (size.height > screenSize.height) {
            size.height = screenSize.height;
        }

        setLocation((screenSize.width - size.width) / 2, (screenSize.height - size.height) / 2);
        setVisible(true);
    }

    public void openSplash() {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        initSplash();
    }

    public void finish() {
        setVisible(false);
        dispose();
    }

    @Override
    public void paint(Graphics g) {
        // Apenas desenha a nossa mensagem na imagem
        g.drawImage(splashImage, 0, 0, getBackground(), this);
        g.setFont(new Font("Time new roma", Font.PLAIN, 26));
	//g.drawString("Muatsoft Developer", (int)(splashImage.getWidth(this) / 2) - 10, 30);
    }
}
