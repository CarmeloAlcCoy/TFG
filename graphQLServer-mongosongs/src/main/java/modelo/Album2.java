package modelo;

import java.util.List;

public class Album2 extends SuperAlbum {

	private List<String> availabitlity;
	private String genre;

	public Album2(String name, List<String> formats, int releaseYear, List<String> tracks, List<String> availabitlity,
			String genre) {
		super(name, formats, releaseYear, tracks);
		this.availabitlity=availabitlity;
		this.genre=genre;
	}

	public List<String> getAvailabitlity() {
		return availabitlity;
	}

	public void setAvailabitlity(List<String> availabitlity) {
		this.availabitlity = availabitlity;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	

}