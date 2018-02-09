package shoestore;

public enum RatingEnum 
{
	TOTAL_DISASTER(1),
	NOT_BAD(2),
	OK(3),
	GREAT(4);
	
	private int value;
	
	private RatingEnum(int value)
	{
		this.value = value;
	}
	

}
