package com.movie.models;

public class Movie {

	//declaring variables
	protected int id;
	protected String name;
	protected String director;
	protected String releasedate;
	protected String casts;
	protected String genre;
	protected String poster;
	protected String duration;
	protected String trailerlink;
	protected int category;
	
	public Movie() {};
	
	//Constructor
	public Movie(int id, String name, String director, String releasedate, String casts, String genre, String poster,
			String duration, String trailerlink, int category) {
		super();
		this.id = id;
		this.name = name;
		this.director = director;
		this.releasedate = releasedate;
		this.casts = casts;
		this.genre = genre;
		this.poster = poster;
		this.duration = duration;
		this.trailerlink = trailerlink;
		this.category = category;
	}
	
	public Movie(String name, String director, String releasedate, String casts, String genre, String poster,
			String duration, String trailerlink, int category) {
		super();
		this.name = name;
		this.director = director;
		this.releasedate = releasedate;
		this.casts = casts;
		this.genre = genre;
		this.poster = poster;
		this.duration = duration;
		this.trailerlink = trailerlink;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getReleasedate() {
		return releasedate;
	}

	public void setReleasedate(String releasedate) {
		this.releasedate = releasedate;
	}

	public String getCasts() {
		return casts;
	}

	public void setCasts(String casts) {
		this.casts = casts;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getTrailerlink() {
		return trailerlink;
	}

	public void setTrailerlink(String trailerlink) {
		this.trailerlink = trailerlink;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}
	
	
	
	
	
}
