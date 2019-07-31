package tools.mdsd.characteristics.characteristic.provider;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.impl.EStructuralFeatureImpl;
import tools.mdsd.characteristics.binding.BindingPackage;
import tools.mdsd.characteristics.characteristic.Characteristic;
import tools.mdsd.characteristics.properties.basic.EDataTypeBased;
import tools.mdsd.characteristics.valuetype.provider.ValueTypeEClassifierWrapper;

public class CharacteristicBasedVirtualStructuralFeature extends EStructuralFeatureImpl {

    private Characteristic characteristic;

    public CharacteristicBasedVirtualStructuralFeature(Characteristic characteristic) {
        this.characteristic = characteristic;
    }

    @Override
    public boolean isOrdered() {
        return false;
    }

    @Override
    public void setOrdered(boolean value) {
        throw new UnsupportedOperationException(
                "This structural feature solely acts as view on a characteristic");
    }

    @Override
    public boolean isUnique() {
        return true;
    }

    @Override
    public void setUnique(boolean value) {
        throw new UnsupportedOperationException(
                "This structural feature solely acts as view on a characteristic");
    }

    @Override
    public int getLowerBound() {
        // TODO Check property for being multi-valued and validate upper bound
        return 0;
    }

    @Override
    public void setLowerBound(int value) {
        throw new UnsupportedOperationException(
                "This structural feature solely acts as view on a characteristic");
    }

    @Override
    public int getUpperBound() {
        // TODO Check property for being multi-valued and validate upper bound
        return 0;
    }

    @Override
    public void setUpperBound(int value) {
        throw new UnsupportedOperationException(
                "This structural feature solely acts as view on a characteristic");
    }

    @Override
    public boolean isMany() {
        // TODO Check if is multi-valued characteristic
        return false;
    }

    @Override
    public boolean isRequired() {
        // TODO Check if characterization is necessary
        return false;
    }

    @Override
    public EClassifier getEType() {
        if (this.characteristic.getValueType().hasProperty(EDataTypeBased.class)) {
            EDataTypeBased property =
                    this.characteristic.getValueType().getProperty(EDataTypeBased.class);
            return property.getDataType();
        }
        return new ValueTypeEClassifierWrapper(this.characteristic.getValueType());
    }

    @Override
    public void setEType(EClassifier value) {
        throw new UnsupportedOperationException(
                "This structural feature solely acts as view on a characteristic");
    }

    @Override
    public EGenericType getEGenericType() {
        return new ValueTypeEClassifierWrapper(this.characteristic.getValueType());
    }

    @Override
    public void setEGenericType(EGenericType value) {
        throw new UnsupportedOperationException(
                "This structural feature solely acts as view on a characteristic");
    }

    @Override
    public String getName() {
        return this.characteristic.getEntityName();
    }

    @Override
    public void setName(String value) {
        throw new UnsupportedOperationException(
                "This structural feature solely acts as view on a characteristic");
    }

    @Override
    public boolean isTransient() {
        return true;
    }

    @Override
    public void setTransient(boolean value) {
        throw new UnsupportedOperationException(
                "This structural feature solely acts as view on a characteristic");
    }

    @Override
    public boolean isVolatile() {
        return true;
    }

    @Override
    public void setVolatile(boolean value) {
        throw new UnsupportedOperationException(
                "This structural feature solely acts as view on a characteristic");
    }

    @Override
    public boolean isChangeable() {
        return true;
    }

    @Override
    public void setChangeable(boolean value) {
        throw new UnsupportedOperationException(
                "This structural feature solely acts as view on a characteristic");
    }

    @Override
    public String getDefaultValueLiteral() {
        // TODO Get default value for value type via Property
        return null;
    }

    @Override
    public void setDefaultValueLiteral(String value) {
        throw new UnsupportedOperationException(
                "This structural feature solely acts as view on a characteristic");
    }

    @Override
    public Object getDefaultValue() {
        // TODO Get default value for value type via Property
        return null;
    }

    @Override
    public void setDefaultValue(Object value) {
        throw new UnsupportedOperationException(
                "This structural feature solely acts as view on a characteristic");
    }

    @Override
    public boolean isUnsettable() {
        // TODO: Check if characteristic is mandatory for object characterizable
        return true;
    }

    @Override
    public void setUnsettable(boolean value) {
        throw new UnsupportedOperationException(
                "This structural feature solely acts as view on a characteristic");
    }

    @Override
    public boolean isDerived() {
        return true;
    }

    @Override
    public void setDerived(boolean value) {
        throw new UnsupportedOperationException(
                "This structural feature solely acts as view on a characteristic");
    }

    @Override
    public EClass getEContainingClass() {
        return BindingPackage.eINSTANCE.getCharacterizationContext();
    }

    @Override
    public Class<?> getContainerClass() {
        return BindingPackage.eINSTANCE.getCharacterizationContext().getInstanceClass();
    }

    public Characteristic getCharacteristic() {
        return characteristic;
    }

}
