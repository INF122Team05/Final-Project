package core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Block {
	private BufferedImage blockImage;
	private int id;
	private String gameName;

	public Block(String gameName){
		this.gameName = gameName;
	}
	public int getID(){
		return this.id;
	}
	public void setImage(){
		Random rand = new Random();
		try {                
		//	File dir = new File("src/assets/bejeweled");
		this.gameName = this.gameName.toLowerCase().replace(" ", "-");
			String filePath = "src/assets/"+this.gameName;
			File dir = new File(filePath);
			File[] directoryListing = dir.listFiles();
			this.id = rand.nextInt(directoryListing.length);
	      //  this.blockImage = ImageIO.read(new File("src/assets/bejeweled/blue_gem.png"));
		 	this.blockImage = ImageIO.read(directoryListing[this.id]);
	       } catch (IOException ex) {
	            // handle exception...
	       }
	}

	public BufferedImage getBlockImage(){
		return this.blockImage;
	}
}
