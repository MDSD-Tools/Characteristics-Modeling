package tools.mdsd.characteristics.services;

import tools.mdsd.characteristics.valuetype.ValueType;
import tools.mdsd.somde.services.Service;
import tools.mdsd.somde.services.annotations.DispatchOnce;

public interface ValueTypePropertyProvider extends Service<ValueTypePropertyProvider> {
    @DispatchOnce
    <T> T getProperty(Class<T> propertyType, ValueType valueType);

}
