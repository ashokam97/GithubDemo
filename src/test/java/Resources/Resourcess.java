package Resources;

import java.util.ArrayList;
import Pojo.AddPlace;
import Pojo.Location;

public class Resourcess {

	public AddPlace testdata(String name, String Address) {
	 AddPlace Add=new AddPlace();
	 Add.setAccuracy(20);
	 Add.setAddress(Address);
	 Add.setLanguage("Kannada");
	 Location Loc1=new Location();
	 Loc1.setLat(-38.383494);
	 Loc1.setLng(33.427362);
	 Add.setLocation(Loc1);
	 ArrayList<String> list=new ArrayList<>();
	 list.add("shoe park");
	 list.add("shop");
	 Add.setTypes(list);
	 Add.setName(name);
	 Add.setPhone_number("(+91) 983 893 3937");
	 Add.setWebsite("www.testingwebsite.com");
	 return Add;
	}

}
