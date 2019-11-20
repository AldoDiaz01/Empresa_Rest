package org.uv.web.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Kronoz
 */
@javax.ws.rs.ApplicationPath("empresa")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(org.uv.web.rest.DepartamentoResource.class);
        resources.add(org.uv.web.rest.EmpleadoResource.class);
    }

}
