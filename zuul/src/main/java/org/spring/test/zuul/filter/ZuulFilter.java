package org.spring.test.zuul.filter;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: tanyang
 * @Date: 2019/9/4 12:10
 */
@Component
public class ZuulFilter extends com.netflix.zuul.ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String accessToken = request.getParameter("accessToken");
        if(accessToken == null || "".equals(accessToken)) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        return null;
    }
}
