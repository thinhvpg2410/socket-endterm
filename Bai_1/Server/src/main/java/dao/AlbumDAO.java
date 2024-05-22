package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import entities.Album;

public interface AlbumDAO extends Remote {
	public boolean updatePriceOfAlbum(String id, double newPrice) throws RemoteException;
	public List<Album> listAlbumByGenre(String genreName) throws RemoteException;
	public Map<String, Long> getNumberofAlbumsByGenre() throws RemoteException;
}
