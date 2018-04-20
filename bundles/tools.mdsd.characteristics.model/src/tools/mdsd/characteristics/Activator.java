package tools.mdsd.characteristics;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import tools.mdsd.characteristics.support.ModelingRealmManagement;

public class Activator extends Plugin {
	
	// The shared instance
    private static Activator plugin;
    
    private BundleContext bundleContext = null;
    
    /**
     * The constructor
     */
    public Activator() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
     */
    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        bundleContext = context;
        plugin = this;
        
        startModelRealmManagement();
    }

    private void startModelRealmManagement() {
		ServiceReference<ModelingRealmManagement> serviceReference = this.bundleContext.getServiceReference(ModelingRealmManagement.class);
		this.bundleContext.getService(serviceReference);
	}

	/*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
     */
    @Override
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        bundleContext = null;
        super.stop(context);
    }

    /**
     * Returns the shared instance
     *
     * @return the shared instance
     */
    public static Activator getDefault() {
        return plugin;
    }

}
