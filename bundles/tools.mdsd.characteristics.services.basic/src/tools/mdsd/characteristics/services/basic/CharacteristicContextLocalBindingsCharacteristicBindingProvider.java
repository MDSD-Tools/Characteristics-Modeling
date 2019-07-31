package tools.mdsd.characteristics.services.basic;

import static tools.mdsd.somde.services.Defaults.Argument;
import static tools.mdsd.somde.services.Defaults.INSTANCEOF_FILTER;
import java.util.Collection;
import org.eclipse.emf.ecore.EObject;
import tools.mdsd.characteristics.binding.CharacteristicBinding;
import tools.mdsd.characteristics.binding.CharacterizationContext;
import tools.mdsd.characteristics.services.CharacteristicBindingProvider;
import tools.mdsd.somde.services.ServiceRegistrationFacade;

public class CharacteristicContextLocalBindingsCharacteristicBindingProvider
        implements CharacteristicBindingProvider {

    @Override
    public Collection<CharacteristicBinding> provideCharacteristicBindings(EObject characterizable) {
        return ((CharacterizationContext)characterizable).getLocalBindings();
    }

    @Override
    public void registerService(ServiceRegistrationFacade<CharacteristicBindingProvider> facade) {
        facade.using(INSTANCEOF_FILTER).when(Argument(0)).matches(CharacterizationContext.class);
    }

}
