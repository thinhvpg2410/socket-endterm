package services;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.AlbumDAO;
import entities.Album;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class AlbumService implements AlbumDAO {
	private static final long serialVersionUID = -7831178543880947572L;
	
	private EntityManager entityManager;
	
	public AlbumService(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public boolean updatePriceOfAlbum(String id, double newPrice) {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			Album album = entityManager.find(Album.class, id);
			if(album != null) {
				album.setPrice(newPrice);
				entityManager.merge(album);
				transaction.commit();
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			if(transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	public List<Album> listAlbumByGenre(String genreName) {
		return entityManager.createNamedQuery("Album.ListByGenre", Album.class).getResultList();
	}
//	public List<Album> listAlbumByGenre(String genreName) {
//	    String jpql = "SELECT a FROM Album a WHERE a.genre = :genre";
//	    TypedQuery<Album> query = entityManager.createQuery(jpql, Album.class);
//	    query.setParameter("genre", genreName);
//	    return query.getResultList();
//	}
	
//	public Map<String, Long> getNumberOfAlbumsByGenre() {
//	    String jpql = "SELECT a.genre, COUNT(a) FROM Album a GROUP BY a.genre";
//	    TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
//	    List<Object[]> resultList = query.getResultList();
//
//	    Map<String, Long> numberOfAlbumsByGenre = new HashMap<String, Long>();
//	    for (Object[] result : resultList) {
//	        String genre = (String) result[0];
//	        Long count = (Long) result[1];
//	        numberOfAlbumsByGenre.put(genre, count);
//	    }
//	    return numberOfAlbumsByGenre;
//	}

	public Map<String, Long> getNumberofAlbumsByGenre() {
		// TODO Auto-generated method stub
		return null;
	}

}
