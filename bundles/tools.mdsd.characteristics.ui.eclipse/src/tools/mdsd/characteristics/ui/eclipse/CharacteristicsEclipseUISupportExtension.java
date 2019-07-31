package tools.mdsd.characteristics.ui.eclipse;

import java.util.Collections;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import tools.mdsd.somde.realm.RealmPackage;

public class CharacteristicsEclipseUISupportExtension {

    private CharacteristicsEclipseUISupportExtension() {}

    public static final String PLUGIN_ID = "tools.mdsd.characteristics.ui.eclipse";

    public static void loadModelingRealm(IResource resource, ResourceSet resourceSet) {
        try {
            IProject project = resource.getProject();
            if (project.getDescription().hasNature(CharacteristicsEnabledProjectNature.NATURE_ID)) {
                String uri = new ProjectScope(project)
                        .getNode(CharacteristicsEnabledProjectNature.NATURE_ID)
                        .get(CharacteristicsEnabledProjectNature.MODELING_REAL_MODEL_URI_CONFIGURATION_STRING,
                                null);
                if (uri == null) {
                    // TODO handle case of incomplete configuration
                    return;
                }
                URI realmModelUri = URI.createURI(uri);
                if (realmModelUri == null || !resourceSet.getURIConverter().exists(realmModelUri,
                        Collections.emptyMap())) {
                    // TODO handle case of incomplete configuration
                    return;
                }
                if (!validateModelingRealm(realmModelUri)) {
                    // TODO handle case of invalid model
                    return;
                }
                resourceSet.getResource(realmModelUri, true);
            }
        } catch (CoreException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean validateModelingRealm(URI uri) {
        ResourceSet set = new ResourceSetImpl();
        Resource res = set.getResource(uri, true);

        return validateModelingRealm(res);
    }
    
    public static boolean validateModelingRealm(Resource res) {
        return !res.getContents().isEmpty()
                && RealmPackage.eINSTANCE.getServiceOrientedModelingRealm()
                        .isInstance(res.getContents().get(0))
                && (Diagnostician.INSTANCE.validate(res.getContents().get(0)).getSeverity()
                        & Diagnostic.OK) == Diagnostic.OK;
    }
    
        

}
