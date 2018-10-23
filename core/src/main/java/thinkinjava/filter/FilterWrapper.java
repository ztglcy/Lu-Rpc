package thinkinjava.filter;

import thinkinjava.core.Invoker;
import thinkinjava.core.ServiceConfig;
import thinkinjava.rpc.Request;
import thinkinjava.rpc.Response;

/**
 * @author 莫那·鲁道
 * @date 2018/10/16-下午5:01
 */
public class FilterWrapper implements Invoker {

    private Filter filter;

    private Invoker next;

    private ServiceConfig config;

    public FilterWrapper(Filter filter, Invoker next) {
        this.next = next;
        this.filter = filter;
        this.config = next.getConfig();
    }


    public Response invoke(Request args) {
        if (filter != null) {
            return filter.filter(next, args);
        } else {
            return next.invoke(args);
        }
    }

    public ServiceConfig getConfig() {
        return config;
    }
}
