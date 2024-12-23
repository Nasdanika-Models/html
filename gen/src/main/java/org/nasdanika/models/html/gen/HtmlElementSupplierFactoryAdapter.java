package org.nasdanika.models.html.gen;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.nasdanika.common.Context;
import org.nasdanika.common.Supplier;
import org.nasdanika.common.SupplierFactory;

public abstract class HtmlElementSupplierFactoryAdapter<M extends org.nasdanika.models.html.HtmlElement, T extends org.nasdanika.html.HTMLElement<?>> extends HtmlElementAdapter<M,T> implements SupplierFactory<T> {
	
	protected HtmlElementSupplierFactoryAdapter(M htmlElement, AdapterFactory adapterFactory) {
		super(htmlElement, adapterFactory);
	}
	
	@Override
	public boolean isAdapterForType(Object type) {
		return type == SupplierFactory.class;
	}
		
	/**
	 * Creates element from content.
	 * @param context
	 * @return
	 */
	protected abstract Supplier<T> createHTMLElementSupplier(Context context);
	
	@Override
	public Supplier<T> create(Context context){
		SupplierFactory<T> elementSupplierFactory = this::createHTMLElementSupplier;
		return elementSupplierFactory.then(this::createConfigureFunction).create(context);
	}	
	
}
