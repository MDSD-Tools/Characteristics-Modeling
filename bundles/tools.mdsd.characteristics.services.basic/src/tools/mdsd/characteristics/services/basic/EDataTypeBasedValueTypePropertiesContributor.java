package tools.mdsd.characteristics.services.basic;

import static tools.mdsd.somde.services.Defaults.Argument;
import static tools.mdsd.somde.services.Defaults.ECLASS_FILTER;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import tools.mdsd.characteristics.properties.basic.BasicPackage;
import tools.mdsd.characteristics.services.ValueTypePropertyContributor;
import tools.mdsd.characteristics.valuetype.ValueType;
import tools.mdsd.characteristics.valuetype.ValuetypePackage;
import tools.mdsd.somde.services.ServiceRegistrationFacade;

public class EDataTypeBasedValueTypePropertiesContributor implements ValueTypePropertyContributor {

    private static final Collection<Class<?>> CONTRIBUTED_PROPERTIES = Collections
            .unmodifiableList(Arrays.asList(BasicPackage.eINSTANCE.getEDataTypeBased().getClass()));

    @Override
    public Collection<Class<?>> collectProperties(ValueType valueType) {
        return CONTRIBUTED_PROPERTIES;
    }

    @Override
    public void registerService(ServiceRegistrationFacade<ValueTypePropertyContributor> facade) {
        facade.using(ECLASS_FILTER).when(Argument(1))
                .matches(ValuetypePackage.eINSTANCE.getEDataTypeValueType());
    }

}
