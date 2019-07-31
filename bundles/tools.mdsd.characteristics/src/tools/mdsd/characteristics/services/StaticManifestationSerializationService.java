package tools.mdsd.characteristics.services;

import tools.mdsd.characteristics.valuetype.ValueType;
import tools.mdsd.somde.services.Service;
import tools.mdsd.somde.services.annotations.DispatchOnce;

public interface StaticManifestationSerializationService extends Service<StaticManifestationSerializationService> {
    
    @DispatchOnce
    String serializeStatic(ValueType valueType, Object value);
    
    @DispatchOnce
    Object deserializeStatic(ValueType valueType, String storage);

}
