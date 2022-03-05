public class BlockClass {
	private String color;
	private int length;
	private int width;
	private Image blockImage;
	private int row;
	private int col;

	public BlockClass(String color, int length, int width, Image blockImage, int row, int col){
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
	public void setImage(Image blockImage){
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
	public Image getBlockImage(){
		return this.blockImage
	}
	public int getRow(){
		return this.row;
	}
	public int getCol(){
		return this.col;
	}
}
