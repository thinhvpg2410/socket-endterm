package entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "albums")
public class Album implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "album_id")
    private String id;
    private String title;
    private double price;
    private int yearOfRelease;
    private String downloadLink;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "albums_artists", joinColumns = @JoinColumn(name = "album_id"), inverseJoinColumns = @JoinColumn(name = "artist_id"))
    private Set<Artist> artists = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "albums_songs", joinColumns = @JoinColumn(name = "album_id"), inverseJoinColumns = @JoinColumn(name = "song_id"))
    private Set<Song> songs = new HashSet<Song>();
    public Album(String id, String title, double price, int yearOfRelease, String downloadLink, Genre genre,
                 Set<Artist> artists, Set<Song> songs) {
        super();
        this.id = id;
        this.title = title;
        this.price = price;
        this.yearOfRelease = yearOfRelease;
        this.downloadLink = downloadLink;
        this.genre = genre;
        this.artists = artists;
        this.songs = songs;
    }

    public Album() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Set<Artist> getArtists() {
        return artists;
    }

    public void setArtists(Set<Artist> artists) {
        this.artists = artists;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", yearOfRelease=" + yearOfRelease +
                ", downloadLink='" + downloadLink + '\'' +
                ", genre=" + genre +
                ", artists=" + artists +
                ", songs=" + songs +
                '}';
    }
}
