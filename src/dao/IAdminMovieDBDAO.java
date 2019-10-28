package dao;

import java.util.List;

import entities.Movie;

/**
 *
 *
 * @author Gan Shyan
 */
public interface IAdminMovieDBDAO extends IMovieDBDAO {
    void delete( Movie movie);
    void insert(Movie movie);
}
