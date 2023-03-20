package data;

import java.util.Comparator;

public class UserNameCheck implements Comparator<UserRegister>{

	@Override
	public int compare(UserRegister o1, UserRegister o2) {
		// TODO Auto-generated method stub
		return o1.username.compareTo(o2.username);
	}
	
	

}
