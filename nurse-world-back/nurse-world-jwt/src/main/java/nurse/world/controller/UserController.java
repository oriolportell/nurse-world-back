package nurse.world.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import nurse.world.model.User;
import nurse.world.service.UserService;

@ApplicationScoped
@Path("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GET
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response logUser(User user){
        String jwt = userService.generateJWT(user);
        return Response.ok(jwt).build();
    }
    @GET
    @Path("register")
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerUser(User user){
        User userRegister = userService.registerUser(user);
        return Response.ok(userRegister).build();
    }
}
