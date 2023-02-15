package ds.spring.gradle.restful;

import com.alibaba.fastjson.JSON;
import ds.spring.gradle.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.mx.service.rest.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("db")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
public class DbResource {

    private UserService userService;

    @Autowired
    public DbResource(UserService userService) {
        this.userService = userService;
    }

    @Path("listUser")
    @GET
    public DataVO<String> listUser() {
        return new DataVO<>("mine get data." + JSON.toJSONString(userService.listUser()));
    }
}
