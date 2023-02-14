package ds.spring.gradle.restful;

import com.alibaba.fastjson.JSON;
import ds.spring.gradle.restful.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.mx.service.rest.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("home")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
public class HomeResource {

    @Autowired
    private Environment env = null;

    @Path("get")
    @GET
    public DataVO<String> get() {
        log.warn(env.getProperty("restful.port"));
        return new DataVO<>("get data.");
    }

    @Path("postData")
    @POST
    public DataVO<String> postData(String data) {
        return new DataVO<>(String.format("post data: %s.", data));
    }

    @Path("postJSON")
    @POST
    public DataVO<String> postJSON(UserVO userVO) {
        log.warn("username : " + userVO.getUsername());
        return new DataVO<>(String.format("post data: %s.", JSON.toJSONString(userVO)));
    }
}
