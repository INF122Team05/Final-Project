import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Block {
	private int length;
	private int width;
	private BufferedImage blockImage;
	private int row;
	private int col;
	private int id;

	public Block(){
	}

	public void setLength(int length){
		this.length = length;
	}
	public void setWidth(int width){
		this.width = width;
	}
	public void setImage(){
		Random rand = new Random();
		try {                
			File dir = new File("src/assets/bejeweled");
			File[] directoryListing = dir.listFiles();
			this.id = rand.nextInt(directoryListing.length);
	      //  this.blockImage = ImageIO.read(new File("src/assets/bejeweled/blue_gem.png"));
		 	this.blockImage = ImageIO.read(directoryListing[this.id]);
	       } catch (IOException ex) {
	            // handle exception...
	       }
	}
	public void setRow(int row){
		this.row = row;
	}
	public void setCol(int col){
		this.col = col;
	}


	public int getLength(){
		return this.length;
	}
	public int getWidth(){
		return this.width;
	}
	public BufferedImage getBlockImage(){
		return this.blockImage;
	}
	public int getRow(){
		return this.row;
	}
	public int getCol(){
		return this.col;
	}
}
