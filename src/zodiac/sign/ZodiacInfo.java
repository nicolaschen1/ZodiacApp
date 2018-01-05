/***
 * Author: Nicolas Chen
 * ZodiacApp
 * Version 1.0
***/

package zodiac.sign;

public class ZodiacInfo {
	private String name, firstname, gender, zodiac, chineseZodiac, element;

	public ZodiacInfo(){}
	public ZodiacInfo(String name, String firstname, String gender, String zodiac, String chineseZodiac, String element){
		this.name = name;
		this.firstname = firstname;
		this.gender = gender;
		this.zodiac = zodiac;
		this.chineseZodiac = chineseZodiac;
		this.element = element;
	}

	public String toString(){
		String str;
		if((this.name != null || this.firstname != null) || (this.gender != null && this.zodiac != null && this.chineseZodiac != null && this.element != null)){
			str = "Your Astrological Sign \n";
			str += "Last name: " + this.name + "\n";
			str += "First name: " + this.firstname + "\n";
			str += "Gender: " + this.gender + "\n";
			str += "Element: " + this.element + "\n";
			str += "Zodiac Sign: " + this.zodiac + "\n";
			str += "Chinese Zodiac Sign: " + this.chineseZodiac + "\n";
		}
		else {
			str="Please fill correctly the fields.";
		}
		return str;
	}

	public String about(){
		String str;
		str = "Astrological Sign \n";
		str += "Version: 1.0 \n";
		str += "Developer: Nicolas Chen \n";
		return str;
	}

	public String error(){
		String str;
		str = "Error! \n";
		str += "Please fill correctly the fields.\n";
		return str;
	}
}
