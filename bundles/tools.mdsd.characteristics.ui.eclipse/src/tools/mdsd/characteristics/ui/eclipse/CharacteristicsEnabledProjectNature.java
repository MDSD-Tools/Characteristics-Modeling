package tools.mdsd.characteristics.ui.eclipse;

import java.io.IOException;
import java.util.Collections;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.osgi.service.prefs.BackingStoreException;
import tools.mdsd.somde.realm.RealmFactory;

public class CharacteristicsEnabledProjectNature implements IProjectNature {
    // ID of the natures, which consists of Bundle-SymbolicName + ID
    public static final String NATURE_ID =
            "tools.mdsd.characteristics.ui.eclipse.characteristicsenabled";
    public static final String MODELING_REAL_MODEL_URI_CONFIGURATION_STRING =
            "tools.mdsd.characteristics.ui.eclipse.characteristicsenabled.realmModelUri";

    private IProject project;

    @Override
    public void configure() throws CoreException {
        IScopeContext scope = new ProjectScope(project);
        IEclipsePreferences projectPrefs = scope.getNode(NATURE_ID);
        if (projectPrefs == null) {
            throw new CoreException(
                    new Status(IStatus.ERROR, CharacteristicsEclipseUISupportExtension.PLUGIN_ID,
                            "Configuration of nature specific preferences failed."));
        }

        String filepath = projectPrefs.get(MODELING_REAL_MODEL_URI_CONFIGURATION_STRING,
                String.format("platform:/resource/%s/project.modelingrealm", project.getName()));
        URI uri = URI.createURI(filepath);

        ResourceSet rset = new ResourceSetImpl();
        Resource res = null;
        if (rset.getURIConverter().exists(uri, Collections.emptyMap())) {
            res = rset.getResource(uri, true);
        } else {
            res = rset.createResource(uri);
        }

        if (res.getContents().size() == 0) {
            // TODO copy template model
            res.getContents().add(RealmFactory.eINSTANCE.createServiceOrientedModelingRealm());
        } else if (!CharacteristicsEclipseUISupportExtension.validateModelingRealm(res)) {
            throw new CoreException(
                    new Status(IStatus.ERROR, CharacteristicsEclipseUISupportExtension.PLUGIN_ID,
                            "Invalid modeling realm model. Model validation failed"));
        }

        try {
            res.save(Collections.emptyMap());
            projectPrefs.put(MODELING_REAL_MODEL_URI_CONFIGURATION_STRING, filepath);
            projectPrefs.flush();

        } catch (BackingStoreException e) {
            throw new CoreException(
                    new Status(IStatus.ERROR, CharacteristicsEclipseUISupportExtension.PLUGIN_ID,
                            "The nature could not be added properly.", e));
        } catch (IOException e) {
            throw new CoreException(
                    new Status(IStatus.ERROR, CharacteristicsEclipseUISupportExtension.PLUGIN_ID,
                            "The model could not be stored.", e));
        }
    }

    @Override
    public void deconfigure() throws CoreException {
        IScopeContext scope = new ProjectScope(project);
        IEclipsePreferences projectPrefs = scope.getNode(NATURE_ID);
        try {
            projectPrefs.removeNode();
        } catch (BackingStoreException e) {
            throw new CoreException(
                    new Status(IStatus.ERROR, CharacteristicsEclipseUISupportExtension.PLUGIN_ID,
                            "The nature could not be removed properly.", e));
        }
    }

    @Override
    public IProject getProject() {
        return project;
    }

    @Override
    public void setProject(IProject project) {
        this.project = project;
    }

}
