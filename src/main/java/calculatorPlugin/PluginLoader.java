package calculatorPlugin;

import dynamic.IPluginLoader;
import dynamic.IServlet;
import dynamic.PluginRouter;
import calculatorHandlers.CalculatorServlet;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Davis on 2/12/2017.
 */
public class PluginLoader implements IPluginLoader {

    public static final Path basePath = Paths.get("/UserID/");

    public void init(PluginRouter router, String rootDirectory) {
        IServlet servlet = new CalculatorServlet();
        router.addRoute(basePath, servlet);
    }

    @Override
    public void unload(PluginRouter router) {
        router.removeRoute(basePath);
    }
}
