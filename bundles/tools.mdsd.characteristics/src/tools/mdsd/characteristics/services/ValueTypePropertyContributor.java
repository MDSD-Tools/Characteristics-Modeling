package tools.mdsd.characteristics.services;

import java.util.Collection;
import tools.mdsd.characteristics.valuetype.ValueType;
import tools.mdsd.somde.services.Service;
import tools.mdsd.somde.services.annotations.DispatchAll;

public interface ValueTypePropertyContributor extends Service<ValueTypePropertyContributor> {
    
    @DispatchAll
    Collection<Class<?>> collectProperties(ValueType valueType);

}
