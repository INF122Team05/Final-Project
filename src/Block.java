import java.awt.image.BufferedImage;

public class Block {
	private String color;
	private int length;
	private int width;
	private BufferedImage blockImage;
	private int row;
	private int col;

	public Block(String color, int length, int width, BufferedImage blockImage, int row, int col){
		this.color = color;
		this.length = length;
		this.width = width;
		this.blockImage = blockImage;
		this.row = row;
		this.col = col;
	}

	public void setColor(String color){
		this.color = color;
	}

	public void setLength(int length){
		this.length = length;
	}
	public void setWidth(int width){
		this.width = width;
	}
	public void setImage(BufferedImage blockImage){
		this.blockImage = blockImage;
	}
	public void setRow(int row){
		this.row = row;
	}
	public void setCol(int col){
		this.col = col;
	}

	public String getColor(){
		return this.color;
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
