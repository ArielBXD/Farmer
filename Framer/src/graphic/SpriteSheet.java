package graphic;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private BufferedImage sheet;

	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}

	public BufferedImage getSprite(int x, int y) {
		return sheet.getSubimage(x * 128 - 128, y * 128 - 128, 128, 128);
	}
}
