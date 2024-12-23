package org.nasdanika.models.html.gen;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.common.Context;
import org.nasdanika.common.ExecutionException;
import org.nasdanika.common.Function;
import org.nasdanika.common.FunctionFactory;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.common.Supplier;
import org.nasdanika.common.SupplierFactory;
import org.nasdanika.common.Util;
import org.nasdanika.emf.EObjectAdaptable;
import org.nasdanika.exec.content.Filter;
import org.nasdanika.html.HTMLFactory;
import org.nasdanika.html.TagName;
import org.nasdanika.models.html.Script;

public class ScriptSupplierFactoryAdapter extends AdapterImpl implements SupplierFactory<org.nasdanika.html.Tag> {
	
	protected ScriptSupplierFactoryAdapter(Script script) {
		setTarget(script);
	}
	
	private FunctionFactory<InputStream,org.nasdanika.html.Tag> filterFactory = ctx -> new Function<InputStream, org.nasdanika.html.Tag>() {

		@Override
		public double size() {
			return 1;
		}

		@Override
		public String name() {
			return "Script";
		}

		@Override
		public org.nasdanika.html.Tag execute(InputStream input, ProgressMonitor progressMonitor) {
			HTMLFactory htmlFactory = ctx.get(HTMLFactory.class, HTMLFactory.INSTANCE);
			try {
				return htmlFactory.tag(TagName.script, Util.toString(ctx, input));
			} catch (IOException e) {
				throw new ExecutionException(e, this);
			}
		}
		
	};
		
	@Override
	public Supplier<org.nasdanika.html.Tag> create(Context context) {
		EObject source = ((Filter) getTarget()).getSource();
		SupplierFactory<InputStream> ssf = Objects.requireNonNull(EObjectAdaptable.adaptToSupplierFactory(source, InputStream.class), "Cannot adapt to SupplierFactory: " + source);
		return ssf.then(filterFactory).create(context);
	}

}

