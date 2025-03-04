package org.nasdanika.models.html.gen;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.nasdanika.common.Consumer;
import org.nasdanika.common.ConsumerFactory;
import org.nasdanika.common.Context;
import org.nasdanika.common.FunctionFactory;
import org.nasdanika.common.ProgressMonitor;

public class HtmlElementConsumerFactoryAdapter<M extends org.nasdanika.models.html.HtmlElement, T extends org.nasdanika.html.HTMLElement<?>> extends HtmlElementAdapter<M,T> implements ConsumerFactory<T> {
	
	protected HtmlElementConsumerFactoryAdapter(M htmlElement, AdapterFactory adapterFactory) {
		super(htmlElement, adapterFactory);
	}
	
	@Override
	public boolean isAdapterForType(Object type) {
		return type == ConsumerFactory.class;
	}
	
	protected Consumer<T> createConsumer(Context context) {
		return new Consumer<T>() {

			@Override
			public double size() {
				return 1;
			}

			@Override
			public String name() {
				return "HTML Element Consumer";
			}

			@Override
			public void execute(T htmlElement, ProgressMonitor progressMonitor) {
				HtmlElementConsumerFactoryAdapter.this.build(htmlElement, context, progressMonitor);				
			}
		};
	};
	
	/**
	 * Builds HTML element. This implementation does nothing.
	 * @param htmlElement
	 * @param progressMonitor
	 */
	protected void build(T htmlElement, Context context, ProgressMonitor progressMonitor) {}	
	
	@Override
	public Consumer<T> create(Context context) {
		FunctionFactory<T,T> configureFunctionFactory = this::createConfigureFunction;
		ConsumerFactory<T> consumerFactory = this::createConsumer;
		return configureFunctionFactory.then(consumerFactory).create(context);
	}		

}
