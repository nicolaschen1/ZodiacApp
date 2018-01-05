/***
 * Author: Nicolas Chen
 * ZodiacApp
 * Version 1.0
***/

package zodiac.sign;

import java.util.ArrayList;

public class ZodiacSign {

	public static ArrayList<String> getZodiac(int day, int month, int year) {
		String sign="";
		String element="";
		String chineseSign="";
		ArrayList<String> allZodiac = new ArrayList<String>();

		if((month == 1) && (day <= 20) || (month == 12) && (day >= 22)) {
			sign = "Capricorn";
		} else if((month == 1) || (month == 2) && (day <= 19)) {
			sign = "Aquarius";
		} else if((month == 2) || (month == 3) && (day <= 20)) {
			sign = "Pisces";
		} else if((month == 3) || (month == 4) && (day <= 19)) {
			sign = "Aries";
		} else if((month == 4) || (month == 5) && (day <= 21)) {
			sign = "Taurus";
		} else if((month == 5) || (month == 6) && (day <= 21)) {
			sign = "Gemini";
		} else if((month == 6) || (month == 7) && (day <= 23)) {
			sign = "Cancer";
		} else if((month == 7) || (month == 8) && (day <= 23)) {
			sign = "Leo";
		} else if((month == 8) || (month == 9) && (day <= 23)) {
			sign = "Virgo";
		} else if((month == 9) || (month == 10) && (day <= 23)) {
			sign = "Libra";
		} else if((month == 10) || (month == 11) && (day <= 22)) {
			sign = "Scorpio";
		} else if(month == 12) {
			sign = "Sagittarius";
		}
		else {
			return allZodiac;
		}

		if((sign.equals("Aries"))||(sign.equals("Leo"))||(sign.equals("Sagittarius"))){
			element="Fire";
		}
		else if((sign.equals("Taurus"))||(sign.equals("Virgo"))||(sign.equals("Capricorn"))){
			element="Earth";
		}
		else if((sign.equals("Gemini"))||(sign.equals("Libra"))||(sign.equals("Aquarius"))){
			element="Air";
		}
		else if((sign.equals("Cancer"))||(sign.equals("Scorpio"))||(sign.equals("Pisces"))){
			element="Water";
		}

		int x = (1997 - year) % 12;

		if ((x == 1) || (x == -11)){
			chineseSign="Rat";
		}
		else{
			if (x == 0){
				chineseSign="Ox";
			}
			else{
				if ((x == 11) || (x == -1)){
					chineseSign="Tiger";
				}
				else{
					if ((x == 10) || (x == -2)){
						chineseSign="Rabbit";
					}
					else{
						if ((x == 9) || (x == -3)){
							chineseSign="Dragon";
						}
						else{
							if ((x == 8) || (x == -4)){
								chineseSign="Snake";
							}
							else{
								if ((x == 7) || (x == -5)){
									chineseSign="Horse";
								}
								else{
									if ((x == 6) || (x == -6)){
										chineseSign="Goat";
									}
									else{
										if ((x == 5) || (x == -7)){
											chineseSign="Monkey";
										}
										else{
											if ((x == 4) || (x == -8)){
												chineseSign="Rooster";
											}
											else{
												if ((x == 3) || (x == -9)){
													chineseSign="Dog";
												}
												else{
													if ((x == 2) || (x == -10)){
														chineseSign="Pig";
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		allZodiac.add(sign);
		allZodiac.add(chineseSign);
		allZodiac.add(element);

		return allZodiac;
	}
}
