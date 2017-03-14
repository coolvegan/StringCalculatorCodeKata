public class StringCalculator {
	String delimiter;
	
	public StringCalculator()
	{
		setDelimiter(",");
	}
	
	void setDelimiter(String delimiter)
	{
		this.delimiter = delimiter;
	}
	
	String getDelimiter()
	{
		return this.delimiter;
	}
	
	int Add(String numbers)
	{
		String myNumbers = "0123456789";
		for (int i = 0; i < numbers.length(); i++) {
			if (numbers.charAt(i) == '-')
			{
				if (myNumbers.indexOf(numbers.charAt(i+1)) > 0)
				{
					throw new IllegalArgumentException("Negative Eingabeparameter sind nicht erlaubt!");
				}
			}
		}
		
		if ((numbers.length() > 4) && numbers.charAt(1) == '\n')
		{
			if (myNumbers.indexOf(numbers.charAt(0)) < 0)
			{
				setDelimiter(numbers.charAt(0)+"\n");
			}
		}
		numbers = numbers.replace("\n", this.getDelimiter());
		int sum = 0;
		String tmp = "";
		for (int i = 0; i < numbers.length(); i++) {	
			if (myNumbers.indexOf(numbers.charAt(i)) >= 0)
			{
				tmp += numbers.charAt(i);
			}			
			if ((numbers.charAt(i) == this.getDelimiter().charAt(0)) || (i >= numbers.length()-1)) {
				if (tmp.length() > 0)
				{
					sum+=Integer.parseInt(tmp);
				}
				tmp = "";				
			}
		}
		return sum;
	}
}
