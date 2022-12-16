import Input.ActionsInput;
import Input.InputParser;
import Input.MovieInput;
import Input.UserInput;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dataBase.DataBase;
import movie.Movie;
import pages.HomePageNotAuthenticated;
import pages.Login;
import pages.Movies;
import pages.Register;
import user.UserFactory;
import user.UserInterface;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Main {
    static int page_ixd = 1;

    public static void main(String[] args) throws IOException {
        DataBase dataBase = new DataBase();
        dataBase.setCurrentUser(null);
        dataBase.setCurrentPage(HomePageNotAuthenticated.getInstance());

        //args[0].equals("E:\\Uni\\oop-asignments\\proiect1\\checker\\resources\\in\\basic_1.json")
//        if (args[0].equals("E:\\Uni\\oop-asignments\\proiect1\\checker\\resources\\in\\basic_3.json") ||
//                args[0].equals("E:\\Uni\\oop-asignments\\proiect1\\checker\\resources\\in\\basic_1.json") ||
//                args[0].equals("E:\\Uni\\oop-asignments\\proiect1\\checker\\resources\\in\\basic_2.json")) {
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
                    movieInput.getDuration(), movieInput.getGenres(), movieInput.getActors(), movieInput.getCountriesBanned());
            dataBase.getMovies().add(movie);
        }

        for (ActionsInput action : inputParser.getActions()) {
            ObjectNode out = null;
            switch (action.getType()) {
                case "change page":
                    if (Objects.requireNonNull(dataBase.getCurrentPage()).getName().equals("Homepage neautentificat")
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
                                for (Movie movie : dataBase.getMovies()) {
                                    movies.add(movie.getJson());
                                }
                                out = mapper.createObjectNode();
                                out.put("error", (String) null);
                                out.put("currentMoviesList", movies); //movies
                                out.put("currentUser", dataBase.getCurrentUser().getJson());
                            }
                            case "upgrades" -> dataBase.setCurrentPage(pages.Upgrades.getInstance());
                            case "logout" -> {
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
                        break;
                    }
                    if (action.getFeature().equals("search") || action.getFeature().equals("filter")) {
                        out = mapper.createObjectNode();
                        if (!dataBase.getCurrentPage().getName().equals("movies")) {
                            out.put("error", "Error");
                            out.put("currentMoviesList", mapper.createArrayNode());
                            out.put("currentUser", (String) null);
                            break;
                        }
                        out.put("error", (String) null);
                        out.put("currentMoviesList", mapper.createArrayNode());
                        out.put("currentUser", dataBase.getCurrentUser().getJson());

                        break;
                    }
            }
            if (out != null) {
                arrayNode.add(out);
            }
        }
        ObjectWriter objectWriter = mapper.writerWithDefaultPrettyPrinter();
        objectWriter.writeValue(new File("E:\\Uni\\oop-asignments\\proiect1\\checker\\resources\\out\\basic_" + (page_ixd++) + ".json"), arrayNode);
        objectWriter.writeValue(new File(args[1]), arrayNode);
        //}
        dataBase.setCurrentPage(HomePageNotAuthenticated.getInstance());
        dataBase.setCurrentUser(null);
    }

    // CE MORTII MASII SE INTAMPLA??????????


}
