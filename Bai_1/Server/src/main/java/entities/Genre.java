package entities;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "genres")
public class Genre implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "genre_id")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	private String name;
	private String description;
	
	@OneToMany(mappedBy = "genre",fetch = FetchType.LAZY)
	private Set<Album> albums;
	
	
	

}
