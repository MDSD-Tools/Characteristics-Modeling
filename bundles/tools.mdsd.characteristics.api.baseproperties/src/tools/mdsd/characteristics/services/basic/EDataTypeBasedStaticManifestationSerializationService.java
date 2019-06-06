package tools.mdsd.characteristics.services.basic;

import static tools.mdsd.characteristics.services.Defaults.Argument;
import static tools.mdsd.characteristics.services.Defaults.ECLASS_FILTER;
import org.eclipse.emf.ecore.EDataType;
import tools.mdsd.characteristics.properties.basic.EDataTypeBased;
import tools.mdsd.characteristics.services.ServiceRegistrationFacade;
import tools.mdsd.characteristics.services.api.StaticManifestationSerializationService;
import tools.mdsd.characteristics.valuetype.ValueType;
import tools.mdsd.characteristics.valuetype.ValuetypePackage;

public class EDataTypeBasedStaticManifestationSerializationService
        implements StaticManifestationSerializationService {

    public String serializeStatic(ValueType valueType, Object manifestationObject) {
        EDataType dataType = valueType.getProperty(EDataTypeBased.class).getDataType();
        return dataType.getEPackage().getEFactoryInstance().convertToString(dataType,
                manifestationObject);
    }

    @Override
    public Object deserializeStatic(ValueType valueType, String serialized) {
        EDataType dataType = valueType.getProperty(EDataTypeBased.class).getDataType();
        return dataType.getEPackage().getEFactoryInstance().createFromString(dataType, serialized);
    }

    @Override
    public void registerService(
            ServiceRegistrationFacade<StaticManifestationSerializationService> facade) {
        facade.using(ECLASS_FILTER).when(Argument(0))
                .matches(ValuetypePackage.eINSTANCE.getEDataTypeValueType()).register(this);
    }
}
