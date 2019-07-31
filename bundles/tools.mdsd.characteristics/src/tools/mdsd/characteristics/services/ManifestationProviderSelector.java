package tools.mdsd.characteristics.services;

import org.eclipse.emf.ecore.EObject;
import tools.mdsd.characteristics.binding.CharacteristicBinding;
import tools.mdsd.characteristics.characteristic.Characteristic;

public interface ManifestationProviderSelector {

    ManifestationProvider selectProvider(Characteristic characteristic, EObject characterizable,
            CharacteristicBinding binding);

}
