package tools.mdsd.characteristics.services;

import java.util.Collection;
import org.eclipse.emf.ecore.EObject;
import tools.mdsd.characteristics.binding.CharacteristicBinding;
import tools.mdsd.somde.services.Service;
import tools.mdsd.somde.services.annotations.DispatchAll;

public interface CharacteristicBindingProvider extends Service<CharacteristicBindingProvider> {
    
    @DispatchAll
    Collection<CharacteristicBinding> provideCharacteristicBindings(EObject characterizable);

}
