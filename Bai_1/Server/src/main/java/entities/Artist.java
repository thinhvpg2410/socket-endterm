package entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "artists")
public class Artist implements Serializable {
	private static final long serialVersionUID = -152269388788828458L;

	@Id
	@Column(name = "artist_id")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	private String name;
	
	@Column(name = "birth_date")
	private LocalDate birthDate;
	private String url;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "albums_artists", joinColumns = @JoinColumn(name = "artist_id"), inverseJoinColumns = @JoinColumn(name = "album_id"))
	private Set<Album> album = new HashSet<Album>();

	public Artist() {
		
	}

	public Artist(String id, String name, LocalDate birthDate, String url, Set<Album> album) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.url = url;
		this.album = album;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Set<Album> getAlbum() {
		return album;
	}

	public void setAlbum(Set<Album> album) {
		this.album = album;
	}

	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", url=" + url + ", album=" + album
				+ "]";
	}
	
	
	
}
