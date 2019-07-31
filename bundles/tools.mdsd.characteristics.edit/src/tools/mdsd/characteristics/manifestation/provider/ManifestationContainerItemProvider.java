/**
 */
package tools.mdsd.characteristics.manifestation.provider;


import java.util.Collection;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;
import tools.mdsd.characteristics.manifestation.ManifestationPackage;

/**
 * This is the item provider adapter for a {@link tools.mdsd.characteristics.binding.ManifestationContainer} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ManifestationContainerItemProvider 
	extends ManifestationContainerItemProviderGen
{
	/**
	 * This constructs an instance from a factory and a notifier.
	 */
	public ManifestationContainerItemProvider(AdapterFactory adapterFactory)
	{
		super(adapterFactory);
	}

	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null)
		{
			super.getChildrenFeatures(object);
			childrenFeatures.remove(ManifestationPackage.Literals.MANIFESTATION_CONTAINER__MANIFESTATION);
		}
		return childrenFeatures;
	}
	
	

}
