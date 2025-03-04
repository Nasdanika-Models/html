/**
 */
package org.nasdanika.models.html.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;
import org.nasdanika.models.html.HtmlElement;
import org.nasdanika.models.html.HtmlPackage;
import org.nasdanika.ncore.impl.ModelElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.models.html.impl.HtmlElementImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.nasdanika.models.html.impl.HtmlElementImpl#getContent <em>Content</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class HtmlElementImpl extends ModelElementImpl implements HtmlElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HtmlElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HtmlPackage.Literals.HTML_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EMap<String, EObject> getAttributes() {
		return (EMap<String, EObject>)eDynamicGet(HtmlPackage.HTML_ELEMENT__ATTRIBUTES, HtmlPackage.Literals.HTML_ELEMENT__ATTRIBUTES, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<EObject> getContent() {
		return (EList<EObject>)eDynamicGet(HtmlPackage.HTML_ELEMENT__CONTENT, HtmlPackage.Literals.HTML_ELEMENT__CONTENT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HtmlPackage.HTML_ELEMENT__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case HtmlPackage.HTML_ELEMENT__CONTENT:
				return ((InternalEList<?>)getContent()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case HtmlPackage.HTML_ELEMENT__ATTRIBUTES:
				if (coreType) return getAttributes();
				else return getAttributes().map();
			case HtmlPackage.HTML_ELEMENT__CONTENT:
				return getContent();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case HtmlPackage.HTML_ELEMENT__ATTRIBUTES:
				((EStructuralFeature.Setting)getAttributes()).set(newValue);
				return;
			case HtmlPackage.HTML_ELEMENT__CONTENT:
				getContent().clear();
				getContent().addAll((Collection<? extends EObject>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case HtmlPackage.HTML_ELEMENT__ATTRIBUTES:
				getAttributes().clear();
				return;
			case HtmlPackage.HTML_ELEMENT__CONTENT:
				getContent().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case HtmlPackage.HTML_ELEMENT__ATTRIBUTES:
				return !getAttributes().isEmpty();
			case HtmlPackage.HTML_ELEMENT__CONTENT:
				return !getContent().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //HtmlElementImpl
