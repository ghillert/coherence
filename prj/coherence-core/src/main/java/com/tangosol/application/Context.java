package com.tangosol.application;

import com.tangosol.net.CacheFactoryBuilder;
import com.tangosol.net.ConfigurableCacheFactory;
import com.tangosol.net.ServiceMonitor;

/**
 * Context represents various aspects of Coherence infrastructure that could be
 * accessed by application code working in the context of the {@link ContainerAdapter}.
 *
 * @author cf 2011.07.01
 * @since Coherence 12.1.2
 */
public interface Context
    {
    /**
     * Return the corresponding {@link ConfigurableCacheFactory}. This method
     * will return the same reference as a call to
     * <pre>
     *    ctx.getExtendedContext().getCacheFactoryBuilder().
     *      getConfigurableCacheFactory(ctx.getClassLoader());
     * </pre>
     *
     * @return the {@link ConfigurableCacheFactory}
     */
    public ConfigurableCacheFactory getConfigurableCacheFactory();

    /**
     * Return the {@link CacheFactoryBuilder} in use.
     *
     * @return the {@link CacheFactoryBuilder}
     */
    public CacheFactoryBuilder getCacheFactoryBuilder();

    /**
     * Return the {@link ClassLoader} in use.
     *
     * @return the {@link ClassLoader}
     */
    public ClassLoader getClassLoader();

    /**
     * Return the name of the application.
     *
     * @return the name of the application
     */
    public String getApplicationName();

    /**
     * Return the keep-alive facility for the application services.
     *
     * @return the {@link ServiceMonitor}
     */
    public ServiceMonitor getServiceMonitor();

    /**
     * Return the POF configuration URI.
     * <p>
     * For advanced use cases, the resource identified by this URI can be found
     * by calling:
     * <pre>
     *    ctx.getExtendedContext().getClassLoader().getResource(ctx.getPofConfigUri());
     * </pre>
     *
     * @return the POF configuration URI
     */
    public String getPofConfigURI();

    /**
     * Return the cache configuration URI.
     *
     * @return the cache configuration URI
     */
    public String getCacheConfigURI();

    /**
     * Return the {@link ContainerContext} associated with the ContainerAdapter.
     *
     * @return the {@link ContainerContext} instance or null
     */
    public ContainerContext getContainerContext();

     /**
      * @deprecated as useless, left for backward compatibility only
      *
      * @return the {@link ExtendedContext}
      */
    public ExtendedContext getExtendedContext();


    // ----- inner interface ExtendedContext --------------------------------

    /**
     * The {@link ExtendedContext} contains parameters that may be used for
     * advanced creation and management of {@link ConfigurableCacheFactory} instances.
     *
     * @author cf 2011.07.01
     *
     * @deprecated as of 12.2.1, left only for backward compatibility
     */
    public interface ExtendedContext
            extends Context
        {
        }
    }
