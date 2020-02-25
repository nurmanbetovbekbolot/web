package kg.wallet.service;

import kg.wallet.dao.LogDao;
import kg.wallet.dao.UserDao;
import kg.wallet.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
public class UserService {
    private UserDao userDao = new UserDao();
    private LogDao logDao = new LogDao();
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<User> getAllUsers_Json() {
        return userDao.getUsers();
    }

    @GET()
    @Path("/{userId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public User getUser(@PathParam("userId") Integer userId) {
        return userDao.getUserById(userId);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String createUser(User user) throws Exception {
        logDao.createLog(user);
        if (user.getYearOfBirth() <= 2000) {
            if (user.getGender().equals("m")) {
                userDao.createUser(user);

                return "Уважаемый " + user.getName() + ", ваш год рождения " + user.getYearOfBirth() + ", вам " + user.getAge() + " лет";
            } else if (user.getGender().equals("f")) {
                userDao.createUser(user);
                return "Уважаемая " + user.getName() + ", ваш год рождения " + user.getYearOfBirth() + ", вам " + user.getAge() + " лет";
            }
        } else{
            throw new Exception("Not Available");}
        return null;
    }

    @DELETE
    @Path("/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteUser(@PathParam("userId") Integer userId) {
        userDao.deleteUserById(userId);
    }

}
