package ds.spring.gradle.restful;

import com.alibaba.fastjson.JSON;
import ds.spring.gradle.restful.vo.UserVO;
import ds.spring.gradle.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.mx.service.rest.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.ws.rs.*;
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

    @Path("addUser")
    @POST
    public DataVO<String> addUser(UserVO userVO) {
        return new DataVO<>("mine get data." + userService.addUser(userVO));
    }
}
