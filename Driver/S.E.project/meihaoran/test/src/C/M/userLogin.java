package C.M;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
public class userLogin {
	ArrayList<userLogin> book = new ArrayList<userLogin>();
	private final StringProperty id;
    private final StringProperty password;
    public userLogin() {
        this(null, null);
        book.add(new userLogin("wang","123"));
        book.add(new userLogin("hha","1234"));
    }

    /**
     * Constructor with some initial data.
     * 
     * @param firstName
     * @param lastName
     */
    public userLogin(String id, String password) {
        this.id = new SimpleStringProperty(id);
        this.password = new SimpleStringProperty(password);
    }
    
	public String getId() {
		return id.get();
	}

	public String getPassword() {
		return password.get();
	}
	
	public boolean flag(){
		for(userLogin a: book){
			if(a.getId().equals(this.getId())&&a.getPassword().endsWith(this.getPassword()))
				return true;
		}
		return true;
	}
	public void setPassword(String password){
		this.password.set(password);
	}
	public void setId(String ID){
		this.id.set(ID);
		
	}
}
