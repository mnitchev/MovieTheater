package stoKina.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "validateUser", query = "SELECT u FROM User u WHERE u.userName=:userName AND u.password=:password"),
    @NamedQuery(name = "getAllUsers", query = "SELECT u FROM User u"),
    @NamedQuery(name = "findByUserName", query = "SELECT u FROM User u WHERE u.userName=:userName"),
    @NamedQuery(name = "findById", query = "SELECT u FROM User u WHERE u.id=:id"),
    @NamedQuery(name = "getMoviesForUser", query = "SELECT u FROM User u WHERE u.userName=:userName")})
public class User implements Serializable{
    
	private static final long serialVersionUID = -1499972552436486091L;
	public static final String ADMINISTRATOR = "administrator";
	public static final String STAFF = "staff";
	public static final String USER = "user";
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String userName;
	private String password;
	private String email;
	private String role;

   // @OneToMany
   // private Set<Ticket> paidTickets = new HashSet<>();
   // @OneToMany
   // private Set<Movie> paidForMovies = new HashSet<>();

	public User() {
    }

    public User(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.role = USER;
    }
    
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.email = "";
        this.role = USER;
    }
    
    public User(String userName, String password, String email, String role) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.role = role;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   // public Set<Ticket> getPaidTickets() {
		//return paidTickets;
	//}

	//public void setPaidTickets(Set<Ticket> paidTickets) {
	//	this.paidTickets = paidTickets;
	//}
//	public Set<Movie> getPaidForMovies() {
//		return paidForMovies;
//	}
//
//	public void setPaidForMovies(Set<Movie> paidForMovies) {
//		this.paidForMovies = paidForMovies;
//	}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" ");
        if (userName != null && !userName.trim().isEmpty())
            sb.append("userName: ");
         	sb.append(userName);
        if (password != null && !password.trim().isEmpty())
            sb.append(", password: ");
        	sb.append(password);
        if (email != null && !email.trim().isEmpty())
            sb.append(", email: ");
        	sb.append(email);
//        for (Movie m : getPaidForMovies()) {
//			sb.append(m.toString());
//			sb.append(" ");
/*//		}
        for (Ticket t : getPaidTickets()) {
			sb.append(t.toString());
			sb.append(" ");
		}*/
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User other = (User) obj;
        if (id != null) {
            if (!id.equals(other.id)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
