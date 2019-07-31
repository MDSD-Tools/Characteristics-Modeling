package tools.mdsd.characteristics.valuetype.provider;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import tools.mdsd.characteristics.CharacteristicsEditPlugin;
import tools.mdsd.characteristics.properties.basic.EDataTypeBased;
import tools.mdsd.characteristics.valuetype.ValueType;

public class ValueTypeEClassifierWrapper implements EClassifier, EGenericType {

    protected ValueType valueType;

    public ValueTypeEClassifierWrapper(ValueType valueType) {
        this.valueType = valueType;
    }

    @Override
    public String getName() {
        return valueType.getEntityName();
    }

    @Override
    public void setName(String value) {
        throw new UnsupportedOperationException(CharacteristicsEditPlugin.INSTANCE
                .getString("_Exception_No_set_on_value_type_properties"));
    }

    @Override
    public EList<EAnnotation> getEAnnotations() {
        return valueType.eClass().getEAnnotations();
    }

    @Override
    public EAnnotation getEAnnotation(String source) {
        return valueType.eClass().getEAnnotation(source);
    }

    @Override
    public EClass eClass() {
        return this.valueType.eClass();
    }

    @Override
    public Resource eResource() {
        return this.valueType.eResource();
    }

    @Override
    public EObject eContainer() {
        return this.valueType.eContainer();
    }

    @Override
    public EStructuralFeature eContainingFeature() {
        return this.valueType.eContainingFeature();
    }

    @Override
    public EReference eContainmentFeature() {
        return this.valueType.eContainmentFeature();
    }

    @Override
    public EList<EObject> eContents() {
        return this.valueType.eContents();
    }

    @Override
    public TreeIterator<EObject> eAllContents() {
        return this.valueType.eAllContents();
    }

    @Override
    public boolean eIsProxy() {
        return this.valueType.eIsProxy();
    }

    @Override
    public EList<EObject> eCrossReferences() {
        return this.valueType.eCrossReferences();
    }

    @Override
    public Object eGet(EStructuralFeature feature) {
        return this.valueType.eGet(feature);
    }

    @Override
    public Object eGet(EStructuralFeature feature, boolean resolve) {
        return this.valueType.eGet(feature, resolve);
    }

    @Override
    public void eSet(EStructuralFeature feature, Object newValue) {
        throw new UnsupportedOperationException(CharacteristicsEditPlugin.INSTANCE
                .getString("_Exception_No_set_on_value_type_properties"));
    }

    @Override
    public boolean eIsSet(EStructuralFeature feature) {
        return this.valueType.eIsSet(feature);
    }

    @Override
    public void eUnset(EStructuralFeature feature) {
        throw new UnsupportedOperationException(CharacteristicsEditPlugin.INSTANCE
                .getString("_Exception_No_set_on_value_type_properties"));
    }

    @Override
    public Object eInvoke(EOperation operation, EList<?> arguments)
            throws InvocationTargetException {
        return null;
    }

    @Override
    public EList<Adapter> eAdapters() {
        return this.valueType.eAdapters();
    }

    @Override
    public boolean eDeliver() {
        return this.valueType.eDeliver();
    }

    @Override
    public void eSetDeliver(boolean deliver) {
        throw new UnsupportedOperationException(CharacteristicsEditPlugin.INSTANCE
                .getString("_Exception_No_set_on_value_type_properties"));
    }

    @Override
    public void eNotify(Notification notification) {
        this.valueType.eNotify(notification);
    }

    @Override
    public String getInstanceClassName() {
        return null;
    }

    @Override
    public void setInstanceClassName(String value) {
        throw new UnsupportedOperationException(CharacteristicsEditPlugin.INSTANCE
                .getString("_Exception_No_set_on_value_type_properties"));
    }

    @Override
    public Class<?> getInstanceClass() {
        return null;
    }

    @Override
    public void setInstanceClass(Class<?> value) {
        throw new UnsupportedOperationException(CharacteristicsEditPlugin.INSTANCE
                .getString("_Exception_No_set_on_value_type_properties"));
    }

    @Override
    public Object getDefaultValue() {
        // TODO fix once properties work
        /*
         * if (this.valueType.hasProperty(ValueTypeWithDefaultValue.class)) { return
         * this.valueType.getProperty(ValueTypeWithDefaultValue.class).getDefaultValue(); }
         */
        return null;
    }

    @Override
    public String getInstanceTypeName() {
        return null;
    }

    @Override
    public void setInstanceTypeName(String value) {
        throw new UnsupportedOperationException(CharacteristicsEditPlugin.INSTANCE
                .getString("_Exception_No_set_on_value_type_properties"));
    }

    @Override
    public EPackage getEPackage() {
        return null;
    }

    @Override
    public EList<ETypeParameter> getETypeParameters() {
        return new BasicInternalEList<>(ETypeParameter.class);
    }

    @Override
    public boolean isInstance(Object object) {
        return this.valueType.adheresToValueType(object);
    }

    @Override
    public int getClassifierID() {
        return -1;
    }

    @Override
    public EGenericType getEUpperBound() {
        // Currently we do not support generic value types
        return null;
    }

    @Override
    public void setEUpperBound(EGenericType value) {
        throw new UnsupportedOperationException(CharacteristicsEditPlugin.INSTANCE
                .getString("_Exception_No_set_on_value_type_properties"));
    }

    @Override
    public EList<EGenericType> getETypeArguments() {
        return new BasicEList<EGenericType>(0);
    }

    @Override
    public EClassifier getERawType() {
        if (this.valueType.hasProperty(EDataTypeBased.class)) {
            EDataTypeBased property = this.valueType.getProperty(EDataTypeBased.class);
            return property.getDataType();
        } else
            return null;
    }

    @Override
    public EGenericType getELowerBound() {
        // //Currently we do not support generic value types
        return null;
    }

    @Override
    public void setELowerBound(EGenericType value) {
        throw new UnsupportedOperationException(CharacteristicsEditPlugin.INSTANCE
                .getString("_Exception_No_set_on_value_type_properties"));
    }

    @Override
    public ETypeParameter getETypeParameter() {
        // Currently we do not support generic value types
        return null;
    }

    @Override
    public void setETypeParameter(ETypeParameter value) {
        throw new UnsupportedOperationException(CharacteristicsEditPlugin.INSTANCE
                .getString("_Exception_No_set_on_value_type_properties"));
    }

    @Override
    public EClassifier getEClassifier() {
        return this;
    }

    @Override
    public void setEClassifier(EClassifier value) {
        throw new UnsupportedOperationException(CharacteristicsEditPlugin.INSTANCE
                .getString("_Exception_No_set_on_value_type_properties"));
    }

}
