package databases;

import java.util.ArrayList;
import java.util.List;

import dao.IMovieDBDAO;
import entities.Movie;
import factory.MovieDBDAOFactory;

public class MovieDB {

    private static List<Movie> movieList = new ArrayList<>();

    private static MovieDB instance;

    private MovieDB(){

    }

    public static MovieDB getInstance(){
        if(instance == null){
            return new MovieDB();
        } else {
            return instance;
        }
    }


    public static IMovieDBDAO dbdao;

    public void setDbdao(String type){
        dbdao = MovieDBDAOFactory.getMovieDBDAO(type);
    }
}
