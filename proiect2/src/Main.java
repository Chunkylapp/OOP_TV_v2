import input.ActionsInput;
import input.InputParser;
import input.MovieInput;
import input.UserInput;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import database.DataBase;
import movie.Movie;
import pages.HomePageNotAuthenticated;
import pages.Login;
import pages.Movies;
import pages.Register;
import user.UserFactory;
import user.UserInterface;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Main {

    private Main() {
        // empty constructor
    }

    public static void main(String[] args) throws IOException {
        DataBase dataBase = new DataBase();
        dataBase.setCurrentUser(null);
        dataBase.setCurrentPage(HomePageNotAuthenticated.getInstance());

        ObjectMapper mapper = new ObjectMapper();
        ArrayNode arrayNode = mapper.createArrayNode();
        InputParser inputParser = mapper.readValue(new File(args[0]), InputParser.class);

        for (UserInput userInput : inputParser.getUsers()) {
            UserInterface user = UserFactory.getUser(userInput);
            if (user != null) {
                dataBase.getUsers().add(user);
            }
        }

        for (MovieInput movieInput : inputParser.getMovies()) {
            Movie movie = new Movie(movieInput.getName(), movieInput.getYear(),
                    movieInput.getDuration(), movieInput.getGenres(), movieInput.getActors(),
                    movieInput.getCountriesBanned());
            dataBase.getMovies().add(movie);
        }

        for (ActionsInput action : inputParser.getActions()) {
            ObjectNode out = null;
            switch (action.getType()) {
                case "change page":
                    if (Objects.requireNonNull(dataBase.getCurrentPage()).
                            getName().equals("Homepage neautentificat")
                            || dataBase.getCurrentPage().getName().equals("login")
                            || dataBase.getCurrentPage().getName().equals("register")) {
                        switch (action.getPage()) {
                            case "login" -> dataBase.setCurrentPage(Login.getInstance());
                            case "register" -> dataBase.setCurrentPage(Register.getInstance());
                            default -> {
                                out = mapper.createObjectNode();
                                out.put("error", "Error");
                                out.put("currentMoviesList", mapper.createArrayNode());
                                out.put("currentUser", (String) null);
                            }
                        }
                        break;
                    }
                    if (dataBase.getCurrentPage().getName().equals("Homepage autentificat")) {
                        if (!(action.getPage().equals("movies")
                                || action.getPage().equals("upgrades")
                                || action.getPage().equals("logout"))) {
                            out = mapper.createObjectNode();
                            out.put("error", "Error");
                            out.put("currentMoviesList", mapper.createArrayNode());
                            out.put("currentUser", (String) null);
                            break;
                        }
                        switch (action.getPage()) {
                            case "movies" -> {
                                dataBase.setCurrentPage(Movies.getInstance());
                                ArrayNode movies = mapper.createArrayNode();
                                dataBase.setCurrentMovies(dataBase.getMovies());
                                for (Movie movie : dataBase.getMovies()) {
                                    if (movie.getCountriesBanned().
                                            contains(dataBase.getCurrentUser().getCountry())) {
                                        continue;
                                    }
                                    movies.add(movie.getJson());
                                }
                                out = mapper.createObjectNode();
                                out.put("error", (String) null);
                                out.put("currentMoviesList", movies); //movies
                                out.put("currentUser",
                                        dataBase.getCurrentUser().getJson());
                            }
                            case "upgrades" -> {
                                dataBase.setCurrentMovies(dataBase.getMovies());
                                dataBase.setCurrentPage(pages.Upgrades.getInstance());
                            }
                            case "logout" -> {
                                dataBase.setCurrentMovies(dataBase.getMovies());
                                dataBase.setCurrentPage(HomePageNotAuthenticated.getInstance());
                                dataBase.setCurrentUser(null);
                            }
                        }
                        break;
                    }
                    if (dataBase.getCurrentPage().getName().equals("movies")) {
                        if (!(action.getPage().equals("Homepage autentificat")
                                || action.getPage().equals("see details")
                                || action.getPage().equals("logout")
                                || action.getPage().equals("upgrades")
                                || action.getPage().equals("movies"))) {
                            out = mapper.createObjectNode();
                            out.put("error", "Error");
                            out.put("currentMoviesList", mapper.createArrayNode());
                            out.put("currentUser", (String) null);
                            break;
                        }
                        switch (action.getPage()) {
                            case "Homepage autentificat" -> {
                                dataBase.setCurrentMovies(dataBase.getMovies());
                                dataBase.setCurrentPage(pages.HomePageAuthenticated.getInstance());
                                out = mapper.createObjectNode();
                                out.put("error", (String) null);
                                out.put("currentMoviesList", mapper.createArrayNode());
                                out.put("currentUser", (String) null);
                            }
                            case "movies" -> {
                                dataBase.setCurrentPage(Movies.getInstance());
                                ArrayNode movies = mapper.createArrayNode();
                                dataBase.setCurrentMovies(dataBase.getMovies());
                                for (Movie movie : dataBase.getMovies()) {
                                    if (movie.getCountriesBanned().
                                            contains(dataBase.getCurrentUser().getCountry())) {
                                        continue;
                                    }
                                    movies.add(movie.getJson());
                                }
                                out = mapper.createObjectNode();
                                out.put("error", (String) null);
                                out.put("currentMoviesList", movies); //movies
                                out.put("currentUser", dataBase.getCurrentUser().getJson());
                            }
                            case "see details" -> {
                                Movie movie = null;
                                for (Movie movieIterator : dataBase.getCurrentMovies()) {
                                    if (movieIterator.getName().equals(action.getMovie())) {
                                        movie = movieIterator;
                                        break;
                                    }
                                }
                                if (movie == null) {
                                    out = mapper.createObjectNode();
                                    out.put("error", "Error");
                                    out.put("currentMoviesList", mapper.createArrayNode());
                                    out.put("currentUser", (String) null);
                                    break;
                                }
                                if (movie.getCountriesBanned().
                                        contains(dataBase.getCurrentUser().getCountry())) {
                                    out = mapper.createObjectNode();
                                    out.put("error", "Error");
                                    out.put("currentMoviesList", mapper.createArrayNode());
                                    out.put("currentUser", (String) null);
                                    break;
                                }
                                dataBase.setCurrentPage(pages.SeeDetails.getInstance());
                                out = mapper.createObjectNode();
                                out.put("error", (String) null);
                                out.put("currentMoviesList",
                                        mapper.createArrayNode().add(movie.getJson()));
                                out.put("currentUser", dataBase.getCurrentUser().getJson());
                                dataBase.setCurrentMovie(action.getMovie());
                            }
                            case "upgrades" -> {
                                dataBase.setCurrentMovies(dataBase.getMovies());
                                dataBase.setCurrentPage(pages.Upgrades.getInstance());
                            }
                            case "logout" -> {
                                dataBase.setCurrentMovies(dataBase.getMovies());
                                dataBase.setCurrentPage(HomePageNotAuthenticated.getInstance());
                                dataBase.setCurrentUser(null);
                            }
                        }
                        break;
                    }
                    if (dataBase.getCurrentPage().getName().equals("upgrades")) {
                        if (!(action.getPage().equals("Homepage autentificat")
                                || action.getPage().equals("movies")
                                || action.getPage().equals("logout")
                                || action.getPage().equals("movies"))) {
                            out = mapper.createObjectNode();
                            out.put("error", "Error");
                            out.put("currentMoviesList", mapper.createArrayNode());
                            out.put("currentUser", (String) null);
                            break;
                        }
                        switch (action.getPage()) {
                            case "Homepage autentificat" -> {
                                dataBase.setCurrentMovies(dataBase.getMovies());
                                dataBase.setCurrentPage(pages.HomePageAuthenticated.getInstance());
                                out = mapper.createObjectNode();
                                out.put("error", (String) null);
                                out.put("currentMoviesList", mapper.createArrayNode());
                                out.put("currentUser", (String) null);
                            }
                            case "movies" -> {
                                dataBase.setCurrentPage(pages.Movies.getInstance());
                                ArrayNode movies = mapper.createArrayNode();
                                dataBase.setCurrentMovies(dataBase.getMovies());
                                for (Movie movie : dataBase.getMovies()) {
                                    if (movie.getCountriesBanned().
                                            contains(dataBase.getCurrentUser().getCountry())) {
                                        continue;
                                    }
                                    movies.add(movie.getJson());
                                }
                                out = mapper.createObjectNode();
                                out.put("error", (String) null);
                                out.put("currentMoviesList", movies); //movies
                                out.put("currentUser", dataBase.getCurrentUser().getJson());
                            }
                            case "logout" -> {
                                dataBase.setCurrentMovies(dataBase.getMovies());
                                dataBase.setCurrentPage(HomePageNotAuthenticated.getInstance());
                                dataBase.setCurrentUser(null);
                            }
                        }
                    }
                    if (dataBase.getCurrentPage().getName().equals("see details")) {
                        if (!(action.getPage().equals("Homepage autentificat")
                                || action.getPage().equals("movies")
                                || action.getPage().equals("logout")
                                || action.getPage().equals("upgrades")
                                || action.getPage().equals("movies"))) {
                            out = mapper.createObjectNode();
                            out.put("error", "Error");
                            out.put("currentMoviesList", mapper.createArrayNode());
                            out.put("currentUser", (String) null);
                            break;
                        }
                        switch (action.getPage()) {
                            case "Homepage autentificat" -> {
                                dataBase.setCurrentPage(pages.HomePageAuthenticated.getInstance());
                                out = mapper.createObjectNode();
                                out.put("error", (String) null);
                                out.put("currentMoviesList", mapper.createArrayNode());
                                out.put("currentUser", (String) null);
                            }
                            case "movies" -> {
                                dataBase.setCurrentPage(Movies.getInstance());
                                ArrayNode movies = mapper.createArrayNode();
                                dataBase.setCurrentMovies(dataBase.getMovies());
                                for (Movie movie : dataBase.getMovies()) {
                                    if (movie.getCountriesBanned().
                                            contains(dataBase.getCurrentUser().getCountry())) {
                                        continue;
                                    }
                                    movies.add(movie.getJson());
                                }
                                out = mapper.createObjectNode();
                                out.put("error", (String) null);
                                out.put("currentMoviesList", movies); //movies
                                out.put("currentUser", dataBase.getCurrentUser().getJson());
                            }
                            case "upgrades" -> {
                                dataBase.setCurrentMovies(dataBase.getMovies());
                                dataBase.setCurrentPage(pages.Upgrades.getInstance());
                            }
                            case "logout" -> {
                                dataBase.setCurrentMovies(dataBase.getMovies());
                                dataBase.setCurrentPage(HomePageNotAuthenticated.getInstance());
                                dataBase.setCurrentUser(null);
                            }
                        }
                        break;

                    }
                case "on page":
                    if (action.getFeature().equals("login")) {
                        if (!dataBase.getCurrentPage().getName().equals("login")) {
                            out = mapper.createObjectNode();
                            out.put("error", "Error");
                            out.put("currentMoviesList", mapper.createArrayNode());
                            out.put("currentUser", (String) null);
                            break;
                        }
                        out = dataBase.getCurrentPage().action(action, dataBase);
                        break;
                    }
                    if (action.getFeature().equals("register")) {
                        if (!(dataBase.getCurrentPage().getName().equals("register"))) {
                            out = mapper.createObjectNode();
                            out.put("error", "Error");
                            out.put("currentMoviesList", mapper.createArrayNode());
                            out.put("currentUser", (String) null);
                            break;
                        }
                        out = dataBase.getCurrentPage().action(action, dataBase);
                        break;
                    }
                    if (action.getFeature().equals("logout")) {
                        if (!dataBase.getCurrentPage().getName().equals("logout")) {
                            out = mapper.createObjectNode();
                            out.put("error", "Error");
                            out.put("currentMoviesList", mapper.createArrayNode());
                            out.put("currentUser", (String) null);
                            break;
                        }
                        out = dataBase.getCurrentPage().action(action, dataBase);
                        dataBase.clearStack();
                        dataBase.setCurrentPage(HomePageNotAuthenticated.getInstance());
                        dataBase.setCurrentUser(null);
                        dataBase.setMovies(new ArrayList<>());
                        dataBase.setUsers(new ArrayList<>());
                        break;
                    }
                    if (action.getFeature().equals("search")
                            || action.getFeature().equals("filter")) {
                        out = mapper.createObjectNode();
                        if (!dataBase.getCurrentPage().getName().equals("movies")) {
                            out.put("error", "Error");
                            out.put("currentMoviesList", mapper.createArrayNode());
                            out.put("currentUser", (String) null);
                            break;
                        }
                        out.put("error", (String) null);
                        out.put("currentMoviesList",
                                dataBase.getCurrentPage().
                                        action(action, dataBase).get("currentMoviesList"));
                        out.put("currentUser", dataBase.getCurrentUser().getJson());

                        break;
                    }
                    if (action.getFeature().equals("buy tokens")
                            || action.getFeature().equals("buy premium account")) {
                        if (!dataBase.getCurrentPage().getName().equals("upgrades")) {
                            out = mapper.createObjectNode();
                            out.put("error", "Error");
                            out.put("currentMoviesList", mapper.createArrayNode());
                            out.put("currentUser", (String) null);
                            break;
                        }
                        dataBase.getCurrentPage().action(action, dataBase);
                        break;
                    }
                    if (action.getFeature().equals("purchase")
                            || action.getFeature().equals("watch")
                            || action.getFeature().equals("like")
                            || action.getFeature().equals("rate")) {
                        if (!dataBase.getCurrentPage().getName().equals("see details")) {
                            out = mapper.createObjectNode();
                            out.put("error", "Error");
                            out.put("currentMoviesList", mapper.createArrayNode());
                            out.put("currentUser", (String) null);
                            break;
                        }
                        boolean flag = false;
                        for (Movie movie : dataBase.getCurrentUser().getPurchasedMovies()) {
                            if (movie.getName().equals(action.getMovie()) || movie.getName().equals(dataBase.getCurrentMovie()))
                                flag = true;
                        }
                        if (!flag && !(action.getFeature().equals("purchase"))) {
                            out = mapper.createObjectNode();
                            out.put("error", "Error");
                            out.put("currentMoviesList", mapper.createArrayNode());
                            out.put("currentUser", (String) null);
                            break;
                        }
                        if (action.getRate() < 0 || action.getRate() > 5) {
                            out = mapper.createObjectNode();
                            out.put("error", "Error");
                            out.put("currentMoviesList", mapper.createArrayNode());
                            out.put("currentUser", (String) null);
                            break;
                        }
                        ObjectNode foo = dataBase.getCurrentPage().action(action, dataBase);
                        out = mapper.createObjectNode();
                        out.put("error", (String) null);
                        out.put("currentMoviesList", foo.get("currentMoviesList"));
                        out.put("currentUser", dataBase.getCurrentUser().getJson());
                        dataBase.setCurrentPage(pages.SeeDetails.getInstance());
                        break;
                    }
                case "back":
                    if (dataBase.stackNull() || dataBase.getCurrentPage().getName().equals("Homepage autentificat")) {
                        out = mapper.createObjectNode();
                        out.put("error", "Error");
                        out.put("currentMoviesList", mapper.createArrayNode());
                        out.put("currentUser", (String) null);
                        break;
                    }
                    dataBase.setCurrentPage(dataBase.getPreviousPage());
                    break;
                    
            }
            if (out != null) {
                arrayNode.add(out);
            }
            ObjectWriter objectWriter = mapper.writerWithDefaultPrettyPrinter();
            if(args[0].contains("basic_1.json"))
                objectWriter.writeValue(new File("basic_1.json"), arrayNode);
            objectWriter.writeValue(new File(args[1]), arrayNode);
        }
    }

}
