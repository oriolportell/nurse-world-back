package nurse.world;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import nurse.world.utils.AmazonJwtService;

@Path("/jwt")
@ApplicationScoped
public class NurseWorldJwtResource {
    @Inject
    private final AmazonJwtService amazonJwtService;
    public NurseWorldJwtResource(AmazonJwtService amazonJwtService) {
        this.amazonJwtService = amazonJwtService;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getJwt(){
        String jwt = amazonJwtService.generateJwt();
        return Response.ok(jwt).build();
    }
}
