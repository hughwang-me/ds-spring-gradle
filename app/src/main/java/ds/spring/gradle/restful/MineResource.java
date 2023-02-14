package ds.spring.gradle.restful;

import lombok.extern.slf4j.Slf4j;
import org.mx.service.rest.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("mine")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
public class MineResource {

    @Autowired
    private Environment env = null;

    @Path("get")
    @GET
    public DataVO<String> get() {
        log.warn(env.getProperty("restful.port"));
        return new DataVO<>("mine get data.");
    }
}
