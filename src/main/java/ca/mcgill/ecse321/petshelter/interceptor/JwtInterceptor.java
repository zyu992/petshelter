package ca.mcgill.ecse321.petshelter.interceptor;

import ca.mcgill.ecse321.petshelter.utils.CommonException;
import ca.mcgill.ecse321.petshelter.utils.ResultCode;
import ca.mcgill.ecse321.petshelter.utils.TokenUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private TokenUtil tokenUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("Authorization");
        if(!StringUtils.isEmpty(authorization) && authorization.startsWith("Bearer")){
            String token = authorization.replace("Bearer", "");
            Claims claims = TokenUtil.validateJWT(token);
            if (claims != null){
                request.setAttribute("user_claims", claims);
                return true;
            }
        }
        throw new CommonException(ResultCode.UNAUTHENTICATED);
    }

}
